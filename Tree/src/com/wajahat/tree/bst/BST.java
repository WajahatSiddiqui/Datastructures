package com.wajahat.tree.bst;

import java.util.ArrayList;
import java.util.List;

public class BST {
	
	private TreeNode root;
	private int size;
	
	public BST() {
		size = 0;
	}
	
	public void insert(int data) {
		root = insert(root, data);
		size++;
	}
	
	public int size() { return size; }
	
	private TreeNode insert(TreeNode root, Integer data) {
		if (root == null) {
			root = new TreeNode(data);
			return root;
		}
		
		if (data <= root.data) {
			root.left = insert(root.left, data);
		} else {
			root.right = insert(root.right, data);
		}
		return root;
	}
	
	public boolean contains(int data) {
		return contains(root, data);
	}
	
	private boolean contains(TreeNode root, int data) {
		if (root == null) {
			return false;
		}
		
		if (root.data == data) {
			return true;
		}
		
		if (data <= root.data) {
			return contains(root.left, data);
		} else {
			return contains(root.right, data);
		}
	}
	
	public List<Integer> inorder() {
		List<Integer> list = new ArrayList<>(size);
		inorder(root, list);
		return list;
	}
	
	private void inorder(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		inorder(root.left, list);
		System.out.printf("%d ", root.data);
		list.add(root.data);
		inorder(root.right, list);
	}
	
	public void delete(int data) {
		root = delete(root, data);
		size--;
	}
	
	private TreeNode minNode(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode curr = root;
		if (curr.left != null) {
			curr = curr.left;
		}
		return curr;
	}
	
	private TreeNode delete(TreeNode root, int data) {
		if (root == null) {
			return root;
		}
		
		if (root.data == data) {
			// leaf node
			if (root.left == null && root.right == null) {
				root = null;
				return root;
			} else if (root.left == null) {
				return root.right;				
			} else if (root.right == null) {
				return root.left;
			}
			TreeNode minNode = minNode(root.right);
			root.data = minNode.data;
			root.right = delete(root.right, minNode.data);
		}
		
		if (data <= root.data) {
			root.left = delete(root.left, data);
		} else {
			root.right = delete(root.right, data);
		}
		return root;
	}
}

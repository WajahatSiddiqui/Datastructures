package com.wajahat.datastructure.symboltable;

import java.util.Scanner;

public class SymbolTableClient {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SymbolTable<Character, Integer> symbolTable = new ElementarySymbolTable<Character, Integer>();
		Integer i = 0;
		String str = scanner.next();
		for (char c : str.toCharArray()) {
			symbolTable.put(c, i++);
		}
		
		System.out.println(symbolTable);
		scanner.close();
	}
}

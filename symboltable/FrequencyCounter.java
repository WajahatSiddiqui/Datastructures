package com.wajahat.datastructure.symboltable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Finds the maximum frequency of words in a given file
 * @author Wajahat
 */
public class FrequencyCounter {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new FileInputStream(new File("C:"+File.separator+"Users"+File.separator+"Wajahat"+File.separator+"workspace"+File.separator+"Datastructures"+File.separator+"src"+File.separator+"com"+File.separator+"wajahat"+File.separator+"datastructure"+File.separator+"symboltable"+File.separator+"tinyTales.txt")));
		SymbolTable<String, Integer> st = new ElementarySymbolTable<>();
		while (scanner.hasNext()) {
			String word = scanner.next();
			if (!st.contains(word)) {
				st.put(word, 1);
			} else {
				st.put(word, st.get(word)+1);
			}
		}
		String max = "";
		st.put(max, 0);
		for (String word : st.keys()) {
			if (st.get(word) > st.get(max)) {
				max = word;
			}
		}
		System.out.println(max + " " + st.get(max));
		scanner.close();
	}

}

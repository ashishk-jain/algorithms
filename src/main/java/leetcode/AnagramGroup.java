package leetcode;

import java.util.*;

public class AnagramGroup {
	public static void main(String[] args) {
		String [] input = {"eat","tea","tan","ate","nat","bat"};
		String [] [] output = {{"bat"},{"nat","tan"},{"ate","eat","tea"}};
		AnagramGroup anagramGroup = new AnagramGroup();
		final String[][] anagrams = anagramGroup.findAnagrams(input);
		System.out.println();

	}

	private String[][] findAnagrams(String[] input) {
		Map<String, List<String>> originalMap = new HashMap<>();
		// m words
		// m * n logn
		for (String s : input) {
			final char[] inputChars = s.toCharArray();
			Arrays.sort(inputChars);
			final String sortedString = new String(inputChars);
			if (originalMap.containsKey(sortedString)) {
				originalMap.get(sortedString).add(s);
			} else {
				List<String> list = new ArrayList();
				list.add(s);
				originalMap.put(sortedString, list);
			}
		}
		String [][] output = new String[originalMap.size()][];
		int i = 0;
		for (String s : originalMap.keySet()) {
			final List<String> strings = originalMap.get(s);
			final String[] strings1 = strings.toArray(new String[strings.size()]);
			output[i] = strings1;

		}
		return output;
	}

}

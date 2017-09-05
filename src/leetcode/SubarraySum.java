package leetcode;

import java.util.HashMap;


public class SubarraySum {
	public int longestSub(int[] input, int target) {
		int sum = 0, maxLen = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < input.length; i++) {
			sum += input[i];
			if (sum == target) 
				maxLen = i + 1;
			else if (map.containsKey(sum - target)) {
				maxLen = maxLen > i - map.get(sum - target) ? maxLen : i - map.get(sum - target);
			}
			
			if (!map.containsKey(sum)) {
				map.put(sum, i + 1);
			}
		}
		return maxLen;
	}
	public int longestSub2(int[] input, int target) {
		if (input == null || input.length == 0) {
			return 0;
		}
		int maxLen = 0;
		int[] count = new int[input.length];
		
		for (int i = 0; i < input.length; i++) {
			for (int j = i; j < input.length; j++) {
				if (j == i) count[j] = input[j];
				else {
					count[j] = count[j - 1] + input[j];
				}
				if (count[j] == target) {
					maxLen = maxLen > j - i + 1 ? maxLen : j - i + 1;
				}
			}
		}
		return maxLen;
	}
	
	public static void main(String[] args) {
		SubarraySum test = new SubarraySum();
		int[] array = new int[]{1, -1, 5, -2, 3};
		System.out.println(test.longestSub(array, 3));
	}
}

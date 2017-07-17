package other;
import java.util.*;

public class MergeSortedArray {
	public int[] solution1(int[][] input) {
		if (input == null || input.length == 0) return new int[] {};
		int m = input.length;
		int n = input[0].length;
		int[] result = new int[m * n];
		int[] index = new int[m];
		int minindex = 0;
		for (int len = 0; len < result.length; len++) {
			int minval = Integer.MAX_VALUE;
			for (int i = 0; i < m; i++) {
				if (index[i] >= n) continue;
				if (input[i][index[i]] <= minval) {
					minval = input[i][index[i]];
					minindex = i;
				}
			}
			result[len] = minval;
			index[minindex]++;
		}
		return result;	
	}
	
	
	public class Pair{
		int val;
		int row;
		int col;
		Pair(int val, int row, int col) {
			this.val = val;
			this.row = row;
			this.col = col;
		}
	}
	
	public int[] solution2(int[][] input) {
		if (input == null || input.length == 0) return new int[] {};
		int m = input.length;
		int n = input[0].length;
		int[] result = new int[m * n];
		
		PriorityQueue<Pair> pq = new PriorityQueue<>(m, new Comparator<Pair>() {
			public int compare(Pair a, Pair b) {
				return b.val - a.val;
			}
		});
		
		for (int i = 0; i < m; i++) {
			pq.offer(new Pair(input[i][n - 1], i, n - 1));
		}
		for (int i = 0; i < result.length; i++) {
			Pair temp = pq.poll();
			result[i] = temp.val;
			if (temp.col - 1 >= 0) {
				pq.offer(new Pair(input[temp.row][temp.col - 1], temp.row, temp.col - 1));
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[][] test = new int[][] {{1,2,4,6},{2,6,8,10},{3,4,8,18}};
		MergeSortedArray SortedArray = new MergeSortedArray();
		int[] result = SortedArray.solution1(test);
		int[] result2 = SortedArray.solution2(test);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + ",");
		}
		System.out.println("\n"+"----------------------------");
		for (int i = 0; i < result2.length; i++) {
			System.out.print(result2[i] + ",");
		}
	}
}

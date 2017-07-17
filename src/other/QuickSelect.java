package other;

public class QuickSelect {
	public int quickSelect(int[] nums, int k, int low, int high) {
		int loc = partition(nums, low, high);
		if (k == loc) return nums[loc];
		else if (k < loc) {
			return quickSelect(nums, k, low, loc - 1);
		} else {
			return quickSelect(nums, k, loc + 1, high);
		}
		
	}
	
	public int partition(int[] nums, int low, int high) {
		int i = low, j = high + 1;
		int key = nums[i];
		while (true) {
			while (nums[++i] <= key) {
				if (i == high) break;
			}
			while (nums[--j] > key) {
				if (j == low) break;
			}
			if (i >= j) break;
			swap(nums, i, j);
		}
		swap(nums, low, j);
		return j;
	}
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		QuickSelect test = new QuickSelect();
		int[] input = {2,1,4,6,5,7,6,3,2,8,9};
		System.out.println(test.quickSelect(input, 5, 0, input.length - 1));
	}

}

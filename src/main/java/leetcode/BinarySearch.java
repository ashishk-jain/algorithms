package leetcode;

public class BinarySearch {
		public int search(int[] nums, int target) {
			if (nums == null) {
				return -1;
			}
			int start = 0;
			int end = nums.length -1;
			while (start < end) {
				int mid = (start + end) / 2;
				if (target == nums[mid]) {
					return mid;
				}
				if (target > nums[mid]) {
					start = mid + 1;
				} else if(target < nums[mid]) {
					end = mid - 1;
				}
			}
			return -1;
		}
}

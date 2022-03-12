package recursion;

public class ZeroOneKnapsack {
	static int maxCostKnapsackUsingRec(int [] values, int [] weights, int curIndex, int totalWeight) {
		if (curIndex < 0 || totalWeight == 0) {
			return 0;
		}
		if (weights[curIndex] > totalWeight) {
			return maxCostKnapsackUsingRec(values, weights, curIndex - 1, totalWeight);
		} else {
			return Math.max(maxCostKnapsackUsingRec(values, weights, curIndex -1, totalWeight), maxCostKnapsackUsingRec(values, weights, curIndex-1, totalWeight-weights[curIndex]) + values[curIndex]);
		}

	}
	public static void main(String[] args) {
		int[] weights = {1,3,4,5};
		int [] values = {1, 4, 5, 7};
		int totalWeights = 7;
		int totalValue = maxCostKnapsackUsingRec(values, weights, 3, 7);
		System.out.println(totalValue);

	}
}

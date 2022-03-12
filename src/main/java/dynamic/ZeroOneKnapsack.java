package dynamic;

public class ZeroOneKnapsack {
	public static void main(String[] args) {
		int[] weights = {1,3,4,5};
		int [] values = {1, 4, 5, 7};
		int totalWeights = 7;
		int [][] weightVolume = new int[4][totalWeights + 1];
		for (int i = 0; i < 4; i++) {
			weightVolume[i][0] = 0;
		}
		for (int i = 0; i < weights.length; i++) {
			for (int j = 1; j <= totalWeights; j++) {
				if (weights[i] > j) {
					if (i == 0) {
						weightVolume[i][j] = 0;
					} else {
						weightVolume[i][j] = weightVolume[i-1][j];
					}
				} else {
					if (i == 0) {
						weightVolume[i][j] = values[i];
					} else {
						if (j - weights[i] >=0) {
							weightVolume[i][j] = Math.max(values[i] + weightVolume[i-1][j - weights[i]], weightVolume[i-1][j]);
						} else {
							weightVolume[i][j] = Math.max(values[i], weightVolume[i-1][j]);
						}
					}
				}
			}
		}

		System.out.println(weightVolume);

	}
}

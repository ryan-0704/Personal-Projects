
public class HolidayBonus {
	final static double HIGHEST_BONUS=5000;
	final static double MIDDLE_BONUS=2000;
	final static double LOWEST_BONUS=1000;
	
	public static double[] calculateHolidayBonus(double[][] data) {
		

		int count = 0;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				count++;
			}
		}
		double[] result = new double[data.length];

		int ind = 0;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				double[][] array = new double[data.length][];
				array[i] = new double[data[i].length];

				if (data[i][j] > 0) {
					if (data[i][j] == TwoDimRaggedArrayUtility.getHighestInColumn(data, j)) {
						array[i][j] = HIGHEST_BONUS;
						// System.out.print(array[i][j]+" ");
						result[ind] = result[ind] + array[i][j];

					} else if (data[i][j] == TwoDimRaggedArrayUtility.getLowestInColumn(data, j)) {
						array[i][j] = LOWEST_BONUS;
						// System.out.print(array[i][j]+" ");
						result[ind] = result[ind] + array[i][j];

					} else {
						array[i][j] = MIDDLE_BONUS;
						// System.out.print(array[i][j]+" ");
						result[ind] = result[ind] + array[i][j];

					}
				}

			}
			ind++;

		}
		return result;

	}
	
	public static double calculateTotalHolidayBonus(double[][] data) {
		double total=0;
		double[] bonus = calculateHolidayBonus(data);
		for(int i=0; i<bonus.length; i++) {
			total+=bonus[i];
		}
		return total;
		
	}

}

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class TwoDimRaggedArrayUtility {


	public static double[][] readFile(File file) throws FileNotFoundException {
		final int maxRow = 10;
		final int maxColumn = 10;

		Scanner scanner = new Scanner(file);
		String[][] temp = new String[maxRow][maxColumn];
		int rowCount = 0;
		while (scanner.hasNext() && rowCount < maxRow) {
			String line = scanner.nextLine();
			String[] lines = line.split(" ");

			for (int i = 0; i < lines.length; i++) {
				if (i < maxColumn) {
					temp[rowCount][i] = lines[i];
				}
			}
			rowCount++;

		}
		if (rowCount == 0) {
			return null;
		}
		double[][] result = new double[rowCount][];

		for (int i = 0; i < rowCount; i++) {
			int colcount = 0;
			for (int j = 0; j < maxColumn; j++) {
				if (temp[i][j] != null) {
					colcount++;
				} else {
					break;
				}

			}
			result[i] = new double[colcount];

			for (int k = 0; k < colcount; k++) {
				result[i][k] = Double.parseDouble(temp[i][k]);
			}

		}
		return result;

	}


	public static void writeToFile(double[][] data, File file) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(file);

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				writer.print(data[i][j]);
				if (j < data[i].length - 1) {
					writer.print(" ");
				}
			}
			writer.println();
		}

		writer.close();
	}

	public static double getTotal(double[][] data) {
		double total = 0;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				total += data[i][j];
			}
		}
		return total;
	}

	public static double getAverage(double[][] data) {
		double avg = 0;
		int count = 0;
		double total = 0;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				total += data[i][j];
				count++;
			}
		}
		avg = total / count;
		return avg;
	}

	public static double getRowTotal(double[][] data, int row) {
		double total = 0;
		for (int i = 0; i < data[row].length; i++) {
			total += data[row][i];
		}
		return total;
	}

	public static double getColumnTotal(double[][] data, int col) {
		double total = 0;

		for (int i = 0; i < data.length; i++) {
			if (data[i].length - 1 < col) {
				continue;
			} else {
				total += data[i][col];
			}
		}
		return total;

	}

	public static double getHighestInRow(double[][] data, int row) {
		double highest = data[row][0];
		for (int i = 0; i < data[row].length; i++) {
			if (data[row][i] > highest) {
				highest = data[row][i];
			}
		}
		return highest;
	}

	public static int getHighestInRowIndex(double[][] data, int row) {
		double highest = data[row][0];
		int ind = 0;
		for (int i = 0; i < data[row].length; i++) {
			if (data[row][i] > highest) {
				highest = data[row][i];
				ind = i;
			}
		}
		return ind;
	}

	public static double getLowestInRow(double[][] data, int row) {
		double lowest = data[row][0];
		for (int i = 0; i < data[row].length; i++) {
			if (data[row][i] < lowest) {
				lowest = data[row][i];
			}
		}
		return lowest;

	}

	public static int getLowestInRowIndex(double[][] data, int row) {
		double lowest = data[row][0];
		int ind = 0;
		for (int i = 0; i < data[row].length; i++) {
			if (data[row][i] < lowest) {
				lowest = data[row][i];
				ind = i;
			}
		}
		return ind;

	}

	public static double getHighestInColumn(double[][] data, int col) {
		
		double highest = Double.NEGATIVE_INFINITY;  

		for (int i = 0; i < data.length; i++) {
			if (data[i].length - 1 < col) {
				continue;
			} else {
				if (data[i][col] > highest) {
					highest = data[i][col];
				}
			}
		}
		return highest;

	}

	public static int getHighestInColumnIndex(double[][] data, int col) {
		double highest = Double.NEGATIVE_INFINITY;  
		int ind = 0;

		for (int i = 0; i < data.length; i++) {
			if (data[i].length - 1 < col) {
				continue;
			} else {
				if (data[i][col] > highest) {
					highest = data[i][col];
					ind = i;
				}
			}
		}
		return ind;

	}

	public static double getLowestInColumn(double[][] data, int col) {
		double lowest = Double.POSITIVE_INFINITY;  

		for (int i = 0; i < data.length; i++) {
			if (data[i].length - 1 < col) {
				continue;
			} else {
				if (data[i][col] < lowest) {
					lowest = data[i][col];
				}
			}
		}
		return lowest;
	}

	public static int getLowestInColumnIndex(double[][] data, int col) {
		double lowest = Double.POSITIVE_INFINITY;  
		int ind = 0;

		for (int i = 0; i < data.length; i++) {
			if (data[i].length - 1 < col) {
				continue;
			} else {
				if (data[i][col] < lowest) {
					lowest = data[i][col];
					ind = i;
				}
			}
		}
		return ind;
	}

	public static double getHighestInArray(double[][] data) {
		double highest = data[0][0];
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if (data[i][j] > highest) {
					highest = data[i][j];
				}
			}
		}
		return highest;
	}

	public static double getLowestInArray(double[][] data) {
		double lowest = data[0][0];
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if (data[i][j] < lowest) {
					lowest = data[i][j];
				}
			}
		}
		return lowest;
	}

}

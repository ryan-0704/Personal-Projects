/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: makes the smoothie beverage 
 * Due: 12/17/2024
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ryan Jones
*/
public class Smoothie extends Beverage {

	private int fruits;
	private boolean protein;

	public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein) {
		super(bevName, Type.SMOOTHIE, size);
		fruits = numOfFruits;
		protein = addProtein;

	}

	public int getNumOfFruits() {
		return fruits;
	}

	public boolean getAddProtein() {
		return protein;
	}

	@Override
	public String toString() {
		return "Smoothie [fruits=" + fruits + ", protein=" + protein + ", Name=" + getBevName() + ", Size="
				+ getSize() + ", Price=" + getBasePrice() + "]";
	}

	@Override
	public boolean equals(Object s) {
		if (!super.equals(s)) {
			return false;
		}
		Smoothie sm = (Smoothie) s;
		if (fruits == sm.getNumOfFruits() && protein == sm.getAddProtein()) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public double calcPrice() {
		double total = super.addSizePrice();

		if (protein) {
			total += 1.5;
		}
		if (fruits > 0) {
			total += (fruits * .5);
		}
		return total;
	}

}
/*
 * Class: CMSC203 
 * Instructor:
 * Description: makes the alcohol beverage 
 * Due: 12/17/2024
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ryan Jones
*/

public class Alcohol extends Beverage {
	private boolean weekend;
	
	public Alcohol(String bevName, Size size, boolean isWeekend) {
		super(bevName, Type.ALCOHOL, size);
		
		weekend=isWeekend;
	}
	@Override
	public double calcPrice() {
		double total=super.addSizePrice();
		if(weekend) {
			total+=.6;
		}
		return total;
	}
	@Override
	public String toString() {
		return "Alcohol [weekend=" + weekend + ", Name=" + getBevName() + ", Size=" + getSize()
				+ ", Price=" + getBasePrice() + "]";
	}
	public boolean isWeekend() {
		return weekend;
	}
	public void setWeekend(boolean weekend) {
		this.weekend = weekend;
	}
	@Override
	public boolean equals(Object a) {
		if(!super.equals(a)) {
			return false;
		}
		Alcohol ac = (Alcohol) a;
		
		if(weekend==ac.isWeekend()) {
			return true;
		}else {
			return false;
		}
	}
	
	
	

}

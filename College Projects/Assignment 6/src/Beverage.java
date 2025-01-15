/*
 * Class: CMSC203 
 * Instructor:
 * Description: makes beverage object for the sub classes
 * Due: 12/17/2024
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ryan Jones
*/
public abstract class Beverage {

	private String bevName;
	private Type bevType;
	private Size bevSize;
	private final double price = 2.0;
	private final double sPrice = .5;

	public double addSizePrice() {
		if (bevSize.equals(Size.SMALL)) {
			return price;
		} else if (bevSize.equals(Size.MEDIUM)) {
			return price + (sPrice);
		} else if (bevSize.equals(Size.LARGE)) {
			return price + (2 * sPrice);
		} else {
			return price;
		}
	}

	public Beverage(String name, Type type, Size size) {
		bevName = name;
		bevType = type;
		bevSize = size;
	}

	public abstract double calcPrice();
	
	

	public String getBevName() {
		return bevName;
	}
	

	public void setBevName(String bevName) {
		this.bevName = bevName;
	}

	public Type getType() {
		return bevType;
	}

	public void setBevType(Type bevType) {
		this.bevType = bevType;
	}

	public Size getSize() {
		return bevSize;
	}

	public void setBevSize(Size bevSize) {
		this.bevSize = bevSize;
	}

	public double getBasePrice() {
		return price;
	}

	public double getsPrice() {
		return sPrice;
	}

	@Override
	public String toString() {
		return "Beverage [bevName=" + bevName + ", bevType=" + bevType + ", bevSize=" + bevSize + "]";
	}

	@Override
	public boolean equals(Object anotherBev) {
		if (this == anotherBev)
			return true;
		if (anotherBev == null || getClass() != anotherBev.getClass())
			return false;
		Beverage beverage = (Beverage) anotherBev;
		return bevName.equals(beverage.bevName) && bevType == beverage.bevType && bevSize == beverage.bevSize;
	}

}

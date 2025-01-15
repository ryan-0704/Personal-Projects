
/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: makes the coffee beverage 
 * Due: 12/17/2024
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ryan Jones
*/

public class Coffee extends Beverage{
	private boolean extraShot;
	private boolean extraSyrup;
	
	public Coffee(String name, Size size, boolean es, boolean esy) {
		super(name, Type.COFFEE, size);
		extraShot=es;
		extraSyrup=esy;
	}

	@Override
	public String toString() {
		return "Coffee [extra shot=" + extraShot + ", extra syrup=" + extraSyrup + ", Name()=" + getBevName()
				+ ", Size=" + getSize() + "Price: "+calcPrice()+ "]";
	}
	
	@Override
	public double calcPrice(){
		double total=super.addSizePrice();
		if(extraShot) {
			total+=.5;
		} 
		if(extraSyrup){
			total+=.5;
		}
			return total;
		
	}
	
	
	

	public boolean getExtraShot() {
		return extraShot;
	}

	public void setExtraShot(boolean extraShot) {
		this.extraShot = extraShot;
	}

	public boolean getExtraSyrup() {
		return extraSyrup;
	}

	public void setExtraSyrup(boolean extraSyrup) {
		this.extraSyrup = extraSyrup;
	}

	

	@Override
	public boolean equals(Object coffee) {
	
		if(!super.equals(coffee)) {
			return false;
		}
		Coffee coff = (Coffee) coffee;
		if(this.extraShot==coff.getExtraShot()&&this.extraSyrup==coff.getExtraSyrup()) {
			return true;
		}else {
			return false;
		}
	}
	
	

}

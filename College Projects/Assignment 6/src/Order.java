import java.util.Random;
import java.util.ArrayList;

/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: makes the order class to organize the drinks
 * Due: 12/17/2024
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ryan Jones
*/

public class Order implements OrderInterface, Comparable {
	private int orderTime;
	private int orderNumber;
	private Day orderDay;
	private ArrayList<Beverage> order = new ArrayList<>();
	Customer cust;
	Random rand;

	public int generateOrder() {
		rand = new Random();
		return rand.nextInt(90001) + 10000;
	}

	public Order(int orderTime, Day orderDay, Customer cust) {
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.cust = cust;
		orderNumber = generateOrder();
	}

	public boolean isWeekend() {
		if (orderDay.equals(Day.SATURDAY) || orderDay.equals(Day.SUNDAY)) {
			return true;
		} else {
			return false;
		}
	}

	public void addNewBeverage(String bevName, Size size) {
		order.add(new Alcohol(bevName, size, isWeekend()));
	}

	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		order.add(new Coffee(bevName, size, extraShot, extraSyrup));
	}

	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		order.add(new Smoothie(bevName, size, numOfFruits, addProtein));
	}

	public Beverage getBeverage(int itemNo) {
		if (itemNo > order.size() - 1) {
			return null;
		} else {
			return order.get(itemNo);
		}
	}

	public double calcOrderTotal() {
		double total = 0;
		for (Beverage o : order) {
			total += o.calcPrice();
		}
		return total;
	}

	public int findNumOfBeveType(Type type) {
		int count = 0;
		for (Beverage o : order) {
			if (o.getType().equals(type)) {
				count++;
			}
		}
		return count;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	
	@Override
	public int compareTo(Object b) {
		Order o = (Order) b;
		
		if(this.orderNumber>o.getOrderNumber()) {
			return 1;
		}else if(this.orderNumber<o.getOrderNumber()) {
			return -1;
		}else {
			return 0;
		}
	}
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append("Order number: "+ orderNumber+", Time: "+orderTime+", Day: "+orderDay+", Customer name: "+cust.getName()+", Customer age: "+ cust.getAge()+" ");
		for(int i=0; i<order.size();i++) {
			output.append(order.get(i).toString());
		}
		return output.toString();
	}
	
	public int getTotalItems() {
		return order.size();
	}

	public int getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(int orderTime) {
		this.orderTime = orderTime;
	}

	public Day getOrderDay() {
		return orderDay;
	}

	public void setOrderDay(Day orderDay) {
		this.orderDay = orderDay;
	}

	public ArrayList<Beverage> getOrder() {
		return order;
	}

	public void setOrder(ArrayList<Beverage> order) {
		this.order = order;
	}

	public Customer getCust() {
		return new Customer(cust.getName(), cust.getAge());
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public Random getRand() {
		return rand;
	}

	public void setRand(Random rand) {
		this.rand = rand;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	
	

}

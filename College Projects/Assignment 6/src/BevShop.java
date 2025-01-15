/*
 * Class: CMSC203 
 * Instructor:
 * Description: makes the bevshop class where drinks can be ordered from 
 * Due: 12/17/2024
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ryan Jones
*/

import java.util.ArrayList;

public class BevShop implements BevShopInterface {
	private int alcohol;
	private ArrayList<Order> orders = new ArrayList<>();

	public boolean isValidTime(int time) {
		return time >= 8 && time <= 23;
	}

	public int getMaxNumOfFruits() {
		return MAX_FRUIT;
	}

	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}

	public boolean isMaxFruit(int numOfFruits) {
		return numOfFruits > MAX_FRUIT;
	}

	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}

	public boolean isEligibleForMore() {
		return alcohol == MAX_ORDER_FOR_ALCOHOL;
	}

	public int getNumOfAlcoholDrink() {
		return alcohol;
	}

	public boolean isValidAge(int age) {
		return age >= MIN_AGE_FOR_ALCOHOL;
	}

	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		orders.add(new Order(time, day, new Customer(customerName, customerAge)));
	}

	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		getCurrentOrder().addNewBeverage(bevName, size, extraShot, extraSyrup);
	}

	public void processAlcoholOrder(String bevName, Size size) {
		getCurrentOrder().addNewBeverage(bevName, size);
		alcohol++;
	}

	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
		getCurrentOrder().addNewBeverage(bevName, size, numOfFruits, addProtein);
	}

	public int findOrder(int orderNo) {
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getOrderNumber() == orderNo) {
				return i;
			}
		}
		return -1;
	}

	public double totalOrderPrice(int orderNo) {
		for (Order order : orders) {
			if (order.getOrderNumber() == orderNo) {
				return order.calcOrderTotal();
			}
		}
		return 0;
	}

	public double totalMonthlySale() {
		double total = 0;
		for (Order order : orders) {
			total += order.calcOrderTotal();
		}
		return total;
	}

	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}

	public Order getCurrentOrder() {
		if (orders.isEmpty()) {
			throw new IllegalStateException("No orders available.");
		}
		return orders.get(orders.size() - 1);
	}

	public Order getOrderAtIndex(int index) {
		return orders.get(index);
	}

	public void sortOrders() {
		int n = orders.size();
		for (int i = 0; i < n - 1; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (orders.get(j).getOrderNumber() < orders.get(min).getOrderNumber()) {
					min = j;
				}
			}
			Order temp = orders.get(min);
			orders.set(min, orders.get(i));
			orders.set(i, temp);
		}
	}

	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append("Total monthly sale: ").append(totalMonthlySale()).append(" ");
		for (Order order : orders) {
			output.append(order.toString());
		}
		return output.toString();
	}
}

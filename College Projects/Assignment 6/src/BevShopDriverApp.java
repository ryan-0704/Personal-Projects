/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: makes the alcohol beverage 
 * Due: 12/17/2024
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ryan Jones
*/
import java.util.Scanner;

public class BevShopDriverApp {
	public static void main(String[] args) {
		System.out.println("The current order in process can have at most 3 alcoholic beverages.\r\n"
				+ "The minimum age to order alcohol drink is 21\r\n" + "");

		System.out.println("Please start a new order\ncurrent total is: 0.0");
		Scanner scan = new Scanner(System.in);
		boolean another = true;

		System.out.println("Please enter your name: ");
		String name = scan.nextLine();
		System.out.println("Pleas enter age: ");
		int age = scan.nextInt();
		BevShop bev = new BevShop();

		if (bev.isValidAge(age)) {
			System.out.println("you can drink alcohol");
		} else {
			System.out.println("you cant drink alcohol");
		}

		bev.startNewOrder(17, Day.MONDAY, name, age);
		while (another) {

			System.out.println("Please pick one of the following:");
			System.out.println("1. Alcohol\n2. Smoothie\n3. Coffee");

			int choice = scan.nextInt();
			scan.nextLine();

			if (choice == 1) {
				if (bev.isValidAge(age)) {
					if (bev.getNumOfAlcoholDrink() >= 3) {
						System.out.println("you've ordered too much alcohol");
						continue;
					}

					System.out.println("what size: small, medium, or large");
					String size = scan.nextLine();
					Size s = Size.SMALL;
					if (size.equalsIgnoreCase("small")) {
						s = Size.SMALL;
					} else if (size.equalsIgnoreCase("medium")) {
						s = Size.MEDIUM;
					} else if (size.equalsIgnoreCase("large")) {
						s = Size.LARGE;
					}

					bev.processAlcoholOrder("alcohol", s);

				} else {
					System.out.println("your too young to drink alcohol, try a smoothie instead");
				}
			} else if (choice == 2) {
				System.out.println("how many fruits would you like: ");
				int fruit = scan.nextInt();
				while (fruit > 5) {
					System.out.println("too many fruits, try again: ");
					fruit = scan.nextInt();
				}
				scan.nextLine();
				System.out.print("would you like some protein: (yes/no): ");
				String protein = scan.nextLine();
				boolean pro = protein.equalsIgnoreCase("yes");
				System.out.println("what size: small, medium, or large");
				String size = scan.nextLine();
				Size s = Size.SMALL;
				if (size.equalsIgnoreCase("small")) {
					s = Size.SMALL;
				} else if (size.equalsIgnoreCase("medium")) {
					s = Size.MEDIUM;
				} else if (size.equalsIgnoreCase("large")) {
					s = Size.LARGE;
				}
				bev.processSmoothieOrder("smoothie", s, fruit, pro);

			} else if (choice == 3) {
				
				System.out.println("what size: small, medium, or large");
				String size = scan.nextLine();
				Size s = Size.SMALL;
				if (size.equalsIgnoreCase("small")) {
					s = Size.SMALL;
				} else if (size.equalsIgnoreCase("medium")) {
					s = Size.MEDIUM;
				} else if (size.equalsIgnoreCase("large")) {
					s = Size.LARGE;
				}
				System.out.print("would you like an extra shot: (yes/no): ");
				String expr = scan.nextLine();
				boolean es = expr.equalsIgnoreCase("yes");
				System.out.print("would you like extra syrup: (yes/no): ");
				String syr = scan.nextLine();
				boolean esy = syr.equalsIgnoreCase("yes");
				bev.processCoffeeOrder("coffee", s, es, esy);

			}
			System.out.println("would you like another drink (yes/no)");
			String decision = scan.nextLine();
			another = decision.equalsIgnoreCase("yes");

		}
		System.out.println("Total number of items is: "+bev.getCurrentOrder().getTotalItems());
		System.out.println();
		System.out.println("Bringing the total price to: "+bev.getCurrentOrder().calcOrderTotal());
		scan.close();
	}

}

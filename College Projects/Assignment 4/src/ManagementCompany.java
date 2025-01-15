/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: creates a management company object
 * Due: 11/2/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Ryan Jones
*/

import java.util.Arrays;
import java.util.Objects;

public class ManagementCompany {
	private String name; // Company name
	private String tax; // Tax ID
	private double fee; // Management fee
	private Plot plot; // Company plot
	public static final int MAX_PROPERTY = 5; // Max number of properties
	private static final int MAX_DEPTH = 10; // Max plot depth
	private static final int MAX_WIDTH = 10; // Max plot width
	private Property[] properties; // Array of properties
	private int numberOfProperties = 0; // Current property count

	// default constructor
	public ManagementCompany() {
		name = "";
		tax = "";
		fee = 0;
		plot = new Plot(0, 0, MAX_DEPTH, MAX_WIDTH);
		properties = new Property[MAX_PROPERTY];
	}

	public ManagementCompany(String name, String tax, double fee) {
		this.name = name;
		this.tax = tax;
		this.fee = fee;
		plot = new Plot(0, 0, MAX_DEPTH, MAX_WIDTH);
		properties = new Property[MAX_PROPERTY];
	}

	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this(name, taxID, mgmFee);
		plot = new Plot(x, y, width, depth);
	}

	// copy constructor
	public ManagementCompany(ManagementCompany otherCompany) {
		this.name = otherCompany.name;
		this.tax = otherCompany.tax;
		this.fee = otherCompany.fee;
		this.properties = new Property[MAX_PROPERTY];
	    for (int i = 0; i < MAX_PROPERTY; i++) {
	        if (otherCompany.properties[i] != null) {
	            this.properties[i] = new Property(otherCompany.properties[i]);
	        }
	    }
		plot = new Plot(otherCompany.plot);
	}


	public String getName() {
		return name;
	}

	public String getTax() {
		return tax;
	}

	public double getFee() {
		return fee;
	}

	public Plot getPlot() {
		return plot;
	}

	public Property[] getProperties() {
		return properties;
	}

	public int addProperty(String name, String city, double rent, String owner) {
		for (int i = 0; i < MAX_PROPERTY; i++) {
			if (properties[i] == null) {
				properties[i] = new Property(name, city, rent, owner);
				return i; // Return index of added property
			}
		}
		return -1; // No space available
	}

	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		for (int i = 0; i < MAX_PROPERTY; i++) {
			if (properties[i] == null) {
				properties[i] = new Property(name, city, rent, owner, x, y, width, depth);
				if (plot.encompasses(properties[i].getPlot())) {
					for (int j = 0; j <= i; j++) {
						if (properties[i].getPlot().overlaps(properties[j].getPlot())) {
							return -4; // Overlap found
						}
					}
					return i; // Return index of added property
				} else {
					return -3; // Property not within plot
				}
			}
		}
		return -1; // No space available
	}

	public int addProperty(Property prop) {
		if (prop == null)
			return -2; // Invalid property
		for (int i = 0; i < MAX_PROPERTY; i++) {
			if (properties[i] == null) {
				properties[i] = prop;
				return i; // Return index of added property
			}
		}
		return -1; // No space available
	}

	public double getTotalRent() {
		double total = 0;
		for (int i = 0; i < MAX_PROPERTY; i++) {
			if (properties[i] != null) {
				total += properties[i].getRentAmount();
			}
		}
		return total;
	}

	public void removeLastProperty() {
		for (int i = MAX_PROPERTY - 1; i >= 0; i--) {
			if (properties[i] != null) {
				properties[i] = null; // Remove last property
				break;
			}
		}
	}

	public boolean isPropertiesFull() {
		for (int i = 0; i < MAX_PROPERTY; i++) {
			if (properties[i] == null)
				return false; // Space available
		}
		return true; // All properties occupied
	}

	public Property getHighestRentProperty() {
		double highest = 0.0;
		Property prop = null;

		for (int i = 0; i < MAX_PROPERTY; i++) {
			if (properties[i] != null && properties[i].getRentAmount() > highest) {
				highest = properties[i].getRentAmount();
				prop = properties[i];
			}
		}

		return prop; // Return property with highest rent
	}

	public int getPropertiesCount() {
		numberOfProperties = 0; // Reset count
		for (int i = 0; i < MAX_PROPERTY; i++) {
			if (properties[i] != null) {
				numberOfProperties++;
			}
		}
		return numberOfProperties; // Return current count
	}

	public boolean isManagementFeeValid() {
		return fee < 101 && fee > 0; // Valid if fee is between 0 and 100
	}
	

	
	
	public boolean equals(ManagementCompany company) {
		if(this.name.equals((company.name))) {
			if(this.tax.equals(company.tax)){
				if(this.fee==company.fee) {
					if(this.plot.equals(company.plot)) {
						 for (int i = 0; i < MAX_PROPERTY; i++) {
						        Property property1 = properties[i];
						        Property property2 = company.properties[i];
						        
						        if (property1 == null && property2 == null) {
						            continue; // If both elements are null, they're equal for this index
						        }
						        
						        if (property1 == null || property2 == null) {
						            return false; // If one is null and the other is not, they are not equal
						        }
						        
						        if (!property1.equals(property2)) {
						            return false; // If properties at this index are not equal, return false
						        }
						 }
						return true;
					}
					return false;
				}
				return false;
			}
			return false;
		}
		return false;
		
		
			}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("List of the properties for ").append(name).append(", taxID: ").append(tax).append("\n")
				.append("______________________________________________________\n");

		for (Property property : properties) {
			if (property != null) {
				sb.append(property.toString()).append("\n");
			}
		}

		sb.append("______________________________________________________\n\n");
		double totalManagementFee = getTotalRent() * (fee / 100);
		sb.append(" total management Fee: ").append(totalManagementFee);

		return sb.toString();
	}
}

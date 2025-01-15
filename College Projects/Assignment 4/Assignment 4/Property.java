import java.util.Objects;

/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: creates a management Property object
 * Due: 11/2/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Ryan Jones
*/
public class Property {
	private String name;
	private String city;
	private String owner;
	private double rent;
	private Plot plot;

	// default constructor
	public Property() {
		city = "";
		owner = "";
		rent = 0;
		plot = new Plot();
		name = "";
	}

	public Property(String propertyName, String city, double rentAmount, String owner) {
		name = propertyName;
		this.city = city;
		rent = rentAmount;
		this.owner = owner;
		plot = new Plot();
	}

	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width,
			int depth) {
		this(propertyName, city, rentAmount, owner);
		plot = new Plot(x, y, width, depth);
	}

	// copy constructor
	public Property(Property otherProperty) {
		name = otherProperty.name;
		city = otherProperty.city;
		owner = otherProperty.owner;
		rent = otherProperty.rent;
		plot = new Plot(otherProperty.plot);

	}

	public String getPropertyName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	public String getOwner() {
		return owner;
	}

	public double getRentAmount() {
		return rent;
	}

	public Plot getPlot() {
		return plot;
	}

	public boolean equals(Property obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Property other = (Property) obj;
		return Objects.equals(city, other.city) && Objects.equals(name, other.name)
				&& Objects.equals(owner, other.owner) && Objects.equals(plot, other.plot)
				&& Double.doubleToLongBits(rent) == Double.doubleToLongBits(other.rent);
	}

	@Override
	public String toString() {
		return name + "," + city + "," + owner + "," + rent;
	}

}

package module3;

public class Employee {
	
	private int id;
	private String name;
	private double baseSalary;
	private String manager;
	
	public Employee(String name, double baseSalary) {
		this.name = name;
		this.baseSalary = baseSalary;
	}

	public String getName() {
		return name;
	}

	public double getBaseSalary() {
		return baseSalary;
	}
	
	public int getEmployeeID() {
		return id;
	}
		

}

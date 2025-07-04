package karim.models;

public class ShippableProduct extends Product {
	
	private double weight;
	
	public ShippableProduct(String name, double price, int quantity, double weight) {
		super(name, price, quantity);
		this.weight = weight;
	}
	
	/**
	 * All objects in ShippableProduct is always be shipped
	 */
	@Override
	public boolean isShippable() {
		return true;
	}


	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}
}

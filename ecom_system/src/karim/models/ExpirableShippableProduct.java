package karim.models;

import java.time.LocalDate;

public class ExpirableShippableProduct extends ExpirableProduct {
	private double weight;
	
	public ExpirableShippableProduct(String name, double price, int quantity, LocalDate expireAt, double weight) {
		super(name, price, quantity, expireAt);
		this.weight = weight;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
}

package karim.models;

import java.time.LocalDate;

public class ExpirableProduct extends Product {
	
	private LocalDate expireAt;
	
	public ExpirableProduct(String name, double price, int quantity, LocalDate expireAt) {
		super(name, price, quantity);
		this.expireAt = expireAt;
	}
	
	@Override
	public boolean isExpireable() {
		return true;
	}

	public LocalDate getExpireAt() {
		return expireAt;
	}

	public void setExpireAt(LocalDate expireAt) {
		this.expireAt = expireAt;
	}
}

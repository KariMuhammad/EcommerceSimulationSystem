package karim.models;

import karim.Validator;
import karim.rules.cart_items.RequestedQuantityRule;

import java.util.List;

public class CartItem {
	private User owner;
	private Product product;
	private int quantity;
	
	public CartItem(User owner, Product product, int quantity) {
		this.owner = owner;
		this.product = product;
		this.quantity = quantity;


		/*
		 * before add this cart item in cart of user, we validate fields of cart item
		 * if user asked quantity more than its availability
		 */
		this.validateInputs();

		/*
		 * every call for CartItem constructor for create object
		 * will automatically add this cart_item into cart of user (owner)
		 */
		this.owner.getMyCart().add(this);
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public User getOwner() {
		return this.owner;
	}

	/**
	 * Validates all fields in CartItem
	 * right now, check if quantity requested in a CartItem does not exceed the available stock
	 */
	private void validateInputs() {
		Validator<CartItem> validateFields = Validator.of(List.of(
				new RequestedQuantityRule()
		));

		validateFields.validate(this);
	}
}

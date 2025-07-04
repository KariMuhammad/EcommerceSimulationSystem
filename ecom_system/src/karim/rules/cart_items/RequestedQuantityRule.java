package karim.rules.cart_items;

import karim.ValidationException;
import karim.contracts.IRule;
import karim.models.CartItem;

/**
 * Ensures the quantity requested in a {@link CartItem} does not exceed
 * the available stock of its associated {@link karim.models.Product}.
 *
 * @param CartItem the cart item to validate
 * @throws ValidationException if {@code item.getQuantity()} is greater than the
 *         product’s available stock
 */
public class RequestedQuantityRule implements IRule<CartItem> {
	@Override
	public void check(CartItem target) throws ValidationException {
		if (target.getQuantity() > target.getProduct().getQuantity()) {
			throw new ValidationException("Requested quantity exceeds available stock");
		}
	}
}

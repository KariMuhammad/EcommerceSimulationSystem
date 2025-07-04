package karim.rules.products;

import karim.ValidationException;
import karim.contracts.IRule;
import karim.models.Product;

/**
 * Validates that a {@link Product} has a non-negative stock quantity.
 *
 * @param product the product to check
 * @throws ValidationException if the product's quantity is less than 0
 */
public class AvailableStockRule implements IRule<Product> {
	@Override
	public void check(Product target) throws ValidationException {
		if (target.getQuantity() < 0) throw new ValidationException("Out of stock!");
	}
}

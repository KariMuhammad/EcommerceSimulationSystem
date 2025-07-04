package karim.rules.products;

import karim.ValidationException;
import karim.contracts.IRule;
import karim.models.Product;

/**
 * Validates that a {@link Product} has a positive (non-zero, non-negative) price.
 *
 * @param product the product to validate
 * @throws ValidationException if the price is less than or equal to 0
 */
public class PositivePriceRule implements IRule<Product>{
	
	@Override
	public void check(Product target) {
		if (target.getPrice() <= 0) throw new ValidationException("Product price must be positive number");
	}
}

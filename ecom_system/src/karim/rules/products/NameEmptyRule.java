package karim.rules.products;

import karim.ValidationException;
import karim.contracts.IRule;
import karim.models.Product;

/**
 * Validates that a {@link Product} has a non-empty, non-blank name.
 *
 * @param product the product to validate
 * @throws ValidationException if the name is null, empty, or only whitespace
 */
public class NameEmptyRule implements IRule<Product> {	
	@Override
	public void check(Product product) {
		String name = product.getName();
		if (name == null || name.trim().isEmpty()) {
			throw new ValidationException("Product name is required!");
		}
	}
}

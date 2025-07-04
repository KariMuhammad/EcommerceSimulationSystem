package karim.rules.products;

import karim.ValidationException;
import karim.contracts.IRule;
import karim.models.Product;
import karim.models.ShippableProduct;
import karim.models.ExpirableShippableProduct;

/**
 * Validates that a {@link Product} marked as shippable has a weight greater than zero.
 *
 * Applies only to {@link ShippableProduct} and {@link ExpirableShippableProduct}.
 *
 * @param product the product to validate
 * @throws ValidationException if weight is zero or negative
 */
public class WeightRule implements IRule<Product> {
	@Override
	public void check(Product target) throws ValidationException {
		if (target.isShippable()) {
			double weight = switch (target) {
				case ShippableProduct sp -> sp.getWeight();
				case ExpirableShippableProduct esp -> esp.getWeight();
				default -> 0;
			};
			
			if (weight <= 0) {
				throw new ValidationException("Weight must be positive!");
			}
		}
	}
}

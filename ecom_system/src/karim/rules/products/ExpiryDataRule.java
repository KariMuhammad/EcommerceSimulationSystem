package karim.rules.products;

import java.time.LocalDate;

import karim.ValidationException;
import karim.contracts.IRule;
import karim.models.ExpirableShippableProduct;
import karim.models.ExpirableProduct;
import karim.models.Product;

/**
 * Validates that an expirable {@link Product} has a valid future expiry date.
 *
 * Applies only to {@link ExpirableProduct} and {@link ExpirableShippableProduct}.
 *
 * @param product the product to validate
 * @throws ValidationException if the expiry date is missing or not in the future
 */
public class ExpiryDataRule implements IRule<Product> {
	@Override
	public void check(Product product) throws ValidationException {
		if (product.isExpireable()) {
			LocalDate expiry = switch (product) {
				case ExpirableShippableProduct esp -> esp.getExpireAt();
				case ExpirableProduct ep -> ep.getExpireAt();
				default -> null;
			};

			if (expiry == null) {
				throw new ValidationException("Expiry date is required for expirable products");
			}

			if (!expiry.isAfter(LocalDate.now())) {
				throw new ValidationException("Expiry date must be in the future");
			}
		}
	}
}

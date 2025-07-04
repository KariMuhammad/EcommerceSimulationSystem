package karim.services.user;

import karim.models.Cart;
import karim.models.ExpirableShippableProduct;
import karim.models.ShippableProduct;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ShippingService {
    private static final float RATE_PER_KG = 30.0f;

    /**
     * Calculate Total Weights of Products in Cart of user
     * @param cart
     * @return Weight of product in KG
     */
    public static double totalWeight(Cart cart) {
        return cart.getCartItems().stream()
                .filter(ci -> ci.getProduct().isShippable())
                .mapToDouble(ci -> {
                    double weightGram = switch (ci.getProduct()) {
                        case ShippableProduct sp            -> sp.getWeight();
                        case ExpirableShippableProduct esp  -> esp.getWeight();
                        default -> 0;
                    };
                    return weightGram * ci.getQuantity() / 1000.0; // kg
                })
                .sum();
    }

    /**
     * calculate ths shipping cost based on weight of product in KG
     * @param weightKg
     * @return Shipping Cost in BigDecimal (More accurate)
     */
    public static BigDecimal shippingCost(double weightKg) {
        BigDecimal ratePerKg = BigDecimal.valueOf(RATE_PER_KG);
        BigDecimal roundedWeight = BigDecimal.valueOf(Math.ceil(weightKg));
        return roundedWeight.multiply(ratePerKg);
    }
}

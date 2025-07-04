package karim.services.user;

import karim.models.Cart;

import java.math.BigDecimal;

public class PricingService {
    /**
     * Calculate total price of all items in cart's user
     * @param cart
     * @return Total price of products (without any shipment cost)
     */
    public static BigDecimal subtotal(Cart cart) {
        return cart.getCartItems().stream()
                .map(ci -> BigDecimal.valueOf(ci.getProduct().getPrice())
                        .multiply(BigDecimal.valueOf(ci.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
package karim.services.user;

import karim.models.Cart;
import karim.models.ExpirableShippableProduct;
import karim.models.ShippableProduct;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class ReceiptPrinter {

    // Create Formatter for Money format
    private static final NumberFormat MONEY = NumberFormat.getCurrencyInstance(Locale.US);

    /**
     * Print a simple invoice for User order contains Shipping cost and price cost
     * @param cart - cart's user hold all cart items needed
     * @param weightKg - All Weights in Cart items
     * @param shippingCost
     * @param subtotal - Total price for all cart items needed
     */
    public static void print(Cart cart, double weightKg, BigDecimal shippingCost, BigDecimal subtotal) {
        System.out.println("** Shipment notice **\n");
        cart.getCartItems().forEach(ci -> {
            var p = ci.getProduct();
            if (p.isShippable()) {
                double weight = switch (p) {
                    case ShippableProduct sp            -> sp.getWeight();
                    case ExpirableShippableProduct esp  -> esp.getWeight();
                    default -> 0;
                };
                System.out.printf("%dx %s %.0fg\n", ci.getQuantity(), p.getName(), weight * ci.getQuantity());
            }
        });
        System.out.printf("Total package weight %f kg\n", weightKg);

        System.out.println("\n** Checkout receipt **\n");

        cart.getCartItems().forEach(ci -> {
            double total = ci.getQuantity() * ci.getProduct().getPrice();
            System.out.printf("%dx %-10s %.0f$\n", ci.getQuantity(), ci.getProduct().getName(), total);
        });

        System.out.println("----------------------");
        BigDecimal amount = subtotal.add(shippingCost);
        System.out.printf("Subtotal %.0f$\n", subtotal);
        System.out.printf("Shipping %.0f$\n", shippingCost);
        System.out.printf("Amount %.0f$\n", amount);
    }
}

package karim.services.user;

import karim.models.CartItem;
import karim.models.Product;

import java.util.List;

public class InventoryService {
    /**
     * Deducts each CartItem.quantity from its Product.getQuantity()
     */
    public static void reduceStock(List<CartItem> items) {
        for (CartItem ci : items) {
            Product p = ci.getProduct();
            int qty = ci.getQuantity();
            if (qty > p.getQuantity()) {
                throw new IllegalStateException(
                        "Trying to remove more than available stock for " + p.getName()
                );
            }
            // assume your Product has a setter or a reduceQuantity method:
            p.reduceQuantity(qty);
        }
    }
}

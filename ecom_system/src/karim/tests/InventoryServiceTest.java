package karim.tests;

import karim.models.CartItem;
import karim.models.Product;
import karim.models.User;
import karim.services.user.InventoryService;

import java.math.BigDecimal;
import java.util.List;

public class InventoryServiceTest {
    public static void main(String[] args) {
        // given a product with 5 in
        User k = new User("Karim", "askdj", BigDecimal.valueOf(1000));
        Product p = new Product("Widget", 10.0, 5);
        CartItem item = new CartItem(k, p, 2);

        // when we reduce stock
        InventoryService.reduceStock(List.of(item));

        // then remaining stock is 3
        int qty = p.getQuantity();
        assert qty == 3;
    }
}

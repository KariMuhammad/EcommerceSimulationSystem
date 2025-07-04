package karim.models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> cartItems;

    public Cart() {
        this.cartItems = new ArrayList<>();
    }

    /**
     * Add cart item that contains product and quantity into cart (user has) .
     * @param cartItem
     */
    public void add(CartItem cartItem) {
        this.cartItems.add(cartItem);
    }

    public List<CartItem> getCartItems() {
        return this.cartItems;
    }
}

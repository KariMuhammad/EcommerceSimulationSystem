package karim.models;

import karim.services.user.InventoryService;
import karim.services.user.PricingService;
import karim.services.user.ReceiptPrinter;
import karim.services.user.ShippingService;

import java.math.BigDecimal;
import java.sql.SQLOutput;

public class User {
    private String username;
    private String password;
    private BigDecimal balance;
    private Cart cart;

    public User(String username, String password, BigDecimal balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.cart = new Cart();
    }

    public Cart getMyCart() {
        return this.cart;
    }

    public void checkout() {
        double weight = ShippingService.totalWeight(this.cart);
        BigDecimal shippingCost = ShippingService.shippingCost(weight);
        BigDecimal totalPrice = PricingService.subtotal(this.cart);

        if (! (this.balance.compareTo(totalPrice) > 0)) {
            System.out.println("Insufficient balance! You need "
                    + totalPrice.subtract(balance)
                    + " more to complete this purchase.");
            return;  // abort checkout
        }

        // reduce/update quantity of product in stock
        InventoryService.reduceStock(cart.getCartItems());

        this.balance = this.balance.subtract(totalPrice);
        System.out.println("Remaining balance: \n" + balance);
        ReceiptPrinter.print(this.cart, weight, shippingCost, totalPrice);
    }
}

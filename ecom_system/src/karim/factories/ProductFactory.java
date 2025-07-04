package karim.factories;

import karim.models.ExpirableShippableProduct;
import karim.models.ExpirableProduct;
import karim.models.Product;
import karim.models.ShippableProduct;

import java.time.LocalDate;

/**
 * Factory responsible for creating the correct Product variant
 * (Normal, Shippable, Expirable, Expirable+Shippable)
 */
public final class ProductFactory {

    private ProductFactory() {}   // you cannot instantiate object from this class

    /**
     * Creates a product based on the flags you pass.
     *
     * @param name        product name
     * @param price       unit price
     * @param stock       available quantity
     * @param expirable   does it expire?
     * @param shippable   does it need shipping?
     * @param weightGrams weight per unit in grams (required if shippable)
     * @param expiryDate  expiry date (required if expirable)
     */
    public static Product create(String name,
                                 double price,
                                 int stock,
                                 boolean expirable,
                                 boolean shippable,
                                 Double weightGrams,
                                 LocalDate expiryDate) {

        if (expirable && shippable) {
            if (weightGrams == null || expiryDate == null)
                throw new IllegalArgumentException("Weight and expiry date are required");
            return new ExpirableShippableProduct(name, price, stock,
                    expiryDate, weightGrams);
        }
        if (expirable) {
            if (expiryDate == null)
                throw new IllegalArgumentException("Expiry date is required");
            return new ExpirableProduct(name, price, stock, expiryDate);
        }
        if (shippable) {
            if (weightGrams == null)
                throw new IllegalArgumentException("Weight is required");
            return new ShippableProduct(name, price, stock, weightGrams);
        }
        return new Product(name, price, stock);
    }

    /* -------- Convenience helpers -------- */

    /**
     * factory method to create simple product (non-expirable, non-shippable) object
     * @param name
     * @param price
     * @param stock
     * @return Product product
     */
    public static Product simple(String name, double price, int stock) {
        return new Product(name, price, stock);
    }

    /**
     * factory method to create expirable product object
     * @param name
     * @param price
     * @param stock
     * @param expiry
     * @return ExpirableProduct product
     */
    public static Product expirable(String name, double price, int stock, LocalDate expiry) {
        return new ExpirableProduct(name, price, stock, expiry);
    }

    /**
     * factory method to create shippable product object
     * @param name
     * @param price
     * @param stock
     * @param weightGrams
     * @return ShippableProduct product
     */
    public static Product shippable(String name, double price, int stock, double weightGrams) {
        return new ShippableProduct(name, price, stock, weightGrams);
    }

    /**
     * method factory to create expirable & shippable product object
     * @param name
     * @param price
     * @param stock
     * @param expireAt
     * @param weightGrams
     * @return ExpirableShippableProduct product
     */
    public static Product expirable_shippable(String name, double price, int stock, LocalDate expireAt, double weightGrams) {
        return new ExpirableShippableProduct(name, price, stock, expireAt, weightGrams);
    }
}

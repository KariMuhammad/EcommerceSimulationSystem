package karim.tests;

import karim.Validator;
import karim.factories.ProductFactory;
import karim.models.ExpirableProduct;
import karim.models.ExpirableShippableProduct;
import karim.models.Product;
import karim.models.ShippableProduct;
import karim.rules.products.AvailableStockRule;
import karim.rules.products.NameEmptyRule;
import karim.rules.products.PositivePriceRule;
import karim.rules.products.WeightRule;

import java.time.LocalDate;
import java.util.List;

public class ProductFactoryTest {
    public static void main(String[] args) {
        Validator<Product> validatorsOfProducts = Validator.of(List.of(
                new NameEmptyRule(),
                new PositivePriceRule(),
                new AvailableStockRule(),
                new WeightRule() ));

        // 1# Simple test if product factory return correct object with specified arguments
        Product p = ProductFactory.shippable("TV", 1000, 5, 10000);
        assert p.getName().equals("TV");
        assert p.getPrice() == 1000;
        assert p.getQuantity() == 5;
        assert p instanceof ExpirableProduct;

        // 2# No name in Product
        // Product cheese = new ExpirableProduct("", 50, 100, LocalDate.now().plusDays(10));
        // validatorsOfProducts.validate(cheese);

        // 3# No Weight in Shippable Product
        // Product tv = new ShippableProduct("LG NanoCell AI NANO80 4K", 50_000, 5, 0);
        // validatorsOfProducts.validate(tv);

        // 4# No Price
        // Product homeOffice = new ShippableProduct("مكتب شباب أبيض: أنيق، عصري، وظيفي\n", 0, 3, 400 * 1000);

    }
}
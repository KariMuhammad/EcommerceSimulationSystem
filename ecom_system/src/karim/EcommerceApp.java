package karim;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import karim.factories.ProductFactory;
import karim.models.*;
import karim.rules.products.AvailableStockRule;
import karim.rules.products.NameEmptyRule;
import karim.rules.products.PositivePriceRule;

public class EcommerceApp {

	public static void start(String[] args) {
		/* Setup One Validator for Creating Products */
		Validator<Product> validatorsOfProducts = Validator.of(List.of(
					new NameEmptyRule(),
					new PositivePriceRule(),
					new AvailableStockRule() ));

		/* -------- 1) Creating Fake Products -------- */
		Product cheese = new ExpirableProduct("Cheese", 50, 100, LocalDate.now().plusDays(10));
		Product tv = new ShippableProduct("LG NanoCell AI NANO80 4K", 50_000, 5, 60);
		Product homeOffice = new ShippableProduct("مكتب شباب أبيض: أنيق، عصري، وظيفي\n", 50_000, 3, 400 * 1000);
		Product alienPC = ProductFactory.shippable("Alien PC", 100_000, 7, 60_000);


		/* -------- 2) Validate Specific Products with specific rules -------- */
		// TODO: i can wrap these validations inside constructor more better
		validatorsOfProducts.validate(cheese);
		validatorsOfProducts.validate(tv);
		validatorsOfProducts.validate(homeOffice);

		/* -------- 3) Create user -> Each user has Cart -------- */
		User karim = new User("Karim Muhammad", "PlainText", BigDecimal.valueOf(1000_000)); // has Million Dollar

		/* -------- 4) Add Cart Items in Cart of User -------- */
		CartItem cheeseCartItem = new CartItem(karim, cheese, 11);
		CartItem tvCartItem = new CartItem(karim, tv, 2);
		CartItem homeOfficeCartItem = new CartItem(karim, homeOffice, 1);
		// CartItem alienPCCartItem = new CartItem(karim, alienPC, 8); // quantity exceeds available stock (7)
		CartItem alienPCCartItem = new CartItem(karim, alienPC, 5);

		/* -------- 5) Show All data in Cart's karim -------- */
		karim.checkout();


		System.out.println(alienPC.getQuantity());
	}
}

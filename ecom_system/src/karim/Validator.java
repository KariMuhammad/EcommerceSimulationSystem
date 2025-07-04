package karim;

import java.util.List;

import karim.contracts.IRule;

/**
 * class Validator to create validation layer with rules to check if target is valid or not based on specified rules
 * @param <T>
 */

// No classes can inherit from this class
public final class Validator<T> {
	private List<IRule<T>> rules;
	
	
	// cannot create object from this class
	private Validator(List<IRule<T>> rules) {
		this.rules = List.copyOf(rules);
	}

	/**
	 * Specify the rules you need to apply on this validation layer
	 * @param rules
	 * @return Validation Layer
	 */
	public static <T> Validator<T> of(List<IRule<T>> rules) {
		return new Validator(rules);
	}

	/**
	 * Apply this validation layer on specified type
	 * @param target
	 */
	public void validate(T target) {
		this.rules.forEach((r) -> r.check(target));
	}
}
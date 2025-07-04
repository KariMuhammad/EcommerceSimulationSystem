package karim.contracts;

import karim.ValidationException;

public interface IRule<T> {
    /**
     * Throws ValidationException if rule is broken.
     */
    void check(T target) throws ValidationException;
}
package wakandaforever.wakandaforever.validators.base;

public interface Validator<T> {
    boolean isValid(T object);
}

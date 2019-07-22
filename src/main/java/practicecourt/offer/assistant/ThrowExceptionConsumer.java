package practicecourt.offer.assistant;

@FunctionalInterface
public interface ThrowExceptionConsumer<T> {

    void accept(T t) throws Exception;
}

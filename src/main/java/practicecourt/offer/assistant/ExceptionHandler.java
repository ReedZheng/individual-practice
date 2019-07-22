package practicecourt.offer.assistant;

import java.util.Objects;
import java.util.function.Consumer;

public class ExceptionHandler {

    public static <T> Consumer<T> toConsumer(ThrowExceptionConsumer<T> mapper) {
        Objects.requireNonNull(mapper);
        return t -> {
            try {
                mapper.accept(t);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}

package net.fortresswars.helpers;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Supplier;

public class ObjectHelper {

    @SafeVarargs
    public static <T> T coalesce(Supplier<T>... ts) {
        return Arrays.stream(ts)
                .map(Supplier::get)
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(null);
    }
}

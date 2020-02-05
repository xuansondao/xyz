package common.type;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Gender {
    MALE('M'), FEMALE('F');

    private static Map<Character, Gender> statusMap;

    static {
        statusMap = Stream.of(values()).collect(Collectors.toMap(Gender::getValue, Function.identity()));
    }

    private Character value;

    Gender(Character value) {
        this.value = value;
    }

    public static Gender valueOf(Character value) {
        return statusMap.get(value);
    }

    public Character getValue() {
        return value;
    }
}

package common.type;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Status {
    ACTIVE(0), INACTIVE(1);

    private static Map<Integer, Status> statusMap;

    static {
        statusMap = Stream.of(values()).collect(Collectors.toMap(Status::getValue, Function.identity()));
    }

    private Integer value;

    Status(Integer value) {
        this.value = value;
    }

    public static Status valueOf(Integer value) {
        return statusMap.get(value);
    }

    public Integer getValue() {
        return value;
    }
}

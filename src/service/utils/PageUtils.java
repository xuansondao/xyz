package service.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;
import vn.com.vndirect.brokerinsight.service.exception.InvalidSortByParameter;

import java.util.Arrays;
import java.util.stream.Stream;

public class PageUtils {
    /**
     * field1,field2:ASC;field3,field6:ASC;field4,field5:DESC
     *
     * @param page
     * @param size
     * @param sortBy
     * @return
     * @throws InvalidSortByParameter
     */
    public static Pageable createPageable(int page, int size, String sortBy) throws InvalidSortByParameter {
        return StringUtils.isEmpty(sortBy) ? createPageable(page, size) :
                createPageable(page, size, sortBy.split(";"));
    }

    public static Pageable createPageable(int page, int size) {
        return PageRequest.of(page - 1, size);
    }

    public static Pageable createPageable(int page, int size, String[] directions) throws InvalidSortByParameter {
        if (directions == null) {
            return createPageable(page, size);
        }
        try {
            Sort sort = Stream.of(directions).map(direction -> {
                String[] order = direction.split(":");
                if (order.length != 2) {
                    throw new IllegalArgumentException();
                }
                return new Sort(Sort.Direction.fromString(order[1]), order[0].split(","));
            }).reduce(Sort::and).orElse(null);
            return PageRequest.of(page - 1, size, sort);
        } catch (IllegalArgumentException e) {
            throw new InvalidSortByParameter(Arrays.toString(directions));
        }
    }
}

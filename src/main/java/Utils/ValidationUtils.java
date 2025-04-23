package Utils;

import java.util.List;
import java.util.Map;

public class ValidationUtils {

    public static boolean isInputDataNotValid(List<?> list) {
        return (list == null || list.isEmpty());
    }

    public static boolean isInputDataNotValid(Map<?, ?> map) {
        return (map == null || map.isEmpty());
    }

    public static boolean isInputDataNotValid(Object[] array) {
        return array == null || array.length == 0;
    }
}

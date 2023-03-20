package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StringSchema {
    private List<Predicate> conditions = new ArrayList<>();

    public StringSchema required() {
        conditions.add(condition -> condition instanceof String && !"".equals(condition) && conditions != null);
        return this;
    }
    public StringSchema minLength(int stringLength) {
        conditions.add(condition -> condition.toString().length() >= stringLength);
        return this;
    }
    public StringSchema contains(String string) {
        conditions.add(condition -> condition.toString().contains(string));
        return this;
    }
    public boolean isValid(Object object) {
        for (var condition : conditions) {
            if (!condition.test(object)) {
                return false;
            }
        }
        return true;
    }
}

package hexlet.code.schemas;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {
    private List<Predicate> conditions = new ArrayList<>();
    private boolean check;
    public void addConditions(Predicate condition) {
        conditions.add(condition);
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

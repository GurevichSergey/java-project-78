package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {
    public final NumberSchema required() {
        addConditions(condition -> condition instanceof Number);
        return this;
    }
    public final NumberSchema positive() {
        addConditions(condition -> condition instanceof Integer && (Integer) condition > 0
                || condition == null);
        return this;
    }
    public final NumberSchema range(int begin, int end) {
        addConditions(condition -> (Integer) condition >= begin && (Integer) condition <= end);
        return this;
    }
}

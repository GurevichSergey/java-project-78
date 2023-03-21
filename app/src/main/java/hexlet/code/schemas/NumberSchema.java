package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {
    public void required() {
        addConditions(condition -> condition instanceof Number);
    }
    public NumberSchema positive() {
        addConditions(condition -> condition instanceof Integer && (Integer) condition > 0
                || condition == null);
        return this;
    }
    public void range(int begin, int end) {
        addConditions(condition -> (Integer) condition >= begin && (Integer) condition <= end);
    }
}

package hexlet.code.schemas;

public class StringSchema extends BaseSchema {

    public final StringSchema required() {
        addConditions(condition -> condition instanceof String && !"".equals(condition));
        return this;
    }
    public final StringSchema minLength(int stringLength) {
        addConditions(condition -> condition.toString().length() >= stringLength);
        return this;
    }
    public final StringSchema contains(String string) {
        addConditions(condition -> condition.toString().contains(string));
        return this;
    }

}

package hexlet.code.schemas;

public class StringSchema extends BaseSchema {

    public StringSchema required() {
        addConditions(condition -> condition instanceof String && !"".equals(condition) && condition != null);
        return this;
    }
    public StringSchema minLength(int stringLength) {
        addConditions(condition -> condition.toString().length() >= stringLength);
        return this;
    }
    public StringSchema contains(String string) {
        addConditions(condition -> condition.toString().contains(string));
        return this;
    }

}

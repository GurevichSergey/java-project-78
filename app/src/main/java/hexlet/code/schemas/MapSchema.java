package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema {
    public MapSchema required() {
        addConditions(condition -> condition instanceof Map && condition != null);
        return this;
    }
    public MapSchema sizeof(int size) {
        addConditions(condition -> condition instanceof Map && ((Map) condition).size() == size);
        return this;
    }
}

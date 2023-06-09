package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema {
    public final MapSchema required() {
        addConditions(condition -> condition instanceof Map);
        return this;
    }
    public final MapSchema sizeof(int size) {
        addConditions(condition -> condition instanceof Map && ((Map) condition).size() == size);
        return this;
    }
    public final MapSchema shape(Map<String, BaseSchema> schemasMap) {
        addConditions(map -> checkingValid((Map<String, BaseSchema>) map, schemasMap));
        return this;
    }
    public final boolean checkingValid(Map<String, BaseSchema> baseMap, Map<String, BaseSchema> shamedMap) {
        for (var pair : shamedMap.entrySet()) {
            var key = pair.getKey();
            if (!pair.getValue().isValid(baseMap.get(key))) {
                return false;
            }
        }
        return true;
    }
}

### Hexlet tests and linter status:
[![Actions Status](https://github.com/GurevichSergey/java-project-78/workflows/hexlet-check/badge.svg)](https://github.com/GurevichSergey/java-project-78/actions)
[![Actions Status](https://github.com/GurevichSergey/java-project-78/workflows/my-check/badge.svg)](https://github.com/GurevichSergey/java-project-78/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/6d73884cbdf2acd08d18/maintainability)](https://codeclimate.com/github/GurevichSergey/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/6d73884cbdf2acd08d18/test_coverage)](https://codeclimate.com/github/GurevichSergey/java-project-78/test_coverage)

# Валидатор данных:
Валидатор данных – библиотека, с помощью которой можно проверять корректность любых данных. Подобных библиотек множество в каждом языке, так как практически все программы работают с внешними данными, которые нужно проверять на корректность. В первую очередь речь идет про данные форм заполняемых пользователями. За основу для проекта взята библиотека yup.

## Пример использования:

```
import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.BaseSchema;

Validator v = new Validator();

// строки
StringSchema schema = v.string().required();

schema.isValid("what does the fox say"); // true
schema.isValid(""); // false

// числа
NumberSchema schema = v.number().required().positive();

schema.isValid(-10); // false
schema.isValid(10); // true

// объект Map с поддержкой проверки структуры
Map<String, BaseSchema> schemas = new HashMap<>();
schemas.put("name", v.string().required());
schemas.put("age", v.number().positive());

MapSchema schema = v.map().sizeof(2).shape(schemas);

Map<String, Object> human1 = new HashMap<>();
human1.put("name", "Kolya");
human1.put("age", 100);
schema.isValid(human1); // true

Map<String, Object> human2 = new HashMap<>();
human2.put("name", "");
human2.put("age", null);
schema.isValid(human1); // false
```

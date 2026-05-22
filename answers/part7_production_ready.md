# Часть 7: Production-ready практики

## 7.1 Validation

1. Что произойдёт, если убрать `@Valid`?

Ответ: 

2. Чем `@NotNull` отличается от `@NotBlank` для `String`?

Ответ: 

3. Когда запускается валидация?

Ответ: 

## 7.2 DTO and Mapper

1. Зачем разделять Entity и DTO?

Ответ: 

2. Что может случиться при возврате lazy entity напрямую?

Ответ: 

3. Преимущества `record` для DTO?

Ответ: 

## 7.3 Global errors

1. `@RestControllerAdvice` vs `@ControllerAdvice`?

Ответ: 

2. Как выбирается exception handler?

Ответ: 

3. Почему обработчик `Exception.class` логически последний?

Ответ: 

## 7.4 Transactions

1. Где ставить `@Transactional` и почему?

Ответ: 

2. Что значит `readOnly = true`?

Ответ: 

3. Назовите 3 ловушки transactional-proxy.

Ответ: 

4. При каких исключениях транзакция откатывается по умолчанию?

Ответ: 

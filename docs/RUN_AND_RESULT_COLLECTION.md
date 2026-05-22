# Сбор результатов

## 1. Запуск тестов

Windows PowerShell:

```powershell
.\mvnw.cmd clean test
```

Linux / macOS:

```bash
./mvnw clean test
```

Запишите результат в:

```text
results/part6_part7_test_results.txt
```

## 2. Запуск приложения

Windows PowerShell:

```powershell
.\mvnw.cmd spring-boot:run
```

Linux / macOS:

```bash
./mvnw spring-boot:run
```

## 3. Проверка greeting endpoint

```bash
curl http://localhost:8080/api/greet/World
```

Ожидаемый результат:

```text
Hello, World!
```

## 4. Проверка списка студентов

```bash
curl -u user:password http://localhost:8080/api/students
```

Ожидаемый результат: JSON array со студентами `Sash`, `Jone`, `Deema`, `Ekatrena`.

## 5. Проверка POST для admin

```bash
curl -u admin:password -X POST http://localhost:8080/api/students   -H "Content-Type: application/json"   -d '{"name":"Sash","surname":"Brown"}'
```

Ожидаемый результат: `HTTP 201` и JSON созданного студента.

## 6. Проверка запрета удаления для user

```bash
curl -i -u user:password -X DELETE http://localhost:8080/api/students/1
```

Ожидаемый результат: `HTTP 403 Forbidden`.

## 7. Проверка validation error

```bash
curl -i -u admin:password -X POST http://localhost:8080/api/students   -H "Content-Type: application/json"   -d '{"name":"","surname":"A"}'
```

Ожидаемый результат: `HTTP 400` и JSON с `fieldErrors`.

## 8. Проверка Thymeleaf UI

Откройте:

```text
http://localhost:8080/students
```

Войдите как:

```text
admin / password
```

Сделайте скриншот страницы и кратко опишите результат в:

```text
results/part4_web_ui_notes.txt
```

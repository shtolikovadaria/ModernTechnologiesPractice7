# Карта учебных блоков кода

В этой практической работе основные учебные фрагменты выделены маркерами `ВАШ КОД ЗДЕСЬ`.

Студент должен открыть указанные файлы, прочитать код внутри маркеров и объяснить его работу в файлах из папки `answers/`.

| Часть | Файл | Что изучить |
|---|---|---|
| 2.1 | `greet/EnglishGreetingService.java` | `@Service`, `@Primary`, реализация интерфейса |
| 2.1 | `greet/GreetingController.java` | Вызов сервиса из REST controller |
| 2.2 | `ConstructorInjectionDemo.java` | Constructor Injection |
| 2.2 | `SetterInjectionDemo.java` | Setter Injection |
| 2.2 | `FieldInjectionDemo.java` | Field Injection и его недостатки |
| 3.1 | `model/Student.java` | JPA entity и setters |
| 3.2 | `StudentServiceImpl.java` | Service layer, transactions, repository calls |
| 3.3 | `StudentRestController.java` | REST CRUD endpoints |
| 4.1 | `StudentWebController.java` | Thymeleaf controller |
| 4.2 | `templates/students.html` | Form, `th:object`, `th:field`, `th:each` |
| 5.1 | `SecurityConfig.java` | Authorization rules, HTTP Basic, form login |
| 6.1 | `StudentRepository.java` | Spring Data query methods |
| 6.2 | `LoggingAspect.java` | AOP logging |
| 6.3 | `AppInitializer.java` | Initial data with `@PostConstruct` |
| 6.4 | `StudentRestControllerTest.java` | MockMvc JSON assertions |
| 7.1 | `StudentRequest.java` | Bean Validation |
| 7.2 | `StudentMapper.java` | DTO mapping |
| 7.3 | `GlobalExceptionHandler.java` | Structured API errors |
| 7.4 | `TxPitfallService.java` | Transactional self-invocation pitfall |

## Как отвечать

Не переписывайте весь код. Для каждого блока объясните:

1. Какую задачу выполняет код.
2. Какие Spring annotations используются.
3. Какие зависимости внедряются через DI.
4. Какой endpoint или тест проверяет этот код.
5. Какой результат получен после запуска.

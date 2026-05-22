# Часть 8: Контрольные вопросы

1. Сформулируйте принцип IoC своими словами. Чем он отличается от обычного процедурного подхода?

Ответ: 

2. Назовите три способа DI в Spring. Какой из них предпочтителен и почему?

Ответ: 

3. Чем отличаются `@Component`, `@Service`, `@Repository`, `@Controller`?

Ответ: 

4. Чем `@RestController` отличается от `@Controller`?

Ответ: 

5. Что делает аннотация `@SpringBootApplication`?

Ответ: 

6. Что такое starter-модуль? Приведите 3 примера и опишите, что они подключают.

Ответ: 

7. Что такое `ApplicationContext` и чем он отличается от `BeanFactory`?

Ответ: 

8. Какие scope бинов вы знаете и в чём их различие?

Ответ: 

9. Объясните AOP: Aspect, JoinPoint, Pointcut, Advice.

Ответ: 

10. Что делает `@PathVariable` и чем отличается от `@RequestParam`?

Ответ: 

11. Объясните цепочку `Controller → Service → Repository`.

Ответ: 

12. Что такое `JpaRepository`? Как Spring Data генерирует методы вида `findByNameContainingIgnoreCase`?

Ответ: 

13. Как Thymeleaf получает данные от контроллера и подставляет их в шаблон?

Ответ: 

14. Что такое `SecurityFilterChain`?

Ответ: 

15. Зачем нужен `PasswordEncoder` и почему пароли нельзя хранить открыто?

Ответ: 

16. Опишите алгоритм JWT-аутентификации.

Ответ: 

17. Преимущество JWT перед session-based authentication для REST API?

Ответ: 

18. Зачем нужна `@Valid`?

Ответ: 

19. Перечислите 5 проблем возврата `@Entity` напрямую из REST.

Ответ: 

20. `@RestControllerAdvice` vs `@ControllerAdvice`?

Ответ: 

21. Почему `@Transactional` лучше ставить на сервисном слое?

Ответ: 

22. Что такое self-invocation в `@Transactional`?

Ответ: 

23. Откатится ли транзакция по умолчанию при checked-исключении, например `IOException`?

Ответ: 

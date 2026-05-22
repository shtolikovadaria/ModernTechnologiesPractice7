package lecture.seven.student.greet;

import org.springframework.stereotype.Component;

@Component
public class ConstructorInjectionDemo {

    private final GreetingService service;

    public ConstructorInjectionDemo(GreetingService service) {
        // ЗАДАНИЕ part2_2: в ответах объясните, почему внедрение через конструктор поддерживает final-поля.
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        this.service = service;
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    public String demo(String name) {
        return service.greet(name);
    }
}

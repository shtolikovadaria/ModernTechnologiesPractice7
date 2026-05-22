package lecture.seven.student.greet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FieldInjectionDemo {

    // ЗАДАНИЕ part2_2: внедрение через поле работает, но в ответах объясните, почему его обычно не рекомендуют.
    // ▼ ВАШ КОД ЗДЕСЬ ▼
    @Autowired
    private GreetingService service;
    // ▲ КОНЕЦ ВАШЕГО КОДА ▲

    public String demo(String name) {
        return service.greet(name);
    }
}

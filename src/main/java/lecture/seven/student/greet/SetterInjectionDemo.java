package lecture.seven.student.greet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SetterInjectionDemo {

    private GreetingService service;

    @Autowired
    public void setService(GreetingService service) {
        // ЗАДАНИЕ part2_2: завершите внедрение через setter и сравните его с внедрением через конструктор.
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        this.service = service;
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    public String demo(String name) {
        return service.greet(name);
    }
}

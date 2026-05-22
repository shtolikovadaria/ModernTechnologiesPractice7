package lecture.seven.student.greet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/greet")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/{name}")
    public String greet(@PathVariable String name) {
        // ЗАДАНИЕ part2_1: вызовите внедренный сервис вместо фиксированной заглушки.
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        return greetingService.greet(name);
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }
}

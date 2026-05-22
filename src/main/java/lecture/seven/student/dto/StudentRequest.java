package lecture.seven.student.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record StudentRequest(
        // ЗАДАНИЕ part7_1: настройте сообщения валидации и объясните различие @NotBlank и @NotNull.
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        @NotBlank(message = "Имя обязательно")
        @Size(min = 2, max = 100, message = "Имя должно содержать от 2 до 100 символов")
        String name,

        @NotBlank(message = "Фамилия обязательна")
        @Size(min = 2, max = 100, message = "Фамилия должна содержать от 2 до 100 символов")
        String surname
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
) {
}

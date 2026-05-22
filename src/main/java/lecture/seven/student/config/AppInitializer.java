package lecture.seven.student.config;

import jakarta.annotation.PostConstruct;
import lecture.seven.student.model.Student;
import lecture.seven.student.repository.StudentRepository;
import org.springframework.stereotype.Component;

@Component
public class AppInitializer {

    private final StudentRepository repository;

    public AppInitializer(StudentRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void init() {
        // ЗАДАНИЕ part6_3: заполните базу начальными данными только если она пустая.
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        if (repository.count() == 0) {
            repository.save(new Student("Sash", "Brown"));
            repository.save(new Student("Jone", "Smith"));
            repository.save(new Student("Deema", "Johnson"));
            repository.save(new Student("Ekatrena", "Wilson"));
        }
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }
}

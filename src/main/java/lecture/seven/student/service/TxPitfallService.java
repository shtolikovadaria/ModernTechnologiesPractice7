package lecture.seven.student.service;

import lecture.seven.student.model.Student;
import lecture.seven.student.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TxPitfallService {

    private final StudentRepository repository;

    public TxPitfallService(StudentRepository repository) {
        this.repository = repository;
    }

    public void outerWithoutAnnotation(Student good, Student bad) {
        // ЗАДАНИЕ part7_4: объясните, почему self-invocation обходит транзакционный proxy Spring.
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        this.innerWithTransaction(good, bad);
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    @Transactional
    public void innerWithTransaction(Student good, Student bad) {
        // ЗАДАНИЕ part7_4: сравните поведение при вызове через proxy и через this.innerWithTransaction(...).
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        repository.save(good);
        if (bad.getName() == null || bad.getName().isBlank()) {
            throw new IllegalStateException("Bad student");
        }
        repository.save(bad);
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }
}

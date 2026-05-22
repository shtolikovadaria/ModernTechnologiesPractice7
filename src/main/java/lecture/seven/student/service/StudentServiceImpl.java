package lecture.seven.student.service;

import jakarta.persistence.EntityNotFoundException;
import lecture.seven.student.model.Student;
import lecture.seven.student.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        // ЗАДАНИЕ part3_2 / part7_4: передайте вызов в репозиторий и объясните транзакции readOnly.
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        return repository.findAll();
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    @Override
    @Transactional
    public Student save(Student student) {
        // ЗАДАНИЕ part3_2 / part7_4: сохраните студента через репозиторий.
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        return repository.save(student);
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    @Override
    @Transactional(readOnly = true)
    public Student findById(Long id) {
        // ЗАДАНИЕ part3_2 / part7_3: сначала разберите вариант с null, затем замените его на EntityNotFoundException.
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student with id " + id + " not found"));
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        // ЗАДАНИЕ part3_2: удалите студента по id.
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Student with id " + id + " not found");
        }
        repository.deleteById(id);
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> searchByName(String q) {
        // ЗАДАНИЕ part6_1: вызовите пользовательский метод репозитория.
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        return repository.findByNameContainingIgnoreCase(q);
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> searchBySurname(String q) {
        // ЗАДАНИЕ part6_1: вызовите пользовательский метод репозитория.
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        return repository.findBySurnameContainingIgnoreCase(q);
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    @Override
    @Transactional(readOnly = true)
    public long countByName(String name) {
        // ЗАДАНИЕ part6_1: вызовите пользовательский метод репозитория.
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        return repository.countByName(name);
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    @Override
    @Transactional
    public void saveTwoOneBroken(Student good, Student bad) {
        // ЗАДАНИЕ part7_4: проследите откат транзакции, когда исключение возникает после первого сохранения.
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        repository.save(good);
        if (bad.getName() == null || bad.getName().isBlank()) {
            throw new IllegalStateException("Имя не может быть пустым");
        }
        if (bad.getSurname() == null || bad.getSurname().isBlank()) {
            throw new IllegalStateException("Фамилия не может быть пустой");
        }
        repository.save(bad);
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }
}

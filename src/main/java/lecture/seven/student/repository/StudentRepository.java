package lecture.seven.student.repository;

import lecture.seven.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    // ЗАДАНИЕ part6_1: используйте имена методов Spring Data и объясните, как Spring создает реализации.
    // ▼ ВАШ КОД ЗДЕСЬ ▼
    List<Student> findByNameContainingIgnoreCase(String namePart);

    List<Student> findBySurnameContainingIgnoreCase(String surnamePart);

    long countByName(String name);
    // ▲ КОНЕЦ ВАШЕГО КОДА ▲
}

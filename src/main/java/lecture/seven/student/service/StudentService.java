package lecture.seven.student.service;

import lecture.seven.student.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student save(Student student);

    Student findById(Long id);

    void deleteById(Long id);

    List<Student> searchByName(String q);

    List<Student> searchBySurname(String q);

    long countByName(String name);

    void saveTwoOneBroken(Student good, Student bad);
}

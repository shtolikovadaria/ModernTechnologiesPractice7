package lecture.seven.student.dto;

import lecture.seven.student.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student toEntity(StudentRequest request) {
        // ЗАДАНИЕ part7_2: преобразуйте request DTO в entity.
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        Student student = new Student();
        student.setName(request.name());
        student.setSurname(request.surname());
        return student;
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    public StudentResponse toResponse(Student student) {
        // ЗАДАНИЕ part7_2: преобразуйте entity в response DTO.
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        return new StudentResponse(student.getId(), student.getName(), student.getSurname());
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }
}

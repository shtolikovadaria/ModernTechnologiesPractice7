package lecture.seven.student.service;

import jakarta.persistence.EntityNotFoundException;
import lecture.seven.student.model.Student;
import lecture.seven.student.repository.StudentRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class StudentServiceImplTest {

    private final StudentRepository repository = mock(StudentRepository.class);
    private final StudentServiceImpl service = new StudentServiceImpl(repository);

    @Test
    void findById_existingStudent_returnsStudent() {
        Student student = new Student(1L, "Sash", "Brown");
        when(repository.findById(1L)).thenReturn(Optional.of(student));

        Student result = service.findById(1L);

        assertEquals("Sash", result.getName());
        assertEquals("Brown", result.getSurname());
    }

    @Test
    void findById_missingStudent_throwsEntityNotFoundException() {
        when(repository.findById(404L)).thenReturn(Optional.empty());

        EntityNotFoundException ex = assertThrows(EntityNotFoundException.class,
                () -> service.findById(404L));

        assertEquals("Student with id 404 not found", ex.getMessage());
    }

    @Test
    void save_delegatesToRepository() {
        Student student = new Student("Deema", "Johnson");
        Student saved = new Student(2L, "Deema", "Johnson");
        when(repository.save(student)).thenReturn(saved);

        Student result = service.save(student);

        assertEquals(2L, result.getId());
        verify(repository).save(student);
    }
}

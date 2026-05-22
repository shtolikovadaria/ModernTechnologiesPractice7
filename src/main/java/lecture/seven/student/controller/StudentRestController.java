package lecture.seven.student.controller;

import jakarta.validation.Valid;
import lecture.seven.student.dto.StudentMapper;
import lecture.seven.student.dto.StudentRequest;
import lecture.seven.student.dto.StudentResponse;
import lecture.seven.student.model.Student;
import lecture.seven.student.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {

    private final StudentService service;
    private final StudentMapper mapper;

    public StudentRestController(StudentService service, StudentMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public List<StudentResponse> getAll() {
        // ЗАДАНИЕ part3_3 / part7_2: возвращайте студентов через DTO, а не через entity.
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        return service.findAll().stream()
                .map(mapper::toResponse)
                .toList();
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<StudentResponse> getById(@PathVariable Long id) {
        // ЗАДАНИЕ part3_3 / part7_3: обработайте отсутствие студента через 404 или GlobalExceptionHandler.
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        return ResponseEntity.ok(mapper.toResponse(service.findById(id)));
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<StudentResponse> create(@Valid @RequestBody StudentRequest request) {
        // ЗАДАНИЕ part3_3 / part7_1: создайте студента и верните HTTP 201.
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        Student saved = service.save(mapper.toEntity(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(saved));
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<StudentResponse> update(@PathVariable Long id,
                                                  @Valid @RequestBody StudentRequest request) {
        // ЗАДАНИЕ part3_3 / part7_1: обновите существующего студента или верните 404.
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        service.findById(id);
        Student entity = mapper.toEntity(request);
        entity.setId(id);
        return ResponseEntity.ok(mapper.toResponse(service.save(entity)));
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        // ЗАДАНИЕ part3_3 / part5_2: удаление должен выполнять только ADMIN.
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        service.deleteById(id);
        return ResponseEntity.noContent().build();
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    @GetMapping("/search")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public List<StudentResponse> search(@RequestParam String q,
                                        @RequestParam(defaultValue = "name") String by) {
        // ЗАДАНИЕ part6_1: поддержите поиск по имени и фамилии.
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        List<Student> result = "surname".equalsIgnoreCase(by)
                ? service.searchBySurname(q)
                : service.searchByName(q);
        return result.stream().map(mapper::toResponse).toList();
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }
}

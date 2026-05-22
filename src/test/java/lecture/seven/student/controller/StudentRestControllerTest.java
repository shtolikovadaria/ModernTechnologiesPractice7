package lecture.seven.student.controller;

import jakarta.persistence.EntityNotFoundException;
import lecture.seven.student.dto.StudentMapper;
import lecture.seven.student.model.Student;
import lecture.seven.student.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentRestController.class)
@AutoConfigureMockMvc(addFilters = false)
@Import(StudentMapper.class)
class StudentRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockitoBean
    private StudentService service;

    @Test
    void getAll_ok() throws Exception {
        // ЗАДАНИЕ part6_4: добавьте более строгие проверки JSON-содержимого.
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        when(service.findAll()).thenReturn(List.of(
                new Student(1L, "Sash", "Brown"),
                new Student(2L, "Jone", "Smith")
        ));

        mvc.perform(get("/api/students"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Sash"))
                .andExpect(jsonPath("$[0].surname").value("Brown"))
                .andExpect(jsonPath("$[1].name").value("Jone"));
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    @Test
    void getById_notFound_returnsStructured404() throws Exception {
        when(service.findById(99L)).thenThrow(new EntityNotFoundException("Student with id 99 not found"));

        mvc.perform(get("/api/students/99"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status").value(404))
                .andExpect(jsonPath("$.message").value("Student with id 99 not found"));
    }

    @Test
    void create_validRequest_returns201() throws Exception {
        when(service.save(any(Student.class))).thenReturn(new Student(10L, "Deema", "Johnson"));

        mvc.perform(post("/api/students")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Deema\",\"surname\":\"Johnson\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(10))
                .andExpect(jsonPath("$.name").value("Deema"))
                .andExpect(jsonPath("$.surname").value("Johnson"));
    }

    @Test
    void create_invalidRequest_returns400WithFieldErrors() throws Exception {
        mvc.perform(post("/api/students")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"\",\"surname\":\"A\"}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.fieldErrors.name").exists())
                .andExpect(jsonPath("$.fieldErrors.surname").exists());
    }

    @Test
    void delete_existingStudent_returns204() throws Exception {
        doNothing().when(service).deleteById(1L);

        mvc.perform(delete("/api/students/1"))
                .andExpect(status().isNoContent());
    }
}

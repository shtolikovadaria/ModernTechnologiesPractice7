package lecture.seven.student.controller;

import lecture.seven.student.model.Student;
import lecture.seven.student.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class StudentWebController {

    private final StudentService service;

    public StudentWebController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        // ЗАДАНИЕ part4_1: добавьте список студентов и пустой объект формы в model.
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        model.addAttribute("students", service.findAll());
        model.addAttribute("student", new Student());
        return "students";
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Student student) {
        // ЗАДАНИЕ part4_1: сохраните объект формы и выполните redirect на страницу списка.
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        service.save(student);
        return "redirect:/students";
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        // ЗАДАНИЕ part4_1: удалите запись и выполните redirect.
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        service.deleteById(id);
        return "redirect:/students";
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }
}

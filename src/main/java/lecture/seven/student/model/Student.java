package lecture.seven.student.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "surname", nullable = false, length = 100)
    private String surname;

    public Student() {
    }

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Student(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        // ЗАДАНИЕ part3_1 / part7_1: проверка данных должна гарантировать, что имя не пустое.
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        this.name = name;
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        // ЗАДАНИЕ part3_1 / part7_1: проверка данных должна гарантировать, что фамилия не пустая.
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        this.surname = surname;
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}

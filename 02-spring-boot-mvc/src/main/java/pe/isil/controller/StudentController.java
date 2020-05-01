package pe.isil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pe.isil.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
public class StudentController {


    @GetMapping("/students")
    public String getStudentList(Model model){

        List<Student> students = new ArrayList<>(
                Arrays.asList(
                    new Student("42897534", "Jose", "Ventura", "Arteaga", LocalDate.of(1992, 3, 31)),
                    new Student("32597531", "Franco", "Ventura", "Arteaga", LocalDate.of(1996, 2, 12))
                )
        );

        model.addAttribute("students",students);
        return "student";
    }

}
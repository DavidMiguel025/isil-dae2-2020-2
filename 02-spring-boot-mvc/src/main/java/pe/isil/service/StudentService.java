package pe.isil.service;

import org.springframework.stereotype.Service;
import pe.isil.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student("42897534", "Jose", "Ventura", "Arteaga", LocalDate.of(1992, 3, 31)),
                    new Student("32597531", "Franco", "Ventura", "Arteaga", LocalDate.of(1996, 2, 12))
            )
    );

    public List<Student> getAll(){
        return students;
    }

    public void save(Student student){
        students.add(student);
    }

    public void delete(Student student){
        students.remove(student);
    }

    public void update(Student student){
        Student currentStudent = findById(student.getDocumentNumber());
        if(currentStudent != null){
            int index = students.indexOf(currentStudent);
            student.setDocumentNumber(currentStudent.getDocumentNumber());
            students.set(index, student);
        }
    }

    public Student findById(String documentNumber) {

        Student student = students.stream()
                .filter(s -> s.getDocumentNumber().equalsIgnoreCase(documentNumber))
                .findFirst()
                .orElseGet(null);

        return student;
    }

}

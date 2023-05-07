package com.springboot.listExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.Student;
import service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/list")
    public String listStudents(Model model) {
        model.addAttribute("studentList", studentService.findAll());
        return "grade/listStudents";
    }

    @GetMapping(value = "/{id}")
    public String show(@PathVariable("id") Integer studentId, Model model) {
       
        Student student = studentService.findById(studentId);
        if (student == null) {
			return "redirect:/students/list";
		}
        model.addAttribute("student", student);
        return "grade/detailStudent";
    }

}

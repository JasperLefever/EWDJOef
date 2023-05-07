package com.springboot.securityListStart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.Student;
import service.StudentService;

import java.security.Principal;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //TODO username
    
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

    @ModelAttribute("username")
    public String username(Principal principal) {
        return principal.getName();
    }

}

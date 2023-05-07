package service;

import java.util.List;

import domain.Student;

public interface StudentService {

    public List<Student> findAll();

    public Student findById(Integer id);
}
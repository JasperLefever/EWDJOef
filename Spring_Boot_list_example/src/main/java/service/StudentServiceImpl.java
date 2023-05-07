package service;

import domain.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    private static final List<Student> list = new ArrayList<>();

    static {
        list.add(new Student(1, "firstName1", "lastName1", "name1@com.be"));
        list.add(new Student(2, "firstName2", "lastName2", "name2@com.be"));
        list.add(new Student(3, "firstName3", "lastName3", "name3@com.be"));
        list.add(new Student(4, "firstName4", "lastName4", "name4@com.be"));
        list.add(new Student(5, "firstName5", "lastName5", "name5@com.be"));
        list.add(new Student(6, "firstName6", "lastName6", "name6@com.be"));
        list.add(new Student(7, "firstName7", "lastName7", "name7@com.be"));
        list.add(new Student(8, "firstName8", "lastName8", "name8@com.be"));
    }

    @Override
    public List<Student> findAll() {
        return list;
    }

    @Override
    public Student findById(Integer id) {
        return list.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
    }

}
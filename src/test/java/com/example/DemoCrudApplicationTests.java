package com.example;

import com.example.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class DemoCrudApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private StudentReposistory StudentReposistory;

    @Test
    void saveRecord() {
        Student stu = new Student();
        stu.setName("chandu");
        stu.setAge("58");
        stu.setEmail("chandru@gmail.com");
        StudentReposistory.save(stu);

    }

    @Test
    void deleteRecord() {
        StudentReposistory.deleteById(4L);
    }

    @Test
    void getRecordsByid() {
        Optional<Student> Onemp = StudentReposistory.findById(44l);
        if (Onemp.isPresent()) {
            Student student = Onemp.get();
            System.out.println(student.getId());
            System.out.println(student.getName());
            System.out.println(student.getAge());
        } else {
            System.out.println("no record found");

        }


    }

    @Test
    void getRecords() {
        List<Student> stu = StudentReposistory.findAll();
        for (Student itrEmp : stu) {
            System.out.println(itrEmp.getId());
            System.out.println(itrEmp.getName());
            System.out.println(itrEmp.getAge());
            System.out.println(itrEmp.getEmail());
        }


    }

    @Test
    void countRecords() {
        long count = StudentReposistory.count();
        System.out.println(count);
    }

    @Test
    void findByEmailid2() {
        Optional<Student> byEmailid = StudentReposistory.findByEmail("cgabhishek92@gmail.com");
        if (byEmailid.isPresent()) {
            Student student = byEmailid.get();
            System.out.println(student.getId());
            System.out.println(student.getAge());
            System.out.println(student.getName());


        } else {
            System.out.println("no record found");
        }

    }

    @Test
    void existsByEmail() {
        boolean b = StudentReposistory.existsByEmail("cgabhishek2@gmail.com");
        System.out.println(b);
    }

    @Test
    void findByName2() {
        Optional<Student> stu = StudentReposistory.findByName("abhishek");
        if (stu.isPresent()) {
            Student student = stu.get();
            System.out.println(student.getName());
            System.out.println(student.getAge());
            System.out.println(student.getEmail());
        } else {
            System.out.println("student not found");
        }
    }

    @Test
    void findByName() {
        List<Student> stu = StudentReposistory.findByNameStartingWith("c");
        for (Student stur : stu) {
            System.out.println(stur.getName());
            System.out.println(stur.getAge());
            System.out.println(stur.getEmail());
        }
    }

    @Test
    void findByNameEndsWith() {
        List<Student> stu = StudentReposistory.findByNameEndingWith("l");
        for (Student stur : stu) {
            System.out.println(stur.getName());
            System.out.println(stur.getAge());
            System.out.println(stur.getEmail());
        }
    }

    @Test
    void getStudentDetails() {
        Optional<Student> studentByEmailAndMobile = StudentReposistory.getStudentByEmailAndMobile("cgabhishek92@gmail.com", "26");
        if (studentByEmailAndMobile.isPresent()) {
            Student student = studentByEmailAndMobile.get();
            System.out.println(student.getEmail());
            System.out.println(student.getAge());
            System.out.println(student.getId());
        } else {
            System.out.println("Student not found");
        }
    }
}





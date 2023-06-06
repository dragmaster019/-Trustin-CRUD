package com.example.springMongo.Service;

import com.example.springMongo.Entity.Student;
import com.example.springMongo.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServices   {







    @Autowired
    private StudentRepo repo;
    public void saveorupdate(Student students) {
        repo.save(students);
    }

    public Iterable<Student> listAll() {

        return this.repo.findAll();
    }

    public void deleteStudent(String id) {
        repo.deleteById(id);
    }

    public Student getStudentByID(String studentid) {
        return repo.findById(studentid).get();
    }
}

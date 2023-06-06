package com.example.springMongo.Repo;

import com.example.springMongo.Entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository<Student,String> {
}

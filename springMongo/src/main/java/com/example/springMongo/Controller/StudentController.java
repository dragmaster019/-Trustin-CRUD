package com.example.springMongo.Controller;
import com.example.springMongo.Entity.Student;

import com.example.springMongo.Service.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//import java.util.Locale;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping( "api/v1/student")
public class StudentController  {


//    @Autowired
//    private MessageSource messageSource;

//    @GetMapping("/greeting")
//    public String getGreetingMessage(WebRequest request) {
//        // Retrieve current locale from the request
//        Locale locale = request.getLocale();
//
//        // Fetch the translated greeting message using the MessageSource
//        String greetingMessage = messageSource.getMessage("greeting", null, locale);
//
//        return greetingMessage;





    @Autowired
    private StudentServices studentServices;


    @PostMapping(value= "/save" )
    private String saveStudent(@RequestBody Student students)
    {

        studentServices.saveorupdate(students);
        return students.get_id();
    }
    @GetMapping(value= "/getAll" )


    public Iterable<Student>getStudents()
    {


        return studentServices.listAll();
    }

    @PutMapping (value= "/edit/{id}" )


    private Student update (@RequestBody Student student, @PathVariable(name = "id") String _id)
    {
        student.set_id(_id);
        studentServices.saveorupdate(student);
        return student;
    }
    @DeleteMapping ("/delete/{id}" )


    private void deleteStudent (@PathVariable("id") String _id)
    {
        studentServices.deleteStudent(_id);
    }
    @RequestMapping ("/search/{id}")


    private Student getStudents(@PathVariable(name="id") String studentid)
    {
        return studentServices.getStudentByID(studentid);
    }

}

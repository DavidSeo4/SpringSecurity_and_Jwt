package com.basic.SecurityJwt.SecurityJwt.controllers;

import com.basic.SecurityJwt.SecurityJwt.model.Student;
import com.basic.SecurityJwt.SecurityJwt.respository.StudentsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/students")
public class StudentsController {

    private final StudentsRepository studentsRepository;

    public StudentsController(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @GetMapping("/allmarks")
    public ResponseEntity<List<Student>> readAllMarks(){

        return ResponseEntity.ok(studentsRepository.findAll());
    }

    @GetMapping("/{id}/marks")
    public Student readStudentMarks(@PathVariable Integer id){

        return studentsRepository.findById(id).get();
    }


}

package com.basic.SecurityJwt.SecurityJwt.respository;

import com.basic.SecurityJwt.SecurityJwt.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Student, Integer> {
}

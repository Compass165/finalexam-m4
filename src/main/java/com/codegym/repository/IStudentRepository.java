package com.codegym.repository;

import com.codegym.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
    Iterable<Student> findAllByStudentName(String studentName);

}

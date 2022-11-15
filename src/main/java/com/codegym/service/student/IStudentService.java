package com.codegym.service.student;

import com.codegym.model.Student;
import com.codegym.service.IGeneralService;

public interface IStudentService extends IGeneralService<Student> {
    Iterable<Student> findAllByStudentName(String studentName);
}

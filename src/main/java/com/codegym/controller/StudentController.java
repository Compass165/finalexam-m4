package com.codegym.controller;

import com.codegym.model.ClassRoom;
import com.codegym.model.Student;
import com.codegym.service.classroom.IClassRoomService;
import com.codegym.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private IClassRoomService classRoomService;

    @ModelAttribute("classrooms")
    public Iterable<ClassRoom> categories(){
        return classRoomService.findAll();
    }

    @GetMapping("/list")
    public ModelAndView listStudent() {
        ModelAndView modelAndView = new ModelAndView("/student/list");
        modelAndView.addObject("students",studentService.findAll());
        return modelAndView;
    }
    @GetMapping("/showFormCreate")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("/student/create");
        modelAndView.addObject("student", new Student());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView saveStudent(@ModelAttribute("student") Student student) {
        studentService.save(student);
        ModelAndView modelAndView = new ModelAndView("/student/create");
        modelAndView.addObject("student", new Student());
        modelAndView.addObject("message", "New student created successfully");
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Student> student = studentService.findById(id);
        if (student.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/student/edit");
            modelAndView.addObject("student", student.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error-404");
        }
    }
    @PostMapping("/edit")
    public ModelAndView updateStudent(@ModelAttribute("student") Student student) {
        studentService.save(student);
        ModelAndView modelAndView = new ModelAndView("/student/edit");
        modelAndView.addObject("student", student);
        modelAndView.addObject("message", "Student updated successfully");
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Student> student = studentService.findById(id);
        if (student.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/student/delete");
            modelAndView.addObject("student", student.get());
            return modelAndView;

        } else {
            return new ModelAndView("/error-404");
        }
    }
    @PostMapping("/delete")
    public String deleteStudent(@ModelAttribute("city") Student student) {
        studentService.remove(student.getId());
        return "redirect:Student";
    }

    @PostMapping("/search/{studentName}")
    public ModelAndView showEditForm(@PathVariable String studentName) {
        Iterable<Student> students = studentService.findAllByStudentName(studentName);
        if (students != null ) {
            ModelAndView modelAndView = new ModelAndView("/student/list");
            modelAndView.addObject("students",students);
            return modelAndView;
        } else {
            return new ModelAndView("/error-404");
        }
    }
}

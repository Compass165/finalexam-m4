package com.codegym.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Please enter value")
    @Column(columnDefinition = "nvarchar(100)")
    private String studentName;

    private String dateOfBirth;

    @Column(columnDefinition = "nvarchar(100)")
    private String address;

    @Pattern(regexp = "((09|03|07|08|05)+([0-9]{8})\\b)", message = "Please enter the correct phone number format")
    private String phoneNumber;
    @Email(message = "Please  enter correct email value")
    private String email;

   @ManyToOne
    private ClassRoom classRoom;



}

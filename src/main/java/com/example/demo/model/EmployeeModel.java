package com.example.demo.model;

import com.example.demo.IdGenerator;
import com.example.demo.model.dto.ResponseDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class EmployeeModel {
    @Id
    @GeneratedValue(generator = "uuid-id")
  @GenericGenerator(name="uuid-id",
          strategy = "com.example.demo.IdGenerator")
   private String id;
    @NotBlank(message ="")
    private String first_name;
    @NotBlank(message = "Last Name can not be blank")
    private String last_name;
    @NotBlank(message = "email can not be blank")
    @Email(message = "Valid email required 'example@mail.com'")
    private String email;
    @NotBlank(message = "Password can not be blank")
    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}",message = "Password must contain one uppercase character and one special character")
    private String password;
    private String imgUrl;
    private Long salary;
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private Date  joinDate;
    private boolean status = false;
   @ManyToOne
   private DepartmentModel dept ;
}

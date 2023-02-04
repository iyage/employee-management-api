package com.example.demo.model.dto;

import com.example.demo.model.DepartmentModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;


@Getter
@Setter
public class EmployeeModelDto {
    @NotBlank(message ="First Name can not be blank")
    private String first_name;
    @NotBlank(message = "Last Name can not be blank")
    private String last_name;
    @NotBlank(message = "email can not be blank")
    @Email(message = "Valid email required 'example@mail.com'")
    private String email;
    @NotBlank(message = "Password can not be blank")
    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}",message = "Password must contain one uppercase character and one special character")
    private String password;
    @NotNull(message = "salary can not be null")
    private Long salary;
    @NotNull(message = "Date can not be null")
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private Date  joinDate;
}

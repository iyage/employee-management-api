package com.example.demo.model.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResponseDto {
    private String message;
    Object data = null;
    private Date timeStamp;
}

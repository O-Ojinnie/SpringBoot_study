package com.kosa.restservice.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private Integer id;

    @Size(min = 2, message = "Name을 2글자 이상 입력하세요")
    private String name;

    @Past
    private Date joinDate;
}

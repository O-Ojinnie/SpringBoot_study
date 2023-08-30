package com.kosa.restservice2.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private Integer id;
    private String name;
    private Date joinDate;
    private String password;
    private String ssn;
    private List<Post> posts;
}

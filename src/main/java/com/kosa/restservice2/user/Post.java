package com.kosa.restservice2.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post {
    private Integer id;
    private String description;
    private Integer user_id;
}

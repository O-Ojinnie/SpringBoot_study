package com.test.bestrestaurant.mrs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "review_generator")
    @TableGenerator(name = "review_generator", table = "id_generator", pkColumnName = "id_key", valueColumnName = "id_value", allocationSize = 1)
    private Integer id;

    private String content;
    private Double score;
    private Date created_at;
    private int restaurantId;



}

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
@Table(name="restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "restaurant_generator")
    @TableGenerator(name = "restaurant_generator", table = "id_generator", pkColumnName = "id_key", valueColumnName = "id_value", allocationSize = 1)
    private Integer id;

    private String name;
    private String address;
    private Date created_at;
    private Date updated_at;

    @OneToMany(mappedBy = "restaurantId")
    private List<Menu> menus;

    @OneToMany(mappedBy = "restaurantId")
    private List<Review> reviews;



}

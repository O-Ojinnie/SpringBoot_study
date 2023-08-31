package com.test.bestrestaurant.mrs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="restaurant_menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "menu_generator")
    @TableGenerator(name = "menu_generator", table = "id_generator", pkColumnName = "id_key", valueColumnName = "id_value", allocationSize = 1)
    private Integer id;
    private String name;
    private Integer price;
    private Date created_at;
    private Date updated_at;
    private int restaurantId;


}

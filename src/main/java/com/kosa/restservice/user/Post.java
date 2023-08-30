package com.kosa.restservice.user;


//User : Post ==> 1 (Main, Parent): N(Sub, Child) : 1명의 User가 N개의 포스트를 작성할 수 있다.
//FK 작성시 작성하고 있는 클래스 기준(Post 기준이므로 User와
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue
    private Integer id;

    private String description;

    //FetchType.Lazy Post에서 필요로 할 때 Data를 가져오는 방식
    @ManyToOne(fetch = FetchType.LAZY)
    //관계를 맺는 용도로만 사용 (User에서 Post를 불러오기 때문, Post만 보는 경우는 없다)
    @JsonIgnore
    private User user;


}

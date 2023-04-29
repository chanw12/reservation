package shop.shopping.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;

@Entity
@Setter
@Getter
public class Hello {

    @Id
    @GeneratedValue(generator = "hello_generator")
    @GenericGenerator(name = "hello_generator",parameters = @org.hibernate.annotations.Parameter(name ="prefix",value="OW"),strategy =  "shop.shopping.domain.Generator.CustomGenerator")
    private String id;

    @Column
    private String name;
}

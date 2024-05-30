package web.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    @Size(min = 2, max = 20, message = "Не должно быть меньше 2 или больше 20 символов")
    private String name;
    @Size(max = 8, message = "Символы 4-8")
    private String password;
}

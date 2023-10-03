package stslekiti.receipt.entity;

import jakarta.persistence.*;
import lombok.*;
import stslekiti.receipt.enums.UserAuthorities;

import java.util.Set;


@Builder
@Table(name = "user_table")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @EqualsAndHashCode.Include()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="user_name")
    private String userName;

    @Column(name="email")
    private String email;

    @Column(name="phone")
    private String phone;

    @Column(name="password")
    private String password;

    @Column(name="role")
    private UserAuthorities role;

    @Column(name="active")
    private Boolean active;

}

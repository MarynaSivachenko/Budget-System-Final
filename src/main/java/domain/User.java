package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "users" )
public class User {
    @Id
    @GeneratedValue
    private int id;
    @Column(unique = true, nullable = false)
    private String login;
    @Column( nullable = false)
    private String password;
    @Column(unique = true, nullable = false)
    private String email;
   @Enumerated(EnumType.STRING)
    private UserState status;
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    public boolean loginIn(String login, String password){
        return this.login.equals(login) && this.password.equals(password);
    }

}

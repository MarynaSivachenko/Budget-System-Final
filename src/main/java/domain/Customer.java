package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "customers" )

public class Customer {
    @Id
    @GeneratedValue
    private int id;
    @Column(unique = true, nullable = false)
    private String phone;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
}

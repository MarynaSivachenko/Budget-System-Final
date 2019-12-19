package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column
    private LocalDate created = LocalDate.now();
    @Column
    private int userId;

}

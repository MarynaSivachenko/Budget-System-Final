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
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private int accId;
    @Column(nullable = false)
    private Double amount;
    @Column
    private LocalDate created = LocalDate.now();
    @Column
    private int userId;
    @Enumerated(EnumType.STRING)
    @Column
    private TransactionType type;

    @Column
    private int categoryId;
}

package domain;

import lombok.AllArgsConstructor;
import lombok.Data;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Random;

@Data
@AllArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String number;
    @Column(nullable = false)
    private double balance;
    @Column
    private LocalDate created = LocalDate.now();
    @Column
    private int userId;

    public Account() {
        number = generateAcNumber();
    }

    private String generateAcNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 16; i++) {

            sb.append(random.nextInt(10));
            if (i != 15 && (i + 1) % 4 == 0) {
                sb.append("-");
            }
        }
        return sb.toString();
    }

    public void putMoney(double summ){
        this.balance+=summ;
    }
}

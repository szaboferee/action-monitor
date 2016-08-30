package net.szaboferee.sample.betting.domain;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "BET")
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private BigDecimal amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}

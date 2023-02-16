package pl.coderslab.encje;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name ="transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String source;
    String destination;
    Timestamp timestamp;
    int amount;

    public Transaction(String from, String to, Timestamp timestamp, int amount) {
        super();
        this.source = from;
        this.destination = to;
        this.timestamp = timestamp;
        this.amount = amount;
    }

    public Transaction() {

    }

    @Override
    public String toString() {
        return "Transaction [from=" + source + ", to=" + destination + ", timestamp=" + timestamp + ", amount=" + amount + "]";
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFrom() {
        return source;
    }
    public void setFrom(String from) {
        this.source = from;
    }
    public String getTo() {
        return destination;
    }
    public void setTo(String destination) {
        this.destination = destination;
    }
    public Timestamp getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

}

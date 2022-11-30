package nhom7.business;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "invoices")
public class Invoice implements Serializable {
    @ManyToOne
    private Customer customer;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long invoiceID;

    @Temporal(TemporalType.DATE)
    private Date invoiceDate;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Game> games;

    public Invoice() {
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public long getTotalPrice(){
        long totalPrice = 0;
        for (Game game : games){
            totalPrice += game.getPrice();
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "customer=" + customer +
                ", invoiceID=" + invoiceID +
                ", invoiceDate=" + invoiceDate +
                ", games=" + games +
                '}';
    }
}

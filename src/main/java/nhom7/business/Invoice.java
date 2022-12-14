package nhom7.business;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "invoices")
public class Invoice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long invoiceID;

    @Temporal(TemporalType.DATE)
    private Date invoiceDate;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Game> games;

    private boolean isProcessed;


    public Invoice(Date invoiceDate, List<Game> games, boolean isProcessed) {
        this.invoiceDate = invoiceDate;
        this.games = games;
        this.isProcessed = isProcessed;
    }

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

    public long getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(long invoiceID) {
        this.invoiceID = invoiceID;
    }

    public boolean isProcessed() {
        return isProcessed;
    }

    public void setProcessed(boolean processed) {
        isProcessed = processed;
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
                ", invoiceID=" + invoiceID +
                ", invoiceDate=" + invoiceDate +
                ", games=" + games +
                '}';
    }
}

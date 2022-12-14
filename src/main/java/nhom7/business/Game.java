package nhom7.business;

import nhom7.DAO.DBUtil;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "games")
public class Game implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long gameID;
    private String gameName;
    private String image;
    private long price;
    private String description;
    private String gameDeveloper;
    private String gamePublisher;
    private String demo1;
    private String demo2;
    private String demo3;
    private String demo4;

    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @ManyToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Category.class)
    private List<Category> categories;

    public Game() {
    }

    public Game(String gameName, String image, long price, String description, String gameDeveloper,
                String gamePublisher, String demo1, String demo2, String demo3, String demo4, Date releaseDate) {
        this.gameName = gameName;
        this.image = image;
        this.price = price;
        this.description = description;
        this.gameDeveloper = gameDeveloper;
        this.gamePublisher = gamePublisher;
        this.demo1 = demo1;
        this.demo2 = demo2;
        this.demo3 = demo3;
        this.demo4 = demo4;
        this.releaseDate = releaseDate;
    }

    public long getGameID() {
        return gameID;
    }

    public void setGameID(long gameID) {
        this.gameID = gameID;
    }

    public void setDemo1(String demo1) {
        this.demo1 = demo1;
    }

    public void setDemo2(String demo2) {
        this.demo2 = demo2;
    }

    public void setDemo3(String demo3) {
        this.demo3 = demo3;
    }

    public void setDemo4(String demo4) {
        this.demo4 = demo4;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getGameDeveloper() {
        return gameDeveloper;
    }

    public void setGameDeveloper(String gameDeveloper) {
        this.gameDeveloper = gameDeveloper;
    }

    public String getGamePublisher() {
        return gamePublisher;
    }

    public void setGamePublisher(String gamePublisher) {
        this.gamePublisher = gamePublisher;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDemo1() {
        return demo1;
    }

    public String getDemo2() {
        return demo2;
    }

    public String getDemo3() {
        return demo3;
    }

    public String getDemo4() {
        return demo4;
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameID=" + gameID +
                ", gameName='" + gameName + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", gameDeveloper='" + gameDeveloper + '\'' +
                ", gamePublisher='" + gamePublisher + '\'' +
                ", demo1='" + demo1 + '\'' +
                ", demo2='" + demo2 + '\'' +
                ", demo3='" + demo3 + '\'' +
                ", demo4='" + demo4 + '\'' +
                ", releaseDate=" + releaseDate +
                ", categories=" + categories +
                '}';
    }
}

package nhom7.DAO;

import nhom7.business.Category;
import nhom7.business.Customer;
import nhom7.business.Game;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class GameDB {
    public static void delete(Game game){
        EntityManager em = DBUtil.getEmf().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        trans.begin();
        try {
            game.setCategories(null);
            em.remove(em.merge(game));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static Game selectGame(String gameName) {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        String qString = "SELECT g FROM Game g " +
                "WHERE g.gameName = :gameName";
        TypedQuery<Game> q = em.createQuery(qString, Game.class);
        q.setParameter("gameName", gameName);
        try {
            Game result = q.setMaxResults(1).getSingleResult();
            return result;
        } catch (NoResultException ex) {
            return null;
        } finally {
            em.close();
        }
    }

    public static void insert(Game game){
        EntityManager em = DBUtil.getEmf().createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();

        try {
            em.persist(game);
            et.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
    }

    public static Game selectGame(long gameID) {
        EntityManager em = DBUtil.getEmf().createEntityManager();

        return em.find(Game.class, gameID);
    }

    public List<Game> selectGames(String searchContent){
        List<Game> games = selectGames();

        List<Game> results = new ArrayList<Game>();

        for (Game game:
             games) {
            if(game.getGameName().toLowerCase().indexOf(searchContent) != -1)
                results.add(game);
        }

        return results;
    }

    public List<Game> selectGamesByCategory(String categoryName) {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        String qString = "SELECT game from Game game join game.categories as t " +
                "WHERE t.categoryName = :categoryName";
        TypedQuery<Game> q = em.createQuery(qString, Game.class);
        q.setParameter("categoryName", categoryName);
        List<Game> results = null;
        try {
            results = q.getResultList();
        } catch (NoResultException ex) {
            return null;
        } finally {
            em.close();
        }

        return results;
    }

    public List<Game> selectGames() {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        String qString = "SELECT game from Game game";
        TypedQuery<Game> q = em.createQuery(qString, Game.class);
        List<Game> results = null;
        try {
            results = q.getResultList();
        } catch (NoResultException ex) {
            return null;
        } finally {
            em.close();
        }

        return results;
    }

    /*public static void main(String[] args) {
        GameDB dao = new GameDB();
        EntityManager em = DBUtil.getEmf().createEntityManager();
        EntityTransaction et = em.getTransaction();

        Category category1 = new Category("Action");
        Category category2 = new Category("Shooter");
        Category category3 = new Category("Horror");
        Category category4 = new Category("RPG");
        Category category5 = new Category("Survival");
        Category category6 = new Category("Racing");
        Category category7 = new Category("Simulation");
        Category category8 = new Category("Puzzle");
        Category category9 = new Category("Adventure");
        Category category10 = new Category("Indie");
        Category category11 = new Category("Fighting");
        Category category12 = new Category("Steath");

        List<Category> categame1 = new ArrayList<Category>();
        categame1.add(category1);
        categame1.add(category2);
        Game game1 = new Game("Grand Theft Auto V",
                "https://media.discordapp.net/attachments/893373606376128538/1046807497245200384/gtav.png?width=468&height=468",
                608000,
                "Game hành động vui vc",
                "Rockstar North",
                "Rockstar Games",
                "https://media.discordapp.net/attachments/893373606376128538/1047109094412144660/unknown.png?width=831&height=467",
                "https://media.discordapp.net/attachments/893373606376128538/1047109126435643423/unknown.png?width=831&height=467",
                "https://media.discordapp.net/attachments/893373606376128538/1047109187123036180/unknown.png?width=935&height=468",
                "https://media.discordapp.net/attachments/893373606376128538/1047109228822802452/unknown.png?width=831&height=467",
                new Date(115, 4, 14));
        game1.setCategories(categame1);

        List<Category> categame2 = new ArrayList<Category>();
        categame2.add(category1);
        categame2.add(category2);
        Game game2 = new Game("Counter-Strike: Global Offensive",
                "https://media.discordapp.net/attachments/893373606376128538/1046807496225988679/csgo.png",
                340000,
                "Game bằng chíu, bằng chíu",
                "Valve, Hidden Path Entertainment",
                "Valve",
                "https://media.discordapp.net/attachments/893373606376128538/1047109094412144660/unknown.png?width=831&height=467",
                "https://media.discordapp.net/attachments/893373606376128538/1047109126435643423/unknown.png?width=831&height=467",
                "https://media.discordapp.net/attachments/893373606376128538/1047109187123036180/unknown.png?width=935&height=468",
                "https://media.discordapp.net/attachments/893373606376128538/1047109228822802452/unknown.png?width=831&height=467",
                new Date(2012, 8, 22));
        game2.setCategories(categame2);

        List<Category> categame3 = new ArrayList<Category>();
        categame3.add(category1);
        categame3.add(category4);
        Game game3 = new Game("ELDEN RING",
                "https://media.discordapp.net/attachments/893373606376128538/1046807496897077339/elden_ring.png?width=468&height=468",
                800000,
                "Game đi cảnh combat chém quá chời chém",
                "FromSoftware Inc",
                "FromSoftware Inc, Bandai Namco Entertainment",
                "https://media.discordapp.net/attachments/893373606376128538/1047109094412144660/unknown.png?width=831&height=467",
                "https://media.discordapp.net/attachments/893373606376128538/1047109126435643423/unknown.png?width=831&height=467",
                "https://media.discordapp.net/attachments/893373606376128538/1047109187123036180/unknown.png?width=935&height=468",
                "https://media.discordapp.net/attachments/893373606376128538/1047109228822802452/unknown.png?width=831&height=467",
                new Date(2022, 2, 25));
        game3.setCategories(categame3);

        List<Category> categame4 = new ArrayList<Category>();
        categame4.add(category5);
        Game game4 = new Game("Valheim",
                "https://cdn.discordapp.com/attachments/893373606376128538/1046807498625134642/valheim.png",
                188000,
                "Game sinh tồn thời kì trung cổ",
                "Iron Gate AB",
                "Coffee Stain Publishing",
                "https://media.discordapp.net/attachments/893373606376128538/1047109094412144660/unknown.png?width=831&height=467",
                "https://media.discordapp.net/attachments/893373606376128538/1047109126435643423/unknown.png?width=831&height=467",
                "https://media.discordapp.net/attachments/893373606376128538/1047109187123036180/unknown.png?width=935&height=468",
                "https://media.discordapp.net/attachments/893373606376128538/1047109228822802452/unknown.png?width=831&height=467",
                new Date(2021, 2, 2));
        game4.setCategories(categame4);

        List<Category> categame5 = new ArrayList<Category>();
        categame5.add(category6);
        categame5.add(category7);
        Game game5 = new Game("WRC Generations - The FIA WRC Official Game",
                "https://cdn.discordapp.com/attachments/893373606376128538/1046807495504568481/wrc.png",
                420000,
                "Game đua xe siêu căng thẳng",
                "KT Racing",
                "Nacon",
                "https://media.discordapp.net/attachments/893373606376128538/1047109094412144660/unknown.png?width=831&height=467",
                "https://media.discordapp.net/attachments/893373606376128538/1047109126435643423/unknown.png?width=831&height=467",
                "https://media.discordapp.net/attachments/893373606376128538/1047109187123036180/unknown.png?width=935&height=468",
                "https://media.discordapp.net/attachments/893373606376128538/1047109228822802452/unknown.png?width=831&height=467",
                new Date(2012, 3, 11));
        game5.setCategories(categame5);

        List<Category> categame6 = new ArrayList<Category>();
        categame6.add(category3);
        categame6.add(category8);
        categame6.add(category9);
        Game game6 = new Game("Scorn",
                "https://cdn.discordapp.com/attachments/893373606376128538/1046807498000179270/scorn.png",
                373000,
                "Game kinh dị giải đố về sự tiến hóa",
                "Ebb Software",
                "Kepler Interactive",
                "https://media.discordapp.net/attachments/893373606376128538/1047109094412144660/unknown.png?width=831&height=467",
                "https://media.discordapp.net/attachments/893373606376128538/1047109126435643423/unknown.png?width=831&height=467",
                "https://media.discordapp.net/attachments/893373606376128538/1047109187123036180/unknown.png?width=935&height=468",
                "https://media.discordapp.net/attachments/893373606376128538/1047109228822802452/unknown.png?width=831&height=467",
                new Date(2022, 10, 14));
        game6.setCategories(categame6);

        List<Category> categame7 = new ArrayList<Category>();
        categame7.add(category3);
        categame7.add(category9);
        Game game7 = new Game("The Medium",
                "https://cdn.discordapp.com/attachments/893373606376128538/1046807498000179270/scorn.png",
                693000,
                "Game phiêu lưu kinh dị",
                "Bloober Team",
                "Bloober Team SA",
                "https://media.discordapp.net/attachments/893373606376128538/1047109094412144660/unknown.png?width=831&height=467",
                "https://media.discordapp.net/attachments/893373606376128538/1047109126435643423/unknown.png?width=831&height=467",
                "https://media.discordapp.net/attachments/893373606376128538/1047109187123036180/unknown.png?width=935&height=468",
                "https://media.discordapp.net/attachments/893373606376128538/1047109228822802452/unknown.png?width=831&height=467",
                new Date(2021, 1, 29));
        game7.setCategories(categame7);

        et.begin();

        try {
            Customer customer = new Customer("admin",
                    "14082002Tc",
                    "Bui",
                    "Huy",
                    "bhtcag@gmail.com",
                    "nobody");
            customer.setAdmin(true);

            em.persist(customer);
            em.persist(category1);
            em.persist(category2);
            em.persist(category3);
            em.persist(category4);
            em.persist(category5);
            em.persist(category6);
            em.persist(category7);
            em.persist(category8);
            em.persist(category9);
            em.persist(category10);
            em.persist(category11);

            em.persist(game1);
            em.persist(game2);
            em.persist(game3);
            em.persist(game4);
            em.persist(game5);
            em.persist(game6);
            em.persist(game7);



            et.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
    }*/
}

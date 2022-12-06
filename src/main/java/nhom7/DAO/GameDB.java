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

    public static void main(String[] args) {
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
                "https://media.discordapp.net/attachments/893373606376128538/1049448393845518336/GTA-1.jpg",
                "https://media.discordapp.net/attachments/893373606376128538/1049448393124098110/GTA-2.jpg",
                "https://media.discordapp.net/attachments/893373606376128538/1049448393367359518/GTA-3.jpg?width=1051&height=591",
                "https://media.discordapp.net/attachments/893373606376128538/1049448393623208077/GTA-4.jpg",
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
                "https://media.discordapp.net/attachments/893373606376128538/1049448470441906317/CSGO-1.jpg",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049448470651600957/CSGO-2.jpg",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049448469754019880/CSGO-3.jpg",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049448470026653766/CSGO-4.jpg",
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
                "https://cdn.discordapp.com/attachments/893373606376128538/1049448524351287326/ER-1.jpg",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049448523889918074/ER-3.jpg",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049448524166725682/ER-4.jpg",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049452677148442684/ER-4.jpg",
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
                "https://cdn.discordapp.com/attachments/893373606376128538/1049450076818374746/VALHEIM-1.jpg",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049450076143091833/VALHEIM-2.jpg",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049450076398948403/VALHEIM-3.jpg",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049450076612874240/VALHEIM-4.jpg",
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
                "https://cdn.discordapp.com/attachments/893373606376128538/1049449499304656926/WRC-1.jpg",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049449960795557888/WRC-4.jpg",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049449960594214923/WRC-3.jpg",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049449961017835570/WRC-2.jpg",
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
                "https://cdn.discordapp.com/attachments/893373606376128538/1049448634053308538/SCORN-1.jpg",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049449396175126589/SCORN-2.jpg",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049449396389032007/SCORN-3.jpg",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049449395881517128/SCORN-4.jpg",
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
                "https://cdn.discordapp.com/attachments/893373606376128538/1049450601689403463/THEMEDIUM-1.jpg",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049450601978806312/THEMEDIUM-2.jpg",
                "https://media.discordapp.net/attachments/893373606376128538/1049450602184310854/THEMEDIUM-3.jpg",
                "https://media.discordapp.net/attachments/893373606376128538/1049450602389852160/THEMEDIUM-4.jpg",
                new Date(2021, 1, 29));
        game7.setCategories(categame7);

        List<Category> categame8 = new ArrayList<Category>();
        categame8.add(category3);
        categame8.add(category5);
        categame8.add(category10);
        Game game8 = new Game("Darkwood",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049457260046332004/darkwood.png",
                130000,
                "Game phiêu lưu kinh dị",
                "Acid Wizard Studio",
                "Acid Wizard Studio",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049458103504085042/Darkwood-title.jpg",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049458103726374992/Darkwood-1.jpg",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049458103080452157/Darkwood-2.jpg",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049458103273394196/Darkwood-3.jpg",
                new Date(2022, 10, 13));
        game8.setCategories(categame8);

        List<Category> categame9 = new ArrayList<Category>();
        categame9.add(category7);
        Game game9 = new Game("Overcooked! 2",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049459554863292416/overcooked2.png",
                233000,
                "Game nấu ăn chơi cùng bạn bè",
                "Ghost Town Games, Team17 Digital Ltd",
                "Team17 Digital Ltd",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049460058527891546/overcooked-title.jpg",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049460057932312677/overcooked-1.jpg",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049460058259476500/overcooked-2.jpg",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049460057684836442/overcooked-3.jpg",
                new Date(2021, 06, 17));
        game9.setCategories(categame9);

        List<Category> categame10 = new ArrayList<Category>();
        categame10.add(category1);
        Game game10 = new Game("Alien: Isolation",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049460785891512440/alien_isolation.png",
                700000,
                "Game chiến đấu với người ngoài hành tinh",
                "Creative Assembly",
                "SEGA",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049461423278915644/alienisolution-title.jpg",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049461422620409856/alienisolution-1.jpg",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049461422834327572/alienisolution-2.jpg",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049461423044055180/alienisolution-3.jpg",
                new Date(2020, 12, 21));
        game10.setCategories(categame10);

        List<Category> categame11 = new ArrayList<Category>();
        categame11.add(category1);
        categame11.add(category11);
        Game game11 = new Game("Batman™ Arkham Knight",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049463450964860968/arkham_knight.png",
                185000,
                "Game nhập vai batman bảo vệ thành phố",
                "Rocksteady Studios",
                "Warner Bros",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049463907523248160/batman-title.jpg",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049463907737145414/batman-1.jpg",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049463907074449408/batman-2.jpg",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049463907300937838/batman-3.jpg",
                new Date(2015, 06, 23));
        game11.setCategories(categame11);

        List<Category> categame12 = new ArrayList<Category>();
        categame12.add(category1);
        categame12.add(category9);
        Game game12 = new Game("Ori and the Will of the Wisps",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049467592034758706/ddw9hr8-c34f0957-0d0f-456b-8237-663fdce10822.png",
                250000,
                "Game nhập vai phiêu lưu đồ họa đẹp mắt",
                "Moon Studios GmbH",
                "Xbox Game Studios",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049468298967924747/ori-title.jpg",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049468299190214706/ori-1.jpg",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049468299416715284/ori-2.jpg",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049468298410074244/ori-3.jpg",
                new Date(2020, 03, 11));
        game12.setCategories(categame12);

        List<Category> categame13 = new ArrayList<Category>();
        categame13.add(category1);
        categame13.add(category4);
        categame13.add(category9);
        Game game13 = new Game("Horizon Zero Dawn™ Complete Edition",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049470341715603566/de30ara-e3fe2d1c-0ca9-48e8-9c99-3f403b60c42b.png",
                1139000,
                "Game nhập vai săn khủng long thế giới mở",
                "Guerrilla",
                "PlayStation PC LLC",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049470800878637096/horizon-title.jpg",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049470800199159929/horizon-1.jpg",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049470800425656340/horizon-2.jpg",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049470800673132664/horizon-3.jpg",
                new Date(2020, 8, 07));
        game13.setCategories(categame13);

        List<Category> categame14 = new ArrayList<Category>();
        categame14.add(category1);
        categame14.add(category4);
        categame14.add(category9);
        Game game14 = new Game("Goat Simulator: Original Soundtrack",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049488207257026631/da1ugls-38c37224-ca94-4b7b-94f1-eb3cf2dac9f4.png",
                85000,
                "Game hóa thân thành dê và tung hoành khắp mọi nơi",
                "Coffee Stain Studios",
                "Coffee Stain Publishing",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049490462442012742/goat-title.jpg",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049490462999838772/goat-1.jpg",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049490463356358697/goat-2.jpg",
                "https://cdn.discordapp.com/attachments/893373606376128538/1049490462152593458/goat-3.jpg",
                new Date(2014, 11, 27));
        game14.setCategories(categame14);
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
            em.persist(game8);
            em.persist(game9);
            em.persist(game10);
            em.persist(game11);
            em.persist(game12);
            em.persist(game13);
            em.persist(game14);

            et.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
    }
}

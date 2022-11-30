package nhom7.DAO;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("workingDB");

    public static EntityManagerFactory getEmf() {
        return emf;
    }
}

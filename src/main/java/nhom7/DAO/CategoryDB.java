package nhom7.DAO;

import nhom7.business.Category;
import nhom7.business.Customer;
import nhom7.business.Game;

import javax.persistence.*;
import java.util.List;

public class CategoryDB {
    public List<Category> selectCategories(){
        EntityManager em = DBUtil.getEmf().createEntityManager();
        String qString = "SELECT category from Category category";
        TypedQuery<Category> q = em.createQuery(qString, Category.class);
        List<Category> results = null;
        try {
            results = q.getResultList();
        } catch (NoResultException ex) {
            return null;
        } finally {
            em.close();
        }

        return results;
    }

    public static Category selectCategories(String categoryName){
        EntityManager em = DBUtil.getEmf().createEntityManager();
        String qString = "SELECT c FROM Category c " +
                "WHERE c.categoryName = :categoryName";
        TypedQuery<Category> q = em.createQuery(qString, Category.class);
        q.setParameter("categoryName", categoryName);
        try {
            Category result = q.setMaxResults(1).getSingleResult();
            return result;
        } catch (NoResultException ex) {
            return null;
        } finally {
            em.close();
        }
    }
}

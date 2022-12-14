package nhom7.DAO;

import nhom7.business.Category;
import nhom7.business.Customer;
import nhom7.business.Game;
import nhom7.business.Invoice;

import javax.persistence.*;
import java.util.List;

public class CategoryDB {
    public static void insert(Category category) {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(category);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
    }
    public static void update(Category category) {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(category);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(Category category){
        EntityManager em = DBUtil.getEmf().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        trans.begin();
        try {
            category.setGames(null);
            em.remove(em.merge(category));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
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

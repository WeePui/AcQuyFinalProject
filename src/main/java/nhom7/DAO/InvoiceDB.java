package nhom7.DAO;

import nhom7.business.Category;
import nhom7.business.Customer;
import nhom7.business.Game;
import nhom7.business.Invoice;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InvoiceDB {
    public static void insert(Invoice invoice) {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(invoice);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
    }

    public static void delete(Invoice invoice){
        EntityManager em = DBUtil.getEmf().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        trans.begin();
        try {
            invoice.setGames(null);
            em.remove(em.merge(invoice));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void update(Invoice invoice) {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(invoice);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public List<Invoice> selectInvoices() {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        String qString = "SELECT invoice from Invoice invoice";
        TypedQuery<Invoice> q = em.createQuery(qString, Invoice.class);
        List<Invoice> results = null;
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
        CategoryDB categoryDB = new CategoryDB();
        List<Category> categories = categoryDB.selectCategories();

        for (Category category:
             categories) {
            System.out.println(category.toString());
        }
    }
}

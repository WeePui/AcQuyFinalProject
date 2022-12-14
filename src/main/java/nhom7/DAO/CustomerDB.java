package nhom7.DAO;

import nhom7.business.Customer;
import nhom7.business.Invoice;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class CustomerDB {
    public static void insert(Customer customer){
        EntityManager em = DBUtil.getEmf().createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();

        try {
            em.persist(customer);
            et.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
    }

    public static void delete(Customer customer){
        EntityManager em = DBUtil.getEmf().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        trans.begin();
        try {
            em.remove(em.merge(customer));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public List<Customer> selectCustomers() {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        String qString = "SELECT customer from Customer customer";
        TypedQuery<Customer> q = em.createQuery(qString, Customer.class);
        List<Customer> results = null;
        try {
            results = q.getResultList();
        } catch (NoResultException ex) {
            return null;
        } finally {
            em.close();
        }

        return results;
    }

    public static void update(Customer customer){
        EntityManager em = DBUtil.getEmf().createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();

        try {
            em.merge(customer);
            et.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
    }

    public static Customer login(String userName, String password){
        EntityManager em = DBUtil.getEmf().createEntityManager();
        String qString = "SELECT cust FROM Customer cust " +
                "WHERE cust.userName = :userName and cust.password = :password";
        TypedQuery<Customer> q = em.createQuery(qString, Customer.class);
        q.setParameter("userName", userName);
        q.setParameter("password", password);
        Customer result = null;
        try {
            result = q.setMaxResults(1).getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } finally {
            em.close();
        }

        return result;
    }

    public static Customer selectCustomerByEmail(String email) {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        String qString = "SELECT cust FROM Customer cust " +
                "WHERE cust.email = :email";
        TypedQuery<Customer> q = em.createQuery(qString, Customer.class);
        q.setParameter("email", email);
        Customer result = null;
        try {
            result = q.setMaxResults(1).getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } finally {
            em.close();
        }

        return result;
    }

    public static Customer selectCustomerByUsername(String userName) {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        String qString = "SELECT cust FROM Customer cust " +
                "WHERE cust.userName = :userName";
        TypedQuery<Customer> q = em.createQuery(qString, Customer.class);
        q.setParameter("userName", userName);
        Customer result = null;
        try {
            result = q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } finally {
            em.close();
        }

        return result;
    }

    public static Customer selectCustomerByPhoneNumber(String phoneNumber) {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        String qString = "SELECT cust FROM Customer cust " +
                "WHERE cust.phoneNumber = :phoneNumber";
        TypedQuery<Customer> q = em.createQuery(qString, Customer.class);
        q.setParameter("phoneNumber", phoneNumber);
        Customer result = null;
        try {
            result = q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } finally {
            em.close();
        }

        return result;
    }

    public static boolean emailExists(String email) {
        Customer cust = selectCustomerByEmail(email);
        return (cust != null);
    }

    public static boolean userNameExists(String userName) {
        Customer cust = selectCustomerByUsername(userName);
        return (cust != null);
    }

    public static boolean phoneNumberExists(String phoneNumber) {
        Customer cust = selectCustomerByPhoneNumber(phoneNumber);
        return (cust != null);
    }
}

package nhom7.DAO;

import nhom7.business.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

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

    public static Customer selectCustomerBySteamFriendCode(String steamFriendCode) {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        String qString = "SELECT cust FROM Customer cust " +
                "WHERE cust.steamFriendCode = :steamFriendCode";
        TypedQuery<Customer> q = em.createQuery(qString, Customer.class);
        q.setParameter("steamFriendCode", steamFriendCode);
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

    public static boolean steamFriendCodeExists(String steamFriendCode) {
        Customer cust = selectCustomerBySteamFriendCode(steamFriendCode);
        return (cust != null);
    }
}

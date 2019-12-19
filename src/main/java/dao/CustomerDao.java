package dao;

import domain.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerDao implements GenericDao<Customer, Integer> {

    private Session currentSession;

    private Transaction currentTransaction;

    private void openSession() {
        try {
            currentSession = HibernateUtils.openConnection();
            currentTransaction = currentSession.beginTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void closeSession() {
        currentTransaction.commit();
        currentSession.close();
    }

    @Override
    public void create(Customer object) {
        openSession();
        currentSession.save(object);
        closeSession();
    }

    @Override
    public Customer read(Integer key) {
        openSession();
        Customer customer = (Customer) currentSession.get(Customer.class, key);
        closeSession();
        return customer;
    }

    @Override
    public void update(Customer object) {
        openSession();
        currentSession.update(object);
        closeSession();
    }

    @Override
    public void delete(Customer object) {
        openSession();
        currentSession.remove(object);
        closeSession();
    }

    @Override
    public List<Customer> readAll() {
        openSession();
        List<Customer> customers = (List<Customer>) currentSession.createQuery("from Customer ").list();
        closeSession();
        return customers;
    }
}

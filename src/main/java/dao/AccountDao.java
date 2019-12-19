package dao;

import domain.Account;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AccountDao implements GenericDao<Account,Integer> {
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
    public void create(Account object) {
        openSession();
        currentSession.save(object);
        closeSession();
    }

    @Override
    public Account read(Integer key) {
        openSession();
        Account acc = (Account) currentSession.get(Account.class, key);
        closeSession();
        return acc;
    }

    @Override
    public void update(Account object) {
        openSession();
        currentSession.update(object);
        closeSession();
    }

    @Override
    public void delete(Account object) {
            openSession();
            currentSession.remove(object);
            closeSession();
    }

    @Override
    public List<Account> readAll() {
        openSession();
        List<Account> accounts = (List<Account>) currentSession.createQuery("from Account ").list();
        closeSession();
        return accounts;
    }

    public List<Account> readAlById(int id) {
        openSession();
        List<Account> accounts = (List<Account>) currentSession.createQuery("from Account where userId = "+id).list();
        closeSession();
        return accounts;
    }
}

package dao;

import domain.Account;
import domain.Transaction;
import domain.TransactionType;
import org.hibernate.Session;

import java.util.List;

public class TransactionDao implements GenericDao<Transaction, Integer> {
    private Session currentSession;
    private org.hibernate.Transaction currentTransaction;

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
    public void create(Transaction object) {
        openSession();
        currentSession.save(object);
        closeSession();
    }

    @Override
    public Transaction read(Integer key) {
        openSession();
        Transaction trn = (Transaction) currentSession.get(Transaction.class, key);
        closeSession();
        return trn;

    }

    @Override
    public void update(Transaction object) {
        openSession();
        currentSession.update(object);
        closeSession();
    }

    @Override
    public void delete(Transaction object) {
        openSession();
        currentSession.remove(object);
        closeSession();
    }

    @Override
    public List<Transaction> readAll() {
        openSession();
        List<Transaction> transactions = (List<Transaction>) currentSession.createQuery("from Transaction ").list();
        closeSession();
        return transactions;
    }

    public List<Transaction> readAlById(int id) {
        openSession();
        List<Transaction> transactions = (List<Transaction>) currentSession.createQuery("from Transaction where userId = " + id).list();
        closeSession();
        return transactions;
    }

    public List<Transaction> readAlByIdAndType(int id, TransactionType type) {
        openSession();
        List<Transaction> transactions =
                (List<Transaction>) currentSession.createQuery("from Transaction where userId = " + id + " and type = " + type).list();
        closeSession();
        return transactions;
    }
}

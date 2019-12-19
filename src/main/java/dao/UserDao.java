package dao;

import domain.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDao implements GenericDao<User, Integer>{
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
    public void create(User object) {
        openSession();
        currentSession.save(object);
        closeSession();
    }

    @Override
    public User read(Integer key) {
        openSession();
        User user = (User) currentSession.get(User.class, key);
        closeSession();
        return user;
    }

    @Override
    public void update(User object) {
        openSession();
        currentSession.update(object);
        closeSession();
    }

    @Override
    public void delete(User object) {
        openSession();
        currentSession.remove(object);
        closeSession();
    }

    @Override
    public List<User> readAll() {
        openSession();
        List<User> users = (List<User>) currentSession.createQuery("from User ").list();
        closeSession();
        return users;
    }

    public User readByLogin(String login) {
        openSession();
        User user = (User) currentSession.createQuery("FROM User U WHERE U.login ='"+login+"'").list().get(0);
        closeSession();
        return user;
    }


}

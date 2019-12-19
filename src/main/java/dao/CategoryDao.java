package dao;

import domain.Category;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CategoryDao implements GenericDao<Category, Integer> {
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
    public void create(Category object) {
        openSession();
        currentSession.save(object);
        closeSession();
    }

    @Override
    public Category read(Integer key) {
        openSession();
        Category category = (Category) currentSession.get(Category.class, key);
        closeSession();
        return category;
    }

    @Override
    public void update(Category object) {
        openSession();
        currentSession.update(object);
        closeSession();
    }

    @Override
    public void delete(Category object) {
        openSession();
        currentSession.remove(object);
        closeSession();
    }

    @Override
    public List<Category> readAll() {
        openSession();
        List<Category> categories = (List<Category>) currentSession.createQuery("from Category ").list();
        closeSession();
        return categories;
    }

    public List<Category> readAlById(int id) {
        openSession();
        List<Category> categories = (List<Category>) currentSession.createQuery("from Category where userId = "+id).list();
        closeSession();
        return categories;
    }
}

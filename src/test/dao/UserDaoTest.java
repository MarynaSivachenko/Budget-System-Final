package dao;

import domain.Customer;
import domain.User;
import domain.UserState;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {

    @Test
    public void create() {
        GenericDao<Customer, Integer> dao = new CustomerDao();
        GenericDao<User, Integer> uDao = new UserDao();
        Customer customer = dao.read(1);

        User user = new User();
        user.setLogin("masi");
        user.setPassword("12345");
        user.setEmail("hjljkgndlf");
        user.setStatus(UserState.NEW);
        user.setCustomer(customer);
        uDao.create(user);
    }

    @Test
    public void read() {
    }

    @Test
    public void update() {
    }

    @Test
    public void readAll() {
    }
}
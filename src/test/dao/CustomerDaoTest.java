package dao;

import domain.Customer;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CustomerDaoTest {

    @Test
    public void createCustomerTest() {
        Customer c = new Customer();
        c.setFirstName("Thor");
        c.setLastName("Odinson");
        c.setPhone("8888");

        GenericDao<Customer, Integer> dao = new CustomerDao();
        dao.create(c);


    }

    @Test
    public void getCustomerById() {

        GenericDao<Customer, Integer> dao = new CustomerDao();
        Customer c = dao.read(1);
        assertNotNull(c);
        System.out.println(c.toString());

    }

    @Test
    public void updateCustomer() {
        GenericDao<Customer, Integer> dao = new CustomerDao();
        Customer c = dao.read(1);
        c.setFirstName("Loki");

        dao.update(c);

        Customer c2 = dao.read(1);

        System.out.println(c.toString());
        System.out.println(c2.toString());
        assertEquals(c, c2);

    }

    @Test
    public void readAll() {
        GenericDao<Customer, Integer> dao = new CustomerDao();
        List<Customer> customers = dao.readAll();
        System.out.println(customers);
    }
}
package services;

import dao.CustomerDao;
import dao.GenericDao;
import dao.UserDao;
import domain.Customer;
import domain.User;
import domain.UserState;
import org.primefaces.event.FlowEvent;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class UserRegistration implements Serializable {

    private User user = new User();
    private Customer customer = new Customer();

    private boolean skip;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }


    public void save() {
        GenericDao<Customer, Integer> cDao = new CustomerDao();
        GenericDao<User, Integer> uDao = new UserDao();

        cDao.create(customer);
        user.setCustomer(customer);
        user.setStatus(UserState.NEW);
        uDao.create(user);

        FacesMessage msg = new FacesMessage("Successful", "Welcome :" + user.getLogin());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }
}

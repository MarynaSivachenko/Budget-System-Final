package services;

import dao.UserDao;
import domain.User;
import org.primefaces.PrimeFaces;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class UserLoginView {

    private User currentUser;

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public String login() {
        FacesMessage message = null;
        boolean loggedIn = false;


        if (username != null && password != null) {
            UserDao dao = new UserDao();
             currentUser = dao.readByLogin(username);
            if (currentUser != null && currentUser.loginIn(username, password)) {
                loggedIn = true;
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
                return "ok";
            } else {
                loggedIn = false;
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
            }
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
        PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
        return "error";
    }
}
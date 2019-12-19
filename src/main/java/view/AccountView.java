package view;

import domain.Account;
import domain.Category;
import org.primefaces.event.RowEditEvent;
import services.AccountService;
import services.CategoryServices;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean(name = "accView")
@ViewScoped
public class AccountView {

    private AccountService services;

    private List<Account> accounts;

    public AccountView() {
        services = new AccountService();
    }

    public List<Account> getAccounts() {
        return accounts;

    }

    public void init(int uid) {
        this.accounts = services.getAllByUId(uid);
        ;
    }

    public String openAccount(int uid) {
        accounts.add(services.openAccount(uid));
        return "done";
    }

    public AccountService getServices() {
        return services;
    }


}

package services;


import dao.AccountDao;
import dao.GenericDao;
import domain.Account;
import domain.Category;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ManagedBean
@ViewScoped
public class AccountService {
    private AccountDao dao = new AccountDao();

    public Account openAccount(int uid){
        Account temp = new Account();
        temp.setUserId(uid);
        dao.create(temp);
        return temp;
    }

    public List<Account> getAll(){
        return dao.readAll();
    }


    public List<Account> getAllByUId(int id){
        return dao.readAlById(id);
    }

    public Map<String,Integer> getAllMapByUId(int id){

        return dao.readAlById(id).stream().collect(Collectors.toMap(Account::getNumber, Account::getId));
    }

    public void update(Account ctg){
        dao.update(ctg);
    }

    public Account getById(int aid){
        return dao.read(aid);
    }

}

package services;

import dao.AccountDao;
import dao.TransactionDao;
import domain.Account;
import domain.Category;
import domain.Transaction;
import domain.TransactionType;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.time.LocalDate;
import java.util.List;

@ManagedBean
@ApplicationScoped
public class TransactionService {
    private TransactionDao dao = new TransactionDao();
    private AccountDao accountDao = new AccountDao();


    public void create(int uid, TransactionType type, int accId, double amount, int catid) {
        Transaction some = new Transaction(0, accId, amount, LocalDate.now(), uid, type, catid);
        dao.create(some);
        Account current = accountDao.read(accId);
        current.putMoney(amount);
        accountDao.update(current);
    }

    public List<Transaction> getAll() {
        return dao.readAll();
    }


    public List<Transaction> getAllByUID(int id) {
        return dao.readAlById(id);
    }

    public List<Transaction> getAllByUIDAndType(int id, TransactionType type) {
        return dao.readAlByIdAndType(id, type);
    }

    public void update(Transaction trn) {
        dao.update(trn);
    }
}

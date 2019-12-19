package view;

import domain.Transaction;
import domain.TransactionType;
import services.TransactionService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.List;
import java.util.Locale;

import static java.lang.Integer.getInteger;

@ManagedBean(name = "tView")
@ViewScoped
public class TransactionView {
    private List<Transaction> trnAll;
    private Transaction currentAcc = new Transaction();


    private List<Transaction> trnAllFiltered ;


    @ManagedProperty(value = "#{transactionService}")
    private TransactionService services;


    public void init(int uid) {
        this.trnAll = services.getAllByUID(uid);
    }

    public boolean filterByAmount(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if (filterText == null || filterText.equals("")) {
            return true;
        }

        if (value == null) {
            return false;
        }

        return ((Comparable) value).compareTo(getInteger(filterText)) > 0;
    }

    public List<Transaction> getTrnAll() {
        return trnAll;
    }

    public void setTrnAll(List<Transaction> trnAll) {
        this.trnAll = trnAll;
    }


    public TransactionService getServices() {
        return services;
    }

    public void setServices(TransactionService services) {
        this.services = services;
    }

    public List<Transaction> getTrnAllFiltered() {
        return trnAllFiltered;
    }

    public void setTrnAllFiltered(List<Transaction> trnAllFiltered) {
        this.trnAllFiltered = trnAllFiltered;
    }

    public Transaction getCurrentAcc() {
        return currentAcc;
    }

    public void setCurrentAcc(Transaction currentAcc) {
        this.currentAcc = currentAcc;
    }

    public String makeIncome(int uid){
        services.create(uid,TransactionType.INCOME, currentAcc.getAccId(), currentAcc.getAmount(), currentAcc.getCategoryId());
    return "done";
    }
}

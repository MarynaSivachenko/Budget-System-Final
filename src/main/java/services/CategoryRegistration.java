package services;

import dao.CategoryDao;
import dao.GenericDao;
import domain.Category;

import org.primefaces.event.FlowEvent;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean
@ViewScoped
public class CategoryRegistration {
    private Category category = new Category();

    private boolean skip;

    public String save(int uid) {
        GenericDao<Category, Integer> dao = new CategoryDao();
        category.setUserId(uid);
        System.out.println(uid);
        dao.create(category);
        return "done";
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public String onFlowProcess(FlowEvent event) {
        if (skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        } else {
            return event.getNewStep();
        }
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

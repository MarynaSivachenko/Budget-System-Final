package view;

import domain.Category;
import org.primefaces.event.RowEditEvent;
import services.CategoryServices;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import java.util.List;

@ManagedBean(name = "catView")
@ViewScoped
public class CategorySortView {

    @ManagedProperty(value = "#{categoryServices}")
    private CategoryServices services;

    private List<Category> categories;

//    public CategorySortView() {
//        services = new CategoryServices();
//    }

    public List<Category> getCategories() {
        return categories;

    }

    public void init(int uid) {
        this.categories = services.getAllByUId(uid);;
    }

    public CategoryServices getServices() {
        return services;
    }

    public void setServices(CategoryServices services) {
        this.services = services;
    }

    public void onRowEdit(RowEditEvent event) {
        services.update((Category) event.getObject());
    }

    public void onRowCancel(RowEditEvent event) {

    }

}

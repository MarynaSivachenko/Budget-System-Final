package services;

import dao.CategoryDao;
import domain.Account;
import domain.Category;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ManagedBean
@ApplicationScoped
public class CategoryServices {
    private CategoryDao dao = new CategoryDao();


    public List<Category> getAll() {
        return dao.readAll();
    }


    public List<Category> getAllByUId(int id) {
        return dao.readAlById(id);
    }

    public void update(Category ctg) {
        dao.update(ctg);
    }


    public Map<String, Integer> getAllMapByUId(int id) {
        return dao.readAlById(id).stream().collect(Collectors.toMap(Category::getTitle, Category::getId));
    }


}

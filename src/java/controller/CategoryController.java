
package controller;

import dao.CategoryHelper;
import model.Film;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;
import model.Category;


@Named(value = "categoryController")
@SessionScoped
public class CategoryController implements Serializable {

    int startId;
    int endId;
    DataModel categoryModel;
    CategoryHelper helper;
    private final int recordCount = 1000;
    private final int pageSize = 10;
    private Category category;
    private Integer codigo;


    public Category getCategory()
    {
        if (category == null){
            category = new Category();
        }
          return category;
    }
    
    public CategoryController() {
        helper = new CategoryHelper();

    }

    public DataModel getCategoryModel() {
        if (categoryModel == null) {
            categoryModel = new ListDataModel(helper.getCategory());
        }
        return categoryModel;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void inserir() {
        CategoryHelper categoryHelper = new CategoryHelper();
        categoryHelper.inserir(category);
    }

    public void delete() {
        CategoryHelper categoryHelper = new CategoryHelper();
        categoryHelper.excluir(category);
    }

    public void atualizar() {
        CategoryHelper categoryHelper = new CategoryHelper();
        categoryHelper.atualizar(category);
    }
    
    public void carregardados(){
        
        if(codigo != null){
            
            CategoryHelper categoryHelper = new CategoryHelper();
            category = categoryHelper.getCategoryByID(codigo);
        }else{
            
            category = new Category();
        }
        
    }
   
}


package controller;

import dao.RentalHelper;
import dao.CategoryHelper;
import model.Film;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;
import model.Rental;


@Named(value = "rentalController")
@SessionScoped
public class RentalController implements Serializable {

    int startId;
    int endId;
    DataModel rentalModel;
    RentalHelper helper;
    private final int recordCount = 1000;
    private final int pageSize = 10;
    private Rental rental;
    private Integer codigo;


    public Rental getRental()
    {
        if (rental == null){
            rental = new Rental();
        }
          return rental;
    }
    
    public RentalController() {
        helper = new RentalHelper();

    }

    public DataModel getRentalModel() {
        if (rentalModel == null) {
            rentalModel = new ListDataModel(helper.getRental());
        }
        return rentalModel;
    }
    
    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void inserir() {
        RentalHelper rentalHelper = new RentalHelper();
        rentalHelper.inserir(rental);
    }

    public void delete() {
        RentalHelper rentalHelper = new RentalHelper();
        rentalHelper.excluir(rental);
    }

    public void atualizar() {
        RentalHelper rentalHelper = new RentalHelper();
        rentalHelper.atualizar(rental);
    }
    
    public void carregardados(){
        
        if(codigo != null){
            
            RentalHelper rentalHelper = new RentalHelper();
            rental = rentalHelper.getRentalByID(codigo);
        }else{
            
            rental = new Rental();
        }
        
    }
   
}

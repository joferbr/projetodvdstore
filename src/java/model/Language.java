package model;
// Generated 07/06/2019 22:11:26 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Language generated by hbm2java
 */
public class Language  implements java.io.Serializable {


     private int languageId;
     private String name;
     private Date lastUpdate;
     private Set<Film> films = new HashSet<Film>(0);

    public Language() {
    }

	
    public Language(int languageId, String name, Date lastUpdate) {
        this.languageId = languageId;
        this.name = name;
        this.lastUpdate = lastUpdate;
    }
    public Language(int languageId, String name, Date lastUpdate, Set<Film> films) {
       this.languageId = languageId;
       this.name = name;
       this.lastUpdate = lastUpdate;
       this.films = films;
    }
   
    public int getLanguageId() {
        return this.languageId;
    }
    
    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Date getLastUpdate() {
        return this.lastUpdate;
    }
    
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    public Set<Film> getFilms() {
        return this.films;
    }
    
    public void setFilms(Set<Film> films) {
        this.films = films;
    }




}



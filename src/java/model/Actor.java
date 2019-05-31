package model;
// Generated 27/04/2019 21:52:51 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Actor generated by hbm2java
 */
public class Actor  implements java.io.Serializable {


     private int actorId;
     private String firstName;
     private String lastName;
     private Date lastUpdate;
     private Set<FilmActor> filmActors = new HashSet<FilmActor>(0);

    public Actor() {
    }

	
    public Actor(int actorId, String firstName, String lastName, Date lastUpdate) {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastUpdate = lastUpdate;
    }
    public Actor(int actorId, String firstName, String lastName, Date lastUpdate, Set<FilmActor> filmActors) {
       this.actorId = actorId;
       this.firstName = firstName;
       this.lastName = lastName;
       this.lastUpdate = lastUpdate;
       this.filmActors = filmActors;
    }
   
    public int getActorId() {
        return this.actorId;
    }
    
    public void setActorId(int actorId) {
        this.actorId = actorId;
    }
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Date getLastUpdate() {
        return this.lastUpdate;
    }
    
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    public Set<FilmActor> getFilmActors() {
        return this.filmActors;
    }
    
    public void setFilmActors(Set<FilmActor> filmActors) {
        this.filmActors = filmActors;
    }




}



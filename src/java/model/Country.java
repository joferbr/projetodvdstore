package model;
// Generated 07/06/2019 22:11:26 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Country generated by hbm2java
 */
public class Country  implements java.io.Serializable {


     private int countryId;
     private String country;
     private Date lastUpdate;
     private Set<City> cities = new HashSet<City>(0);

    public Country() {
    }

	
    public Country(int countryId, String country, Date lastUpdate) {
        this.countryId = countryId;
        this.country = country;
        this.lastUpdate = lastUpdate;
    }
    public Country(int countryId, String country, Date lastUpdate, Set<City> cities) {
       this.countryId = countryId;
       this.country = country;
       this.lastUpdate = lastUpdate;
       this.cities = cities;
    }
   
    public int getCountryId() {
        return this.countryId;
    }
    
    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    public Date getLastUpdate() {
        return this.lastUpdate;
    }
    
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    public Set<City> getCities() {
        return this.cities;
    }
    
    public void setCities(Set<City> cities) {
        this.cities = cities;
    }




}


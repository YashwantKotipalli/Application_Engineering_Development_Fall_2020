/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class Account {
    
    
    private String CarName;
    private String Manufacturer;
    private String Yom;
    private String NumberOfSeats;
    private String SerialNumber;
    private String ModelNumber;
    private String Location;
    private Boolean Availability;
    private Date createdOn;

    public Boolean getAvailability() {
        
        return Availability;
    }

    public void setAvailability(Boolean Availability) {
        this.Availability = Availability;
    }

    public Account() {
        
        this.createdOn = new Date();
    }

    public String getCarName() {
        return CarName;
    }

    public void setCarName(String CarName) {
        this.CarName = CarName;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String Manufacturer) {
        this.Manufacturer = Manufacturer;
    }

    public String getYom() {
        return Yom;
    }

    public void setYom(String Yom) {
        this.Yom = Yom;
    }

    public String getNumberOfSeats() {
        return NumberOfSeats;
    }

    public void setNumberOfSeats(String NumberOfSeats) {
        this.NumberOfSeats = NumberOfSeats;
    }

    public String getSerialNumber() {
        return SerialNumber;
    }

    public void setSerialNumber(String SerialNumber) {
        this.SerialNumber = SerialNumber;
    }

    public String getModelNumber() {
        return ModelNumber;
    }

    public void setModelNumber(String ModelNumber) {
        this.ModelNumber = ModelNumber;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
    
    

    
    
    @Override
    public String toString(){
        return CarName;
    }

    
}

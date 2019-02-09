package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Amenities {


    @Id
    @JsonProperty("ID")
    private Integer id;

    @Basic
    @JsonProperty("Air Conditioner")
    private String Airconditioner;

    @Basic
    @JsonProperty("Heater")
    private String Heater;

    @Basic
    @JsonProperty("WIFI")
    private  String WIFI;

    @Basic
    @JsonProperty("Pool")
    private String Pool;

    @Basic
    @JsonProperty("Kitchen")
    private String Kitchen;

    @Basic
    @JsonProperty("Car Parking")
    private String CarParking;

    public Amenities(){

    }

    public Amenities(Integer id, String airconditioner, String heater, String WIFI, String pool, String kitchen, String carParking) {
        this.id = id;
        Airconditioner = airconditioner;
        Heater = heater;
        this.WIFI = WIFI;
        Pool = pool;
        Kitchen = kitchen;
        CarParking = carParking;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String setAirconditioner() {
        return Airconditioner;
    }

    public void setAirconditioner(String airconditioner) {
        Airconditioner = airconditioner;
    }

    public String getHeater() {
        return Heater;
    }

    public void setHeater(String heater) {
        Heater = heater;
    }

    public String getWIFI() {
        return WIFI;
    }

    public void setWIFI(String WIFI) {
        this.WIFI = WIFI;
    }

    public String getPool() {
        return Pool;
    }

    public void setPool(String pool) {
        Pool = pool;
    }

    public String getKitchen() {
        return Kitchen;
    }

    public void setKitchen(String kitchen) {
        Kitchen = kitchen;
    }

    public String getCarParking() {
        return CarParking;
    }

    public void setCarParking(String carParking) {
        CarParking = carParking;
    }
}

package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Home {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Integer id;

    @Basic
    @JsonProperty("name")
    private  String name;


    @Basic
    @JsonProperty("location")
    private  String location;

    @Basic
    @JsonProperty("fromDate")
    private Date fromDate;

    @Basic
    @JsonProperty("toDate")
    private Date toDate;

    @Basic
    @JsonProperty("Price")
    private String price;

    public Home() {
    }

    public Home(Integer id, String name, String location, Date fromDate, Date toDate, String price) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

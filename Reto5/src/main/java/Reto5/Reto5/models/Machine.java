/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto5.Reto5.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author WizzardShadow
 */
/**
 * Indicamos a la clase la tabla con la que se asociara
*/
@Entity
@Table (name = "machine")

public class Machine implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    /*
    Atributos de la clase
    */
    private Integer id;
    private String name;
    private String brand;
    private Integer year;
    private String description;
    
    
    /**
     * Relación muchos a uno entre la tabla category y machines
     */
    @ManyToOne
    @JoinColumn(name = "categoryid")
    @JsonIgnoreProperties("machines")
    private Category category;
    
    /**
     * Relacion uno a muchos entre machine y category
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "machine")
    @JsonIgnoreProperties({"machine", "client"})
    
    /**
     * Lista para almacenar los mensajes asociados a una máquina
     */
    private List<Message> messages; 
    
    /**
     * relacion uno a muchos entre machine y reservations
     */
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "machine")
    @JsonIgnoreProperties({"machine", "client"})
    private List<Reservation> reservations;

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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    

    
    
    /**
     * Métodos getter and setter
     * @return 
     */

    
    
    
    
}

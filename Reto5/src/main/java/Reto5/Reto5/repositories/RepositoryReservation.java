/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto5.Reto5.repositories;

import Reto5.Reto5.interfaces.InterfaceReservation;
import Reto5.Reto5.models.Client;
import Reto5.Reto5.models.CountClient;
import Reto5.Reto5.models.Reservation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author WizzardShadow
 */

@Repository

public class RepositoryReservation {
    
    @Autowired

    private InterfaceReservation crud4;

    public List<Reservation> getAll() {
        return (List<Reservation>) crud4.findAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return crud4.findById(id);
    }

    public Reservation save(Reservation reservation) {
        return crud4.save(reservation);
    }

    public void delete(Reservation reservation) {
        crud4.delete(reservation);
    }
    
    public List<Reservation> ReservationStatusRepository (String status){
         return crud4.findAllByStatus(status);
     }
     
     public List<Reservation> ReservationTiempoRepository (Date a, Date b){
         return crud4.findAllByStartDateAfterAndStartDateBefore(a, b);
     
     }
     
     public List<CountClient> getClientesRepositorio(){
         List<CountClient> res = new ArrayList<>();
         List<Object[]> report = crud4.countTotalReservationsByClient();
         for(int i=0; i<report.size(); i++){
             res.add(new CountClient((Long)report.get(i)[1],(Client) report.get(i)[0]));
         }
         return res;
     }

}

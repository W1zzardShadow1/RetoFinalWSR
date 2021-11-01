/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto5.Reto5.services;

/**
 * librerías necesarias
 */

import Reto5.Reto5.models.CountClient;
import Reto5.Reto5.models.Reservation;
import Reto5.Reto5.models.StatusReservation;
import Reto5.Reto5.repositories.RepositoryReservation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author WizzardShadow
 */

@Service

public class ServiceReservation {
    /**
     * @Autowired etiqueta que permite la creación automática de objetos
     */
    @Autowired
    /**
     * Esta etiqueta permite la creación de un objeto para implementar el CRUD
     */
    
    private RepositoryReservation metodosCrud;
    
    /**
     * Este método permite visualizar la lista de reservaciones
     */

    public List<Reservation> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Reservation> getReservation(int reservationId) {
        return metodosCrud.getReservation(reservationId);
    }
    
    /**
     * Este método corresponde al POS
     * 
     */

    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return metodosCrud.save(reservation);
        } else {
            Optional<Reservation> e = metodosCrud.getReservation(reservation.getIdReservation());
            if (e.isEmpty()) {
                return metodosCrud.save(reservation);
            } else {
                return reservation;
            }
        }
    }
    
    /**
     * 
     * Método para actualizar 
     */

    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> e = metodosCrud.getReservation(reservation.getIdReservation());
            if (!e.isEmpty()) {

                if (reservation.getStartDate() != null) {
                    e.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    e.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(e.get());
                return e.get();
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }
    
    /**
     * Método para borrar a partir del ID
     * @param reservationId
     * @return 
     */

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    /**
     * Método para verificar el estado de un servicio
     * @return completado o cancellado
     */
    public StatusReservation reportStatusService (){
        List<Reservation>completed= metodosCrud.ReservationStatusRepository("completed");
        List<Reservation>cancelled= metodosCrud.ReservationStatusRepository("cancelled");
        
        return new StatusReservation(completed.size(), cancelled.size() );
    }
    
    /**
     * Metodo para establecer el periodo de alquiler de una máquina
     * @param datoA
     * @param datoB
     * @return 
     */
    public List<Reservation> reporteTiempoServicio (String datoA, String datoB){
        SimpleDateFormat parser = new SimpleDateFormat ("yyyy-MM-dd");
        
        Date datoUno = new Date();
        Date datoDos = new Date();
        
        try{
             datoUno = parser.parse(datoA);
             datoDos = parser.parse(datoB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return metodosCrud.ReservationTiempoRepository(datoUno, datoDos);
        }else{
            return new ArrayList<>();
        
        } 
    }
    /**
     * Método para imprimir el reporte de clientes
     * @return una lista 
     */
    public List<CountClient> reporteClientesServicio(){
            return metodosCrud.getClientesRepositorio();
        }


}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto5.Reto5.repositories;

import Reto5.Reto5.interfaces.InterfaceMachine;
import Reto5.Reto5.models.Machine;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author WizzardShadow
 */

@Repository
public class RepositoryMachine {
    
    @Autowired 
    private InterfaceMachine crud;
    
    public List<Machine> getAll(){
        return (List<Machine>) crud.findAll();
    }      
    
    public Optional<Machine> getMachine(int id){
            return crud.findById(id); 
    }     
    
    public Machine save(Machine machine){ 
        return crud.save(machine);
    }
    public void delete(Machine machine){
        crud.delete(machine);
    }
    
}

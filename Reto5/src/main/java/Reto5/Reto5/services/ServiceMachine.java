/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto5.Reto5.services;

import Reto5.Reto5.models.Machine;
import Reto5.Reto5.repositories.RepositoryMachine;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author WizzardShadow
 */

@Service

public class ServiceMachine {
    
    @Autowired
    private RepositoryMachine metodosCrud;
    
    public List<Machine> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Machine> getMachine(int IdMachine){
        return metodosCrud.getMachine(IdMachine);
    }
    
    public Machine save(Machine machine){
        if(machine.getId()==null){
            return metodosCrud.save(machine);
        }
        else{
            Optional<Machine> e=metodosCrud.getMachine(machine.getId());
            if(e.isEmpty()){
                return metodosCrud.save(machine);
            }
            else{
                return machine;
            }
        }
    }
    
    public Machine update (Machine machine){
        if(machine.getId()!=null){
            Optional<Machine> e=metodosCrud.getMachine(machine.getId());
            if(!e.isEmpty()){
                if(machine.getName()!=null){
                    e.get().setName(machine.getName());
                }
                if(machine.getBrand()!=null){
                    e.get().setBrand(machine.getBrand());
                }
                if(machine.getYear()!=null){
                    e.get().setYear(machine.getYear());
                }
                if(machine.getDescription()!=null){
                    e.get().setDescription(machine.getDescription());
                }
                if(machine.getCategory()!=null){
                    e.get().setCategory(machine.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return machine;
            }
        }else{
            return machine;
        }
    }
    
    public boolean deleteMachine(int IdMachine){
        Boolean aBoolean = getMachine(IdMachine).map(machine ->{
            metodosCrud.delete(machine);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}

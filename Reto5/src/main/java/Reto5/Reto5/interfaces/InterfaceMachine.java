/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reto5.Reto5.interfaces;

import Reto5.Reto5.models.Machine;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author WizzardShadow
 */
public interface InterfaceMachine extends CrudRepository<Machine,Integer>{
    
}

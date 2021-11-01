/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto5.Reto5.repositories;

import Reto5.Reto5.interfaces.InterfaceCategory;
import Reto5.Reto5.models.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author WizzardShadow
 */
@Repository

public class RepositoryCategory {
    
    @Autowired

    private InterfaceCategory crud;

    public List<Category> getAll() {
        return (List<Category>) crud.findAll();
    }

    public Optional<Category> getCategory(int id) {
        return crud.findById(id);
    }

    public Category save(Category category) {
        return crud.save(category);
    }

    public void delete(Category Category) {
        crud.delete(Category);
    }
    
}

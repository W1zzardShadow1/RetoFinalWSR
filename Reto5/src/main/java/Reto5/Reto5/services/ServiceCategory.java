/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto5.Reto5.services;

import Reto5.Reto5.models.Category;
import Reto5.Reto5.repositories.RepositoryCategory;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author WizzardShadow
 */

@Service

public class ServiceCategory {
    
    @Autowired
    private RepositoryCategory metodosCrud;

    public List<Category> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Category> getCategory(int CategoryId) {
        return metodosCrud.getCategory(CategoryId);
    }

    public Category save(Category category) {
        if (category.getId()== null) {
            return metodosCrud.save(category);
        } else {
            Optional<Category> category1 = metodosCrud.getCategory(category.getId());
            if (category1.isEmpty()) {
                return metodosCrud.save(category);
            } else {
                return category;
            }
        }
    }

    public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category>g=metodosCrud.getCategory(category.getId());
            if(!g.isEmpty()){
                if(category.getDescription()!=null){
                    g.get().setDescription(category.getDescription());
                }
                if(category.getName()!=null){
                    g.get().setName(category.getName());
                }
                return metodosCrud.save(g.get());
            }
        }
        return category;
    }
    public boolean deleteCategory(int categoryId){
        Boolean d=getCategory(categoryId).map(category -> {
            metodosCrud.delete(category);
            return true;
        }).orElse(false);
        return d;
    }
    
}

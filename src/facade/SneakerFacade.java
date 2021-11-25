/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Sneaker;

/**
 *
 * @author user
 */
public class SneakerFacade extends AbstractFacade<Sneaker>{

    public SneakerFacade(Class<Sneaker> entityClass) {
        super(entityClass);
    }
    
}

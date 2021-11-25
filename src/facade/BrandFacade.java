/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Brand;

/**
 *
 * @author user
 */
public class BrandFacade extends AbstractFacade<Brand>{
    
    public BrandFacade(Class<Brand> entityClass) {
        super(entityClass);
    }
    
}

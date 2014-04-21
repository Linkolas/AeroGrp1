/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domaine;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franck.cros
 */
public class Compte {
    
    
    int num_membre;
    List<OperationCompte> operations;
    
    
    public Compte(){
        operations = new ArrayList();
 
    }
    
        public Compte(int numMembre){
        operations = new ArrayList();
        num_membre = numMembre;
        
    }
    
    
    public void setNumMembre(int value){
        
        
    }
    
    public int getNumMembre(){
     
        return num_membre;
    }
    
    public List<OperationCompte> getOperations(){
        return operations;
    }
    
    public void addOperation(OperationCompte value){
        operations.add(value);
    }
    
    
}

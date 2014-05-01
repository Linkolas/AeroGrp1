/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domaine;

import java.util.Date;

/**
 * 
 * @author franck.cros
 */
public class OperationCompte {
    
    int numOperation;
    Date dateOperation;
    float valeurOperation;
    String commentaire;
    boolean autocreation;
    int numSeq;
    
    public OperationCompte(){
        
    }
    
     public OperationCompte(int numOp, Date dateOp, float valeurOp, String com){
        
        numOperation = numOp;
        dateOperation = dateOp;
        valeurOperation = valeurOp;
        commentaire = com;
        
    }
    
    
    
    public OperationCompte(int numOp, Date dateOp, float valeurOp, String com, boolean autocrea, int num_seq){
        
        numOperation = numOp;
        dateOperation = dateOp;
        valeurOperation = valeurOp;
        commentaire = com;
        autocreation = autocrea;
        numSeq = num_seq;
        
    }
    
    public void setNumOperation(int value){
        numOperation = value;
    }
    
    public void setDateOperation(Date value){
        dateOperation = value;
    }
    
    public void setValeurOperation(float value){
        valeurOperation = value;
    }
    
    public void setCommentaire(String value){
        commentaire = value;
    }
    
    public void setAutocreation(boolean value){
        autocreation = value;
    }
    
    public void setNumSeq(int value){
        numSeq = value;
    }
    
    
    public int getNumOperation(){
        return numOperation;
    }
    
    public Date getDateOperation(){
        return dateOperation;
    }
    
    public float getValeurOperation(){
       return valeurOperation;
    }
    
    public String getCommentaire(){
       return commentaire;
    }
    
    public boolean getAutocreation(){
        return autocreation;
    }
    
    public int getNumSeq(){
        return numSeq;
    }
}

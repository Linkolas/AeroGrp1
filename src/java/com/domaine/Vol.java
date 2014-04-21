/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domaine;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author nicolas.pendon
 */
public class Vol {
    private int numsequence;
    private Date datesequence;
    
    public Vol() {
        this(-1, new Date());
    }
    
    public Vol(int num, Date date) {
        numsequence = num;
        datesequence = date;
    }
    
    public void setNum(int num) {
        numsequence = num;
    }
    
    public void setDate(Date date) {
        datesequence = date;
    }
    
    public int getNum() {
        return numsequence;
    }
    
    public Date getDate() {
        return datesequence;
    }
    
    @Override
    public String toString() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(datesequence);
        int year = cal.get(Calendar.YEAR);
        int month= cal.get(Calendar.MONTH) +1;
        int day  = cal.get(Calendar.DAY_OF_MONTH);
        String date = year + "-" + (month < 10 ? "0" : "") + month + "-" + (day < 10 ? "0" : "") + day;
        return date + " #" + numsequence;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;



/**
 *
 * @author Dell
 */
public class Jobs {
    private int id;
    private String name;
    private Date start_date;
    private Date end_date;

    public Jobs() {
    }

    public Jobs(String name, Date start_date, Date end_date) {
        this.name = name;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public Jobs(int id, String name, Date start_date, Date end_date) {
        this.id = id;
        this.name = name;
        this.start_date = start_date;
        this.end_date = end_date;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
    
}

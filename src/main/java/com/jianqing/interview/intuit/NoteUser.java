package com.jianqing.interview.intuit;

import java.util.List;

/**
 * Created by jianqing_sun on 12/6/17.
 */
public class NoteUser extends Model {
    private long id;
    private String fname;
    private String lname;
    private List<Note> notes;

    public void save(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

}

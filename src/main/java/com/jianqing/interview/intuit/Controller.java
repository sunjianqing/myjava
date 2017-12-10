package com.jianqing.interview.intuit;

import java.util.List;

/**
 * Created by jianqing_sun on 12/6/17.
 */
public class Controller {

    private static Controller instance;
    private Controller(){

    }

    public static synchronized Controller getInstance(){
        if(instance == null){
            instance = new Controller();
        }

        return instance;
    }

    public void createUser(String userRequest){

    }

    public void createNote(String noteRequest){

    }

    public View getNotesByUser(NoteUser user){
        List<Note> notes = user.getNotes();
        return new BrowserView();
    }

    public Note getNoteById(long nid){
        return null;
    }


}

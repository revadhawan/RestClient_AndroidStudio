package edu.upc.eetac.dsa.restclient;

import com.google.gson.annotations.SerializedName;

public class Tracks {

    public String title;
    public String singer;
    public int tracksId;


    @Override
    public String toString(){
        return ("Title:" + title +"Singer:" + singer);
    }


}

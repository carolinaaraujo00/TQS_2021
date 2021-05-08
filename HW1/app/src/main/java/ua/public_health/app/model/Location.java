package ua.public_health.app.model;

import java.util.Locale;

public class Location {
    // modelo para guardar os dados provenientes da api relativos aos concelhos disponíveis

    private String name;

    public Location(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void name(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return this.name.toLowerCase(Locale.ROOT);
    }
}

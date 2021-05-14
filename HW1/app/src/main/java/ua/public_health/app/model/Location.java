package ua.public_health.app.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Locale;

@Getter
@Setter
public class Location {
    // modelo para guardar os dados provenientes da api relativos aos concelhos disponíveis

    private String name;

    public Location(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return this.name.toLowerCase(Locale.ROOT);
    }
}

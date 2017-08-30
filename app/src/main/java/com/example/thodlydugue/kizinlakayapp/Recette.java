package com.example.thodlydugue.kizinlakayapp;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Jerry on 8/22/2017.
 */

public class Recette {

    public String getTextRecette() {
        return textRecette;
    }

    public String getImageRecette() {
        return imageRecette;
    }

    String textRecette;
    String imageRecette;


    public Recette(String textRecette, String imageRecette){
        try{
            this.textRecette = "Jolies bonbons";
            this.imageRecette= "";

        }catch(Exception e){
             e.printStackTrace();
        }
    }

    public ArrayList<Recette> fromArray(Array[] array)

    {
        ArrayList<Recette> results = new ArrayList<>();

        for(int x=0; x < array.length; x++){
            try{
                results.add(new Recette(textRecette,imageRecette));

            }catch(Exception e){
                e.printStackTrace();
            }

        }
        return results;
    }

}

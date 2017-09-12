package com.example.thodlydugue.kizinlakayapp.Modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by sonel on 9/10/2017.
 */

public class favorites implements Serializable {
    private String nom_recette;
    private String image_recette;
    private Users id_user;
    private String description;
    private String ingredients;

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    private String preparation;

    public String getNom_recette() {
        return nom_recette;
    }

    public void setNom_recette(String nom_recette) {
        this.nom_recette = nom_recette;
    }

    public String getImage_recette() {
        return image_recette;
    }

    public void setImage_recette(String image_recette) {
        this.image_recette = image_recette;
    }

    public Users getId_user() {
        return id_user;
    }

    public void setId_user(Users id_user) {
        this.id_user = id_user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }



    public favorites(){

    }

    public static ArrayList<favorites> fromListMap(List<Map> map) {

        ArrayList<favorites> favorites = new ArrayList();

        for(int i = 0; i < map.size(); i++) {
            favorites f = new favorites();
            f.setNom_recette((String) map.get(i).get("nomrecette"));
            f.setImage_recette((String) map.get(i).get("imagerecette"));
            f.setDescription((String) map.get(i).get("description"));
            f.setIngredients((String) map.get(i).get("ingredients"));
            f.setPreparation((String) map.get(i).get("preparation"));



            favorites.add(f);
        }

        return favorites;
    }
}

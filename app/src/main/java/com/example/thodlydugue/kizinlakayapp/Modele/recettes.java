package com.example.thodlydugue.kizinlakayapp.Modele;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
<<<<<<< HEAD
 * Created by sonel on 8/22/2017.Backendless.Data.of
 *
 * 3333333333333333333222222222222222222222222222222222222222222222222
=======
 * Created by sonel on 8/22/2017.
>>>>>>> 3e8b37cb6f6fb79ce35cb43d5522625170cda682
 */

public class recettes {



    private String nom_recette;
    private String image_recette;
    private categories id_categorie;
    private String description;


    public recettes(){
this.nom_recette=getNom_recette();
        this.image_recette=getImage_recette();
    }


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

    public categories getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(categories id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public static ArrayList<recettes> fromListMap(List<Map> map) {

        ArrayList<recettes> recette = new ArrayList();

        for(int i = 0; i < map.size(); i++) {
            recettes p = new recettes();
            p.setNom_recette((String) map.get(i).get("nom_recette"));
            p.setImage_recette((String) map.get(i).get("image_recette"));

            recette.add(p);
        }

        return recette;
    }






}

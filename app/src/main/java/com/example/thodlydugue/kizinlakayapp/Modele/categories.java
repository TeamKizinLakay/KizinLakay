package com.example.thodlydugue.kizinlakayapp.Modele;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

=======
>>>>>>> 3e8b37cb6f6fb79ce35cb43d5522625170cda682
/**
 * Created by sonel on 8/23/2017.
 */

public class categories {
<<<<<<< HEAD

   private String nom_categorie;
    private String objectId;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getNom_categorie() {
        return nom_categorie;
    }

    public void setNom_categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
    }
    public static ArrayList<categories> fromListMap(List<Map> map) {

        ArrayList<categories> categories = new ArrayList();

        for(int i = 0; i < map.size(); i++) {
            categories c = new categories();
            c.setObjectId((String) map.get(i).get("ObjectId"));
            //p.setImage_recette((String) map.get(i).get("image_recette"));


            categories.add(c);
        }

        return categories;
    }


=======
>>>>>>> 3e8b37cb6f6fb79ce35cb43d5522625170cda682
}

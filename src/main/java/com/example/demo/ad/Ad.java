package com.example.demo.ad;


import com.sun.xml.internal.ws.developer.Serialization;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Ad {

    @SequenceGenerator(
            name = "ad_sequence",
            sequenceName = "ad_sequence",
            allocationSize = 1

    )
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ad_sequence")
    private Long id;
    private String nom;
    private String description;
    private String image;
    private String prix;
    private String categorie;
    private Long id_fid;
    public Ad(String nom, String description, String image, String prix, String categorie,Long id_fid) {
        this.nom = nom;
        this.description = description;
        this.image = image;
        this.prix = prix;
        this.categorie = categorie;
        this.id_fid =  id_fid;
    }

    public Ad(Ad ad) {

    }

    public Ad(Object o) {
        Ad ad =(Ad) o;
        this.id = ad.getId();
        this.nom = ad.getNom();
        this.description = ad.getDescription();
    }
}

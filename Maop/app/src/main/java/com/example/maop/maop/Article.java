package com.example.maop.maop;

/**
 * Created by guillaume on 19/01/2016.
 */
public class Article {
    private int idarticle;
    private String nomarticle;
    private String categorie;
    private Float prix;
    private String description;
    private String image;
    private int idmagasin;

    // Constructeur

    public Article() {

    }

    public int getIdarticle() {
        return idarticle;
    }

    public String getNomarticle() {
        return nomarticle;
    }

    public String getCategorie() {
        return categorie;
    }

    public Float getPrix() {
        return prix;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public int getIdmagasin() {
        return idmagasin;
    }

    public void setIdmagasin(int idmagasin) {
        this.idmagasin = idmagasin;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setNomarticle(String nomarticle) {
        this.nomarticle = nomarticle;
    }

    public void setIdarticle(int idarticle) {
        this.idarticle = idarticle;
    }
}

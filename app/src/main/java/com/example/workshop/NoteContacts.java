package com.example.workshop;

public class NoteContacts {
    private long id;
    private String nom;
    private String prenom;
    private String infos;
    private String relation;
    private String photo;
    private String tel;

    NoteContacts(String nom,String prenom,String infos, String relation, String photo, String tel){
        this.nom = nom;
        this.prenom = prenom;
        this.infos = infos;
        this.relation = relation;
        this.photo = photo;
        this.tel = tel;
    }

    NoteContacts(long id,String nom,String prenom,String infos, String relation, String photo, String tel){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.infos = infos;
        this.relation = relation;
        this.photo = photo;
        this.tel = tel;
    }
    NoteContacts(){
        // empty constructor
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getInfos() {
        return infos;
    }

    public void setInfos(String infos) {
        this.infos = infos;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}

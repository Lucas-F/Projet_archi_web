/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.biblio.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;


@Entity
@NamedQuery(name = Profil.FIND_ALL, query = "SELECT b FROM Profil b")

public class Profil {
   public final static String FIND_ALL = "Profil.findAll";
   public final static String DEL_SOM = "Profil.delete";

 @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    private String prenom;
    private String adresse;
    private int age;
    private int taille;
    private String statut;
    private String mail;
    private String couleurcheveux;
    private String couleureyes;
    @Column(length = 2000)
    private String description;
    private Boolean enfant;
    @Transient
    private Boolean selected;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Profil() {
    }

    public Profil(String name, String prenom,String adresse,Integer age,Integer taille,  String statut,String mail,String couleurcheveux,String couleureyes,String description, Boolean enfant) {
        this.name = name;
        this.prenom = prenom;
        this.adresse = adresse;
        this.age=age;
        this.taille=taille;
        this.statut=statut;
        this.mail=mail;
        this.couleurcheveux=couleurcheveux;
        this.couleureyes=couleureyes;
        this.description = description;
        this.enfant = enfant;
        
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

     public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
   
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAge(){
        return age;
    } 
    
    public void setAge(Integer age)
    {
        this.age=age;
    }
    
    public Integer getTaille(){
        return taille;
    } 
    
    public void setTaille(Integer taille)
    {
        this.taille=taille;
    }
    
    public String getStatut(){
        return statut;
    } 
    
    public void setStatut(String statut)
    {
        this.statut=statut;
    }
    
    
    public String getMail(){
        return mail;
    } 
    
    public void setMail(String mail)
    {
        this.mail=mail;
    }
    
    
    public String getCouleurcheveux(){
        return couleurcheveux;
    } 
    
    public void setCouleurcheveux(String couleurcheveux)
    {
        this.couleurcheveux=couleurcheveux;
    }
    
    public String getCouleureyes(){
        return couleureyes;
    } 
    
    public void setCouleureyes(String couleureyes)
    {
         this.couleureyes=couleureyes;
    }
    
   public Boolean getEnfant(){
        return enfant;
    } 
    
    public void setEnfant(Boolean enfant)
    {
        this.enfant=enfant;
    }
    
     public Boolean isSelected() {
        return selected;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
}
        
  
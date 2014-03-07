/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.projetjee.rencontre_v2.model;


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
    private long id;
    @Column(nullable = false)
    private String name;
    private String prenom;
    private String adresse;
    private String statut;
    private String sexe;
    private int age;
    private int taille;
    private String mail;
    private String description;
    private String musique;
    private String interet;
    private String caractere;
    private String enfant;/*
    private String couleurcheveux;
    private String couleureyes;
    @Column(length = 2000)

    */
    @Transient
    private Boolean selected;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Profil() {
    }

    public Profil(String name, String prenom, int age, String adresse, int  taille, String mail, String description, 
            String sexe, String statut, String musique, String interet, String caractere, String enfant){
        this.name = name;
        this.prenom = prenom;
        this.age = age;
        this.adresse = adresse;
        this.statut = statut;
        this.taille = taille;
        this.mail = mail;
        this.description = description;
        this.sexe = sexe;
        this.musique = musique;
        this.interet = interet;
        this.caractere = caractere;
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
    
     public Integer getAge(){
        return age;
    } 
    
    public void setAge(Integer age)
    {
        this.age = age;
    }
    
     public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    public String getStatut(){
        return statut;
    } 
    
    public void setStatut(String statut)
    {
        this.statut = statut;
    }
    
    public Integer getTaille(){
        return taille;
    } 
    
    public void setTaille(Integer taille)
    {
        this.taille = taille;
    }
    
    public String getMail(){
        return mail;
    } 
    
    public void setMail(String mail)
    {
        this.mail = mail;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getSexe(){
        return sexe;
    } 
    
    public void setSexe(String sexe)
    {
         this.sexe = sexe;
    }
    
    public String getMusique() {
        return musique;
    }

    public void setMusique(String musique) {
        this.musique = musique;
    }
    
    public String getInteret() {
        return interet;
    }

    public void setInteret(String interet) {
        this.interet = interet;
    }
    
    public String getCaractere() {
        return caractere;
    }

    public void setCaractere(String caractere) {
        this.caractere = caractere;
    }    
    
    public String getEnfant(){
        return enfant;
    } 
    
    public void setEnfant(String enfant)
    {
        this.enfant = enfant;
    }
    /*
     
    
    
    
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
    
   
    */
    
     /*
     */
    
     public Boolean isSelected() {
        return selected;
    }

    public Boolean getSelected() {
        return selected;
    }

    
    
    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
   

    // ======================================
    // =         hash, equals, toString     =
    // ======================================

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Profil");
        sb.append("{id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", prenom=").append(prenom);
        sb.append(", age=").append(age).append('\'');
        sb.append(", adresse=").append(adresse).append('\'');
        sb.append(", statut=").append(statut).append('\'');
        sb.append(", taille=").append(taille).append('\'');
        sb.append(", mail=").append(mail).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", sexe=").append(sexe).append('\'');
        sb.append(", musique=").append(musique).append('\'');
        sb.append(", interet=").append(interet).append('\'');
        sb.append(", caractere").append(caractere);
        sb.append(", enfant=").append(enfant).append('\'');/*
        
        
       

        
        sb.append(", couleurcheveux").append(couleurcheveux).append('\'');
        sb.append(", couleureyes").append(couleureyes).append('\'');
    */
        sb.append('}');
        return sb.toString();
    }
}
        
  
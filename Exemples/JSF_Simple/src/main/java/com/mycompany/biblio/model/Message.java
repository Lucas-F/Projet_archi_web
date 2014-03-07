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
@NamedQuery(name = Message.FIND_ALL, query = "SELECT b FROM Message b")

public class Message {
   public final static String FIND_ALL = "Message.findAll";
   public final static String DEL_SOM = "Message.delete";

  @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private long idemetteur;
    @Column(nullable = false)
    private long iddestinataire;
    private String sujet;
    private String contenu;
   
    @Transient
    private Boolean selected;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Message() {
    }

    public Message(long idemetteur, long iddestinataire, String sujet,String contenu){
        this.idemetteur = idemetteur ;
        this.iddestinataire = iddestinataire;
        this.sujet = sujet;
        this.contenu = contenu;
        
    }
    // ======================================
    // =          Getters & Setters         =
    // ======================================
    public Long getId() {
        return id;
    }

    public long getIdemetteur() {
        return idemetteur;
    }

    public void setIdemetteur(long idemetteur) {
        this.idemetteur = idemetteur;
    }

    public long getIddestinataire() {
        return iddestinataire;
    }

    public void setIddestinaire(long iddestinataire) {
        this.iddestinataire = iddestinataire;
    }
    
     public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }
    
    public String getContenu(){
        return contenu;
    } 
    
    public void setContenu(String contenu)
    {
        this.contenu = contenu;
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
   

    // ======================================
    // =         hash, equals, toString     =
    // ======================================

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Message");
        sb.append("{id=").append(id);
        sb.append(", idemetteur='").append(idemetteur).append('\'');
        sb.append(", iddestinataire=").append(iddestinataire).append('\'');
        sb.append(", sujet=").append(sujet).append('\'');
        sb.append(", contenu=").append(contenu);
        sb.append('}');
        return sb.toString();
    }
}
        
  
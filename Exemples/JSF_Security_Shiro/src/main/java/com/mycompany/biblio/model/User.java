/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.biblio.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author morgan
 */
@Entity
@Table(name="users")
public class User implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

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
@Table(name="user_roles")
public class Role implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    
    @Column(name="username")
    private String username;
    @Column(name="role_name")
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

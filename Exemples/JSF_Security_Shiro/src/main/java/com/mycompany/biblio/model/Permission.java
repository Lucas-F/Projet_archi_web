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
@Table(name="roles_permissions")
public class Permission implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    
    @Column(name="permission")
    private String permission;
    @Column(name="role_name")
    private String role;

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

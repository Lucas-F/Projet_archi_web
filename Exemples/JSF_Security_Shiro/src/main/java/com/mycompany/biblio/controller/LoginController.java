package com.mycompany.biblio.controller;

import com.mycompany.biblio.business.BookEJB;
import com.mycompany.biblio.model.Book;
import com.mycompany.biblio.model.User;
import javax.faces.bean.ManagedBean;
import javax.ejb.EJB;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;


@ManagedBean
@SessionScoped
public class LoginController {

    // ======================================
    // =             Attributes             =
    // ======================================

    @EJB
    private BookEJB bookEJB;

    private User user= new User();

    // ======================================
    // =           Public Methods           =
    // ======================================

    public String doLogin() {
        AuthenticationToken token= new UsernamePasswordToken(user.getUsername(), user.getPassword());
        Subject currentUser= SecurityUtils.getSubject(); 
        try {
            
            currentUser.login( token );
            //if no exception, that's it, we're done!
        } catch (Exception e) {
            addWarnMessage("Connexion impossible : ", "vérifiez les paramètres saisis");
            return null;
        }
        return "/private/listBooks.xhtml?faces-redirect=true";
    }

    private void addWarnMessage(String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, summary, detail));
    }

    public String doLogout() {
        SecurityUtils.getSubject().logout();
        return "/private/listBooks.xhtml?faces-redirect=true";
    }
    
    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
package fr.projetjee.rencontre_v2.controller;

import fr.projetjee.rencontre_v2.business.ProfilEJB;
import fr.projetjee.rencontre_v2.model.Profil;
import fr.projetjee.rencontre_v2.model.Profil;

import javax.ejb.EJB;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.ListDataModel;


@ManagedBean
@SessionScoped
public class ProfilController {

    // ======================================
    // =             Attributes             =
    // ======================================

    @EJB
    private ProfilEJB profilEJB;

    private HtmlDataTable dataTable;

    private Profil profil = new Profil();
    private ListDataModel profilList; // j'ai utilisé un ListDataModel et pas List parce que cela permet de retrouver l'élément sélectionné dans la liste (pour l'édition d'un livre)

    private void updateProfilList() {
        profilList = new ListDataModel(profilEJB.findAll());
    }

    // ======================================
    // =           Public Methods           =
    // ======================================

    public String doNew() {
        profil = new Profil();
        return "inscription.xhtml";
    }

    public String doCreate() {
        profil = profilEJB.create(profil);
        return "listProfil.xhtml";
    }
    
    public String doCancel() {
        return "listProfil.xhtml";
    }

    public String doDelete() {
        List<Profil> profils = (List<Profil>)profilList.getWrappedData();
        profilEJB.delete(onlySelected(profils));
        updateProfilList();
        return "listProfil.xhtml";
    }

    private List<Profil> onlySelected(List<Profil> list) {
        for (Iterator<Profil> it = list.iterator(); it.hasNext(); ) {
            if (!(it.next().isSelected()))
                it.remove();
        }
        return list;
    }

    public String doEdit() {
        profil = (Profil)profilList.getRowData(); // Voici comment on trouve le livre sélectionné
        return "editProfil.xhtml";
    }

    public String doSave() {
        profil = profilEJB.update(profil);
        return "listProfil.xhtml";
    }
    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public ListDataModel getProfilList() {
        updateProfilList();
        return profilList;
    }

    public void setProfilList(ListDataModel profilList) {
        this.profilList = profilList;
    }

    public HtmlDataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(HtmlDataTable dataTable) {
        this.dataTable = dataTable;
    }

    
}
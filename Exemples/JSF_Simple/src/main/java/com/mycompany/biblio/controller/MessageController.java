package com.mycompany.biblio.controller;

import com.mycompany.biblio.business.MessageEJB;
import com.mycompany.biblio.model.Message;

import javax.ejb.EJB;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.ListDataModel;


@ManagedBean
@SessionScoped
public class MessageController {

    // ======================================
    // =             Attributes             =
    // ======================================

    @EJB
    private MessageEJB messageEJB;

    private HtmlDataTable dataTable;

    private Message message = new Message();
    private ListDataModel messageList; // j'ai utilisé un ListDataModel et pas List parce que cela permet de retrouver l'élément sélectionné dans la liste (pour l'édition d'un livre)

    private void updateMessageList() {
        messageList = new ListDataModel(messageEJB.findAll());
    }

    // ======================================
    // =           Public Methods           =
    // ======================================

    public String doNew() {
        message = new Message();
        return "inscription.xhtml";
    }

    public String doCreate() {
        message = messageEJB.create(message);
        return "listProfil.xhtml";
    }
    
    public String doCancel() {
        return "listProfil.xhtml";
    }

    public String doDelete() {
        List<Message> messages = (List<Message>)messageList.getWrappedData();
        messageEJB.delete(onlySelected(messages));
        updateMessageList();
        return "listProfil.xhtml";
    }

    private List<Message> onlySelected(List<Message> list) {
        for (Iterator<Message> it = list.iterator(); it.hasNext(); ) {
            if (!(it.next().isSelected()))
                it.remove();
        }
        return list;
    }

    public String doEdit() {
        message = (Message)messageList.getRowData(); // Voici comment on trouve le livre sélectionné
        return "editProfil.xhtml";
    }

    public String doSave() {
        message = messageEJB.update(message);
        return "listProfil.xhtml";
    }
    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public ListDataModel getMessageList() {
        updateMessageList();
        return messageList;
    }

    public void setMessageList(ListDataModel messageList) {
        this.messageList = messageList;
    }

    public HtmlDataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(HtmlDataTable dataTable) {
        this.dataTable = dataTable;
    }

    
}
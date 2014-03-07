package com.mycompany.biblio.business;

import com.mycompany.biblio.model.Message;
import java.util.List;
import javax.persistence.*;
import javax.ejb.Stateless;

@Stateless
public class MessageEJB {

    // ======================================
    // =             Attributes             =
    // ======================================
    @PersistenceContext(unitName = "jsfExamplePU")
    private EntityManager em;

    // ======================================
    // =           Public Methods           =
    // ======================================
    public List<Message> findAll() {
        Query query = em.createNamedQuery(Message.FIND_ALL);
        return query.getResultList();
    }

    public Message create(Message message) {
        em.persist(message);
        return message;
    }

    public Message update(Message message) {
        return em.merge(message);
    }

    public void delete(List<Message> list) {
        for (Message message : list) {
            delete(message);
        }
    }

    public void delete(Message message) {
        em.remove(em.merge(message));
    }
}

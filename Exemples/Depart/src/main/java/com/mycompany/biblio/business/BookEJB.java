package com.mycompany.biblio.business;

import com.mycompany.biblio.model.Book;
import java.util.List;
import javax.persistence.*;
import javax.ejb.Stateless;

@Stateless
public class BookEJB {

    // ======================================
    // =             Attributes             =
    // ======================================
    @PersistenceContext(unitName = "jsfExamplePU")
    private EntityManager em;

    // ======================================
    // =           Public Methods           =
    // ======================================
    public List<Book> findAll() {
        Query query = em.createNamedQuery(Book.FIND_ALL);
        return query.getResultList();
    }

    public Book create(Book book) {
        em.persist(book);
        return book;
    }

    public Book update(Book book) {
        return em.merge(book);
    }

    public void delete(List<Book> list) {
        for (Book book : list) {
            delete(book);
        }
    }

    public void delete(Book book) {
        em.remove(em.merge(book));
    }
}

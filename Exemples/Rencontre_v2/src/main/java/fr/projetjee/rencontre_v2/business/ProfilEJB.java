package fr.projetjee.rencontre_v2.business;

import fr.projetjee.rencontre_v2.model.Profil;
import fr.projetjee.rencontre_v2.model.Profil;
import java.util.List;
import javax.persistence.*;
import javax.ejb.Stateless;

@Stateless
public class ProfilEJB {

    // ======================================
    // =             Attributes             =
    // ======================================
    @PersistenceContext(unitName = "jsfExamplePU")
    private EntityManager em;

    // ======================================
    // =           Public Methods           =
    // ======================================
    public List<Profil> findAll() {
        Query query = em.createNamedQuery(Profil.FIND_ALL);
        return query.getResultList();
    }

    public Profil create(Profil profil) {
        em.persist(profil);
        return profil;
    }

    public Profil update(Profil profil) {
        return em.merge(profil);
    }

    public void delete(List<Profil> list) {
        for (Profil profil : list) {
            delete(profil);
        }
    }

    public void delete(Profil profil) {
        em.remove(em.merge(profil));
    }
}

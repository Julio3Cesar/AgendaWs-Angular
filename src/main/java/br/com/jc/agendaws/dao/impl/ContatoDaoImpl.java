package br.com.jc.agendaws.dao.impl;

import br.com.jc.agendaws.dao.ContatoDao;
import br.com.jc.agendaws.factory.EMFactory;
import br.com.jc.agendaws.models.Contatos;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ContatoDaoImpl implements ContatoDao {
    
    @PersistenceContext
    private EntityManager em;

    public ContatoDaoImpl() {
//        this.em = new EMFactory().getEntityManager();
    }

    @Override
    public List<Contatos> listarContatos() {
        return this.em.createNamedQuery("Contatos.findAll", Contatos.class).getResultList();
    }

    @Override
    public Contatos buscarContatoId(Integer id) {
        return this.em.createNamedQuery("Contatos.findById", Contatos.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void inserirContato(Contatos contato) {
        System.out.println("CONTATO: " + contato.getNome());
        this.em.getTransaction().begin();
        this.em.persist(contato);
        this.em.getTransaction().commit();
    }

    @Override
    public void deletarContatoId(Integer id) {
//        this.em.getTransaction().begin();
        this.em.remove(this.buscarContatoId(id));
//        this.em.getTransaction().commit();
    }

    @Override
    public void updateContato(Contatos contato) {
        this.em.getTransaction().begin();
        this.em.merge(contato);
        this.em.getTransaction().commit();
    }
}

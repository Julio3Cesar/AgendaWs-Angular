package br.com.jc.agendaws.dao.impl;

import br.com.jc.agendaws.dao.RegisterDao;
import br.com.jc.agendaws.factory.EMFactory;
import br.com.jc.agendaws.models.Usuario;
import javax.persistence.EntityManager;

public class RegisterDaoImpl implements RegisterDao{

    private final EntityManager em;

    public RegisterDaoImpl() {
        this.em = new EMFactory().getEntityManager();
    }
    
    @Override
    public void registrar(Usuario usuario) {
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
    }
}

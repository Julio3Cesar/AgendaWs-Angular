package br.com.jc.agendaws.dao.impl;

import br.com.jc.agendaws.dao.UsuarioDao;
import br.com.jc.agendaws.factory.EMFactory;
import br.com.jc.agendaws.models.Usuario;
import javax.persistence.EntityManager;

public class UsuarioDaoImpl implements UsuarioDao{
    
    private EntityManager em;
    
    public UsuarioDaoImpl() {
        em = new EMFactory().getEntityManager();
    }
//    @PersistenceContext(unitName = "agendaws")
    

    @Override
    public Usuario getUser(String userName) {
        return em.createNamedQuery("Usuario.findByUsername", Usuario.class)
                .setParameter("username", userName)
                .getSingleResult();
    }

    
}

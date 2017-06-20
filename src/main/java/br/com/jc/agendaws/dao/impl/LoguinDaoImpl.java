package br.com.jc.agendaws.dao.impl;

import br.com.jc.agendaws.dao.LoguinDao;
import br.com.jc.agendaws.factory.EMFactory;
import br.com.jc.agendaws.models.DTO.UsuarioAutenticaDTO;
import br.com.jc.agendaws.models.Usuario;
import javax.persistence.EntityManager;

public class LoguinDaoImpl implements LoguinDao {

    private final EntityManager em;

    public LoguinDaoImpl() {
        this.em = new EMFactory().getEntityManager();
    }

    @Override
    public Usuario buscarUser(UsuarioAutenticaDTO usuario) {
        return em.createNamedQuery("Usuario.findByUsernameAndSenha", Usuario.class)
                .setParameter("username", usuario.getUser())
                .setParameter("senha", usuario.getPass())
                .getSingleResult();
    }
}

package br.com.jc.agendaws.service.impl;

import br.com.jc.agendaws.dao.UsuarioDao;
import br.com.jc.agendaws.dao.impl.UsuarioDaoImpl;
import br.com.jc.agendaws.models.DTO.UsuarioLogadoDTO;
import br.com.jc.agendaws.models.Usuario;
import br.com.jc.agendaws.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {
    
    private final UsuarioDao dao;
    
    public UsuarioServiceImpl() {
        this.dao = new UsuarioDaoImpl();
    }
    
    @Override
    public UsuarioLogadoDTO getUser(String user) {
        return this.converteUser(dao.getUser(user));
    }
    
    private UsuarioLogadoDTO converteUser(Usuario u) {
        UsuarioLogadoDTO c = new UsuarioLogadoDTO();
        
        c.setFoto(u.getFoto());
        c.setNome(u.getNome());
        c.setProfissao(u.getProfissao());
        return c;
    }
}

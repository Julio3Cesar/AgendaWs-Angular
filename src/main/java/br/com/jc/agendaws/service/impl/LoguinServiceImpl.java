package br.com.jc.agendaws.service.impl;

import br.com.jc.agendaws.dao.LoguinDao;
import br.com.jc.agendaws.dao.impl.LoguinDaoImpl;
import br.com.jc.agendaws.models.DTO.UsuarioAutenticaDTO;
import br.com.jc.agendaws.models.DTO.UsuarioLogadoDTO;
import br.com.jc.agendaws.models.Usuario;
import br.com.jc.agendaws.service.LoguinService;

public class LoguinServiceImpl implements LoguinService {

    private final LoguinDao dao;
    private UsuarioLogadoDTO logado;
    private Usuario usuarioRes;

    public LoguinServiceImpl() {
        this.dao = new LoguinDaoImpl();
    }

    public UsuarioLogadoDTO loguin(UsuarioAutenticaDTO usuario) {
        this.usuarioRes = this.dao.buscarUserPass(usuario);
        this.logado = new UsuarioLogadoDTO(this.usuarioRes.getNome(), this.usuarioRes.getUsername());
        
        return this.logado;
    }
}

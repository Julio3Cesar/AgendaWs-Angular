package br.com.jc.agendaws.dao;

import br.com.jc.agendaws.models.DTO.UsuarioAutenticaDTO;
import br.com.jc.agendaws.models.Usuario;

public interface LoguinDao {
    
    Usuario buscarUserPass(UsuarioAutenticaDTO usuario);
}

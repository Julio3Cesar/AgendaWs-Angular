package br.com.jc.agendaws.service;

import br.com.jc.agendaws.models.DTO.UsuarioAutenticaDTO;
import br.com.jc.agendaws.models.DTO.UsuarioLogadoDTO;


public interface LoguinService {
    
    UsuarioLogadoDTO loguin(UsuarioAutenticaDTO usuario);
}

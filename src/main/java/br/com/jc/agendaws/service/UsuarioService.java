package br.com.jc.agendaws.service;

import br.com.jc.agendaws.models.DTO.UsuarioLogadoDTO;

public interface UsuarioService {
    UsuarioLogadoDTO getUser(String user);
}

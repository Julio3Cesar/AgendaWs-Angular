package br.com.jc.agendaws.webservice;

import br.com.jc.agendaws.models.DTO.UsuarioAutenticaDTO;
import br.com.jc.agendaws.models.DTO.UsuarioLogadoDTO;
import br.com.jc.agendaws.utilitarios.response.ObjectResponse;

public interface LoguinWebService {
    ObjectResponse<UsuarioLogadoDTO> postAutentica (UsuarioAutenticaDTO usuario);
}

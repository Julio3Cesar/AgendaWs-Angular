package br.com.jc.agendaws.webservice;

import br.com.jc.agendaws.models.DTO.UsuarioAutenticaDTO;

public interface LoguinWebService {

    String postAutentica(UsuarioAutenticaDTO usuario);
}

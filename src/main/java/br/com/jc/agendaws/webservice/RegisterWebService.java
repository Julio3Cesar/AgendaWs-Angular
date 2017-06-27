package br.com.jc.agendaws.webservice;

import br.com.jc.agendaws.models.Usuario;
import javax.ws.rs.core.Response;

public interface RegisterWebService {

    Response postRegistrar(Usuario usuario);
}

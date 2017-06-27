package br.com.jc.agendaws.webservice.impl;

import br.com.jc.agendaws.models.DTO.UsuarioLogadoDTO;
import br.com.jc.agendaws.service.UsuarioService;
import br.com.jc.agendaws.service.impl.UsuarioServiceImpl;
import br.com.jc.agendaws.webservice.UsuarioWebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//@Stateless
@Path("user")
public class UsuarioEndPoint implements UsuarioWebService {

    private final UsuarioService service;

    public UsuarioEndPoint() {
        this.service = new UsuarioServiceImpl();
    }

    @GET
    @Path("get/{user}")
    @Produces(MediaType.APPLICATION_JSON)
    public UsuarioLogadoDTO find(@PathParam("user") String user) {
        return service.getUser(user);
    }
}

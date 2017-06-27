package br.com.jc.agendaws.webservice.impl;

import br.com.jc.agendaws.models.Usuario;
import br.com.jc.agendaws.service.RegisterService;
import br.com.jc.agendaws.service.impl.RegisterServiceImpl;
import br.com.jc.agendaws.webservice.RegisterWebService;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("registrar")
@RequestScoped
public class RegisterEndPoint implements RegisterWebService {

    @Context
    private UriInfo context;
    
    private final RegisterService service;

    public RegisterEndPoint() {
        this.service = new RegisterServiceImpl();
    }

    @POST
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postRegistrar(Usuario usuario) {
        try {
            this.service.registrar(usuario);
            return Response.status(200).build();
        }catch(Exception e){
            throw new WebApplicationException(500);
        }
        
    }
}

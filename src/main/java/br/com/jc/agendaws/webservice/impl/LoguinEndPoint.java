package br.com.jc.agendaws.webservice.impl;

import br.com.jc.agendaws.models.DTO.UsuarioAutenticaDTO;
import br.com.jc.agendaws.filter.TokenInterceptor;
import br.com.jc.agendaws.service.LoguinService;
import br.com.jc.agendaws.service.impl.LoguinServiceImpl;
import br.com.jc.agendaws.webservice.LoguinWebService;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.interceptor.Interceptors;
import javax.ws.rs.POST;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;


@Path("autentica")
@RequestScoped
public class LoguinEndPoint implements LoguinWebService {

//    @Context
//    private UriInfo context;
    private final LoguinService service;

    public LoguinEndPoint() {
        this.service = new LoguinServiceImpl();
    }

    @POST
    @Override
    @Path("loguin")
    @Produces(MediaType.TEXT_PLAIN)
    @Interceptors(TokenInterceptor.class)
    @Consumes(MediaType.APPLICATION_JSON)
    public String postAutentica(UsuarioAutenticaDTO usuario) {
        try {
            return this.service.loguin(usuario);
        } catch (Exception e) {
            throw new WebApplicationException(500);
        }
    }
}

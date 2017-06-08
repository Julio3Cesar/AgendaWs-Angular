package br.com.jc.agendaws.webservice.impl;

import br.com.jc.agendaws.models.DTO.UsuarioAutenticaDTO;
import br.com.jc.agendaws.models.DTO.UsuarioLogadoDTO;
import br.com.jc.agendaws.service.LoguinService;
import br.com.jc.agendaws.service.impl.LoguinServiceImpl;
import br.com.jc.agendaws.utilitarios.response.ObjectResponse;
import br.com.jc.agendaws.webservice.LoguinWebService;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

@Path("autentica")
@RequestScoped
public class LoguinEndPoint implements LoguinWebService {

    private final LoguinService service;
    private ObjectResponse<UsuarioLogadoDTO> response;

    public LoguinEndPoint() {
        this.service = new LoguinServiceImpl();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        throw new UnsupportedOperationException();
    }

    @POST
    @Override
    @Path("loguin")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public ObjectResponse<UsuarioLogadoDTO> postAutentica(UsuarioAutenticaDTO usuario) {
        try {
            System.out.println("CHEGOU NO POST");
            return this.response = new ObjectResponse("200", "Logado com sucesso!", this.service.loguin(usuario));
        } catch (Exception e) {
            throw new WebApplicationException(500);
        }
    }
}

package br.com.jc.agendaws.webservice.impl;

import br.com.jc.agendaws.models.DTO.ContatoDTO;
import br.com.jc.agendaws.service.ContatosService;
import br.com.jc.agendaws.service.impl.ContatosServiceImpl;
import br.com.jc.agendaws.webservice.ContatosWebService;
import java.util.List;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("agenda")
public class ContatosEndPoint implements ContatosWebService {

    private final ContatosService service;

    public ContatosEndPoint() {
        this.service = new ContatosServiceImpl();
    }

    @GET
    @Override
    @Path("contatos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ContatoDTO> getContatos() {
        return this.service.getContatos();
    }

    @GET
    @Override
    @Path("contato/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ContatoDTO getContato(@PathParam("id") Integer id) {
        return this.service.getContato(id);
    }

    @POST
    @Override
    @Path("cadastrar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response adicionar(ContatoDTO contatoj) {
        try {
            this.service.setContato(contatoj);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            System.out.println("ERROR AO ADD! ");
            throw new WebApplicationException(500);
        }
    }

    @DELETE
    @Override
    @Path("deletar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletar(@PathParam("id") Integer id) {
        System.out.println("CHEGOU AQUI 1");
        try {
            this.service.deleteContato(id);
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            throw new WebApplicationException(500);
        }
    }
}

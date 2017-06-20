package br.com.jc.agendaws.webservice.impl;

import br.com.jc.agendaws.models.DTO.ContatoDTO;
import br.com.jc.agendaws.service.ContatosService;
import br.com.jc.agendaws.service.impl.ContatosServiceImpl;
import br.com.jc.agendaws.webservice.ContatosWebService;
import com.google.gson.Gson;
import java.util.Arrays;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

@Path("agenda")
public class ContatosEndPoint implements ContatosWebService {

    private final ContatosService service;
    private final Gson gson;

    public ContatosEndPoint() {
        this.gson = new Gson();
        this.service = new ContatosServiceImpl();
    }

    @GET
    @Override
    @Path("contatos")
    @Produces(MediaType.APPLICATION_JSON)
    public String getContatosJson() {
        return gson.toJson(this.service.getContatos());
    }

    @GET
    @Override
    @Path("contato/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getContatoJson(@PathParam("id") Integer id) {
        return gson.toJson(this.service.getContato(id));
    }

    @POST
    @Override
    @Path("cadastrar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String postJson(ContatoDTO contatoj) {
        try {
//            ContatoDTO contatoj = gson.fromJson(contato,ContatoDTO.class);
            System.out.println("NOME:  " + contatoj.getNome());
            this.service.setContato(contatoj);
            System.out.println("CHEGOU AQUI!!");
            return gson.toJson("{statusCode: 200}");
//            return "{statusCode: 200}";
        } catch (Exception e) {
            System.out.println("ERROR AO ADD! ");
//            System.out.println("AQUI NOME CONTATO:  "+contatoj.getNome());
            System.out.println(Arrays.toString(e.getStackTrace()));
            throw new WebApplicationException(500);
        }
    }

    @DELETE
    @Override
    @Path("deletar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@PathParam("id") Integer id) {
        System.out.println("CHEGOU AQUI 1");
        try {
            this.service.deleteContato(id);
            return gson.toJson("{statusCode: 200}");
        } catch (Exception e) {
            throw new WebApplicationException(500);
        }
    }
}

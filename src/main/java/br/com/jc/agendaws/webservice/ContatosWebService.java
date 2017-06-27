/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jc.agendaws.webservice;

import br.com.jc.agendaws.models.DTO.ContatoDTO;
import java.util.List;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author resource
 */
public interface ContatosWebService {

    List<ContatoDTO> getContatos(String user);

    ContatoDTO getContato(@PathParam("id") int id);
    
    Response adicionar(ContatoDTO contato);
    
    Response deletar(@PathParam("id") Integer id);
}

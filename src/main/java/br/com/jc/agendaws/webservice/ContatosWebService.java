/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jc.agendaws.webservice;

import br.com.jc.agendaws.models.DTO.ContatoDTO;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author resource
 */
public interface ContatosWebService {

    String getContatosJson();

    String getContatoJson(@PathParam("id") Integer id);
    
    String postJson(ContatoDTO contato);
    
    String delete(@PathParam("id") Integer id);
}

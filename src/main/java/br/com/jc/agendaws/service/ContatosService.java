package br.com.jc.agendaws.service;

import br.com.jc.agendaws.models.DTO.ContatoDTO;
import java.util.List;

public interface ContatosService {

    List<ContatoDTO> getContatos(String user);

    void setContato(ContatoDTO contato);
    
    public ContatoDTO getContato(Integer id);
    
    void deleteContato(Integer id);
}

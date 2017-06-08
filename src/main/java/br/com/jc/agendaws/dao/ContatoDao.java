package br.com.jc.agendaws.dao;

import br.com.jc.agendaws.models.Contatos;
import java.util.List;

public interface ContatoDao {

    List<Contatos> listarContatos();

    Contatos buscarContatoId(Integer id);
    
    void inserirContato(Contatos contato);
    
    void deletarContatoId(Integer id);
    
    void updateContato (Contatos contato);
}

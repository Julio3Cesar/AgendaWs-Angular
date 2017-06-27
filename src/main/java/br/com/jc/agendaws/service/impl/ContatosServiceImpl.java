package br.com.jc.agendaws.service.impl;

import br.com.jc.agendaws.dao.ContatoDao;
import br.com.jc.agendaws.dao.impl.ContatoDaoImpl;
import br.com.jc.agendaws.models.Contatos;
import br.com.jc.agendaws.models.DTO.ContatoDTO;
import br.com.jc.agendaws.service.ContatosService;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.WebApplicationException;

public class ContatosServiceImpl implements ContatosService {

    private final ContatoDao dao;
    private List<Contatos> listContatos;
    private final List<ContatoDTO> resultList;

    public ContatosServiceImpl() {
        this.dao = new ContatoDaoImpl();
        this.resultList = new ArrayList();
        this.listContatos = new ArrayList();
    }

    @Override
    public List<ContatoDTO> getContatos(String user) {
        this.listContatos.clear();
        this.listContatos = this.dao.listarContatos(user);
        this.populaResultList(this.listContatos);
        return this.resultList;
    }
    
    @Override
    public ContatoDTO getContato(Integer id) {
        this.listContatos.clear();
        this.listContatos.add(this.dao.buscarContatoId(id));
        this.populaResultList(this.listContatos);
        System.out.println(this.resultList.get(0).getNome());
        return this.resultList.get(0);
    }

    @Override
    public void setContato(ContatoDTO contato) {
        if (contato.getId() == null) {
            this.dao.inserirContato(converteContato(contato));
        } else {
            if (this.dao.buscarContatoId(contato.getId()) != null) {
                this.dao.updateContato(converteContato(contato));
            } else {
                throw new WebApplicationException(500);
            }
        }
    }

    @Override
    public void deleteContato(Integer id) {
        this.dao.deletarContatoId(id);
    }

    private void populaResultList(List<Contatos> listContatos) {
        this.resultList.clear();
        ContatoDTO aux;
        for (Contatos c : listContatos) {
            aux = new ContatoDTO();
            aux.setUser(c.getUser());
            aux.setId(c.getId());
            aux.setNome(c.getNome());
            aux.setEmail(c.getEmail());
            aux.setTelefone(c.getTelefone());
            aux.setCelular(c.getCelular());
            this.resultList.add(aux);
        }
    }

    private Contatos converteContato(ContatoDTO contato) {
        Contatos c = new Contatos();
        c.setUser(contato.getUser());
        c.setId(contato.getId());
        c.setNome(contato.getNome());
        c.setEmail(contato.getEmail());
        c.setTelefone(contato.getTelefone());
        c.setCelular(contato.getCelular());
        return c;
    }

}

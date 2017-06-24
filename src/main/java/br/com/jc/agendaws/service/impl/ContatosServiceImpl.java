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
    }

    @Override
    public List<ContatoDTO> getContatos() {
        this.listContatos.clear();
        this.listContatos = this.dao.listarContatos();
        this.populaResultList(this.listContatos);
        return this.resultList;
    }

    @Override
    public void setContato(ContatoDTO contato) {
        System.out.println("CHEGOU 1");
        if (contato.getId() == null) {
            this.dao.inserirContato(converteContato(contato));
        } else {
            System.out.println("CHEGOU 2");
            if (this.dao.buscarContatoId(contato.getId()) != null) {
                this.dao.updateContato(converteContato(contato));
                System.out.println("CHEGOU 3");
            } else {
                throw new WebApplicationException(500);
            }
        }
    }

    @Override
    public ContatoDTO getContato(Integer id
    ) {
        this.listContatos.clear();
        this.listContatos.add(this.dao.buscarContatoId(id));
        this.populaResultList(listContatos);
        return this.resultList.get(0);
    }

    @Override
    public void deleteContato(Integer id
    ) {
        this.dao.deletarContatoId(id);
    }

    private void populaResultList(List<Contatos> listContatos) {
        this.resultList.clear();
        ContatoDTO aux;
        for (Contatos c : listContatos) {
            aux = new ContatoDTO();
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
        c.setId(contato.getId());
        c.setNome(contato.getNome());
        c.setEmail(contato.getEmail());
        c.setTelefone(contato.getTelefone());
        c.setCelular(contato.getCelular());
        return c;
    }

}

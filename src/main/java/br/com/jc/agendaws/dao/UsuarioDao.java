package br.com.jc.agendaws.dao;

import br.com.jc.agendaws.models.Usuario;

public interface UsuarioDao {

    Usuario getUser(String userName);
}

package br.com.jc.agendaws.service.impl;

import br.com.jc.agendaws.dao.impl.RegisterDaoImpl;
import br.com.jc.agendaws.models.Usuario;
import br.com.jc.agendaws.service.RegisterService;

public class RegisterServiceImpl implements RegisterService{
    
    private final RegisterDaoImpl dao;

    public RegisterServiceImpl() {
        this.dao = new RegisterDaoImpl();
    }
    
    @Override
    public void registrar(Usuario usuario){
        this.dao.registrar(usuario);
    }
}

package br.com.jc.agendaws.service.impl;

import br.com.jc.agendaws.dao.LoguinDao;
import br.com.jc.agendaws.dao.impl.LoguinDaoImpl;
import br.com.jc.agendaws.models.DTO.UsuarioAutenticaDTO;
import br.com.jc.agendaws.models.Usuario;
import br.com.jc.agendaws.service.LoguinService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.io.UnsupportedEncodingException;
import javax.persistence.NoResultException;

public class LoguinServiceImpl implements LoguinService {

    private final LoguinDao dao;

    public LoguinServiceImpl() {
        this.dao = new LoguinDaoImpl();
    }

    @Override
    public String loguin(UsuarioAutenticaDTO usuario) {
        Usuario usuarioRes;

        if (usuario.getUser() != null && usuario.getPass() != null) {
            try {
                usuarioRes = this.dao.buscarUser(usuario);
            } catch (NoResultException e) {
                return "false";
            }
        } else {
            return "false";
        }

        try {
            return this.gerarToken(usuarioRes);
        } catch (IllegalArgumentException | UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    public String gerarToken(Usuario u) throws IllegalArgumentException, UnsupportedEncodingException {
        Algorithm algorithm = Algorithm.HMAC256("secret");
        return JWT.create()
                .withClaim("user", u.getUsername())
                .withClaim("nome", u.getNome())
                .sign(algorithm);
    }
}

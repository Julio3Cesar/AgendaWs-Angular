/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jc.agendaws.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;

@Provider
@RequestScoped
public class TokenInterceptor implements ReaderInterceptor {

    @Override
    public Object aroundReadFrom(ReaderInterceptorContext context) throws
            WebApplicationException, IOException {
        System.out.println(context.getHeaders().toString());

        if (context.getHeaders().getFirst("referer") != null
                && context.getHeaders().getFirst("referer").contains("login")
                || context.getHeaders().getFirst("referer").contains("register")) {
            return context.proceed();
        } else {
            String token = context.getHeaders().getFirst("authorization");
            if (this.verificaToken(token)) {
                return context.proceed();
            } else {
                throw new WebApplicationException(500);
            }
        }
    }

    public boolean verificaToken(String token) {
        try {
            Algorithm algoritimo = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algoritimo).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (UnsupportedEncodingException | JWTVerificationException e) {
            System.out.println(" ------------------------------------error ao verificar Token! --------------------------------------");
            return false;
        }
    }
}

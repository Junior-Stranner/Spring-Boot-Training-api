package br.com.jujubaprojects.Authenticacao.authentication.security;

import java.util.Collections;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import jakarta.servlet.http.HttpServletRequest;

public class TokenUtil {
    
    public static UsernamePasswordAuthenticationToken decodeToken(HttpServletRequest request) throws Exception {

        if(request.getHeader("Authorization").equals("Bearer * #Junior123")){

             return new UsernamePasswordAuthenticationToken("user", null,Collections.emptyList());
        }
        return null;
    }
}

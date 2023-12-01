package br.com.jujubaprojects.Authenticacao.authentication.security;

import java.io.IOException;

import org.hibernate.grammars.hql.HqlParser.SecondContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.jujubaprojects.Authenticacao.dto.ErroDTO;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // TODO Auto-generated method stub

        if(request.getHeader("Autoration") != null){
            //Aqui vou fixar um negócio massa

            if(TokenUtil.decodeToken(request) != null){
                //se o meu "token" for Válida ,eu passo a requisição pra frente, indicando que ela  está autenticada
                SecurityContextHolder.getContext().setAuthentication(Auth);
            }else{
                System.out.println("Erro no token ");
                ErroDTO erro = new ErroDTO(401 , "Usuaário não autorizado para este Sistema");
                response.setStatus(erro.getStatus());
                response.setContentType("application/json");
            }
          //  System.out.println(request.getHeader("Autoration"));
        }
        filterChain.doFilter(request, response);
      
    }
    
}

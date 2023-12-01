package br.com.jujubaprojects.springboot.security;

import java.io.IOException;

import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyFilter extends OncePerRequestFilter{

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // TODO Auto-generated method stub

        System.out.println("DEBUG - Requisição passou pelo");

        if(request.getHeader("Authorization") != null){
        //aqui vou fixar um negócio massa
        }
         //passa a requisição para frente 
        filterChain.doFilter(request, response);
    }
    
}

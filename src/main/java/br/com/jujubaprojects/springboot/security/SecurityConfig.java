package br.com.jujubaprojects.springboot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()                      // desabelito o csrf(por que eu que vou tratar a authenticação dos usuários)
            .authorizeHttpRequests()               //agora  as rquesições http são passiveis de authorização 
            .requestMatchers(HttpMethod.GET, "users/listarTodos").permitAll()    // estou especificando quem é liberado
            .anyRequest().authenticated().and().cors();              //todos as outras URLs terão nessecidade de authenticação (e sofrerão as restrições do cors)
            
            http.addFilterBefore(new MyFilter(), UsernamePasswordAuthenticationFilter.class);


        return http.build();
        
    }
}

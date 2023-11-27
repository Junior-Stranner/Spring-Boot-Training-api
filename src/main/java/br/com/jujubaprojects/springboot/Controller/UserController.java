package br.com.jujubaprojects.springboot.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jujubaprojects.springboot.Model.User;

@RestController
@RequestMapping("/users")
public class UserController {

    private List<User> users = new ArrayList<>();
    
    @GetMapping("/{id}")
    public User user(@PathVariable("id") long id){
        System.out.println("O id é "+id);
     
       Optional <User> userFind =  users.stream().filter(user -> user.getId() == id).findFirst();

       if (userFind.isPresent()) {
        System.out.println("Usuário encontrado: " + userFind.get());
        return userFind.get();
    } else {
        System.out.println("Usuário não encontrado para o ID: " + id);
        return null;
    }
    }

     @PostMapping("/add")
    public User user(@RequestBody User user){
        users.add(user);
        return user;
    }

     @GetMapping("/listarTodos")
    public List<User> list(){
     //   users.add(user);
        return users;
   }
}

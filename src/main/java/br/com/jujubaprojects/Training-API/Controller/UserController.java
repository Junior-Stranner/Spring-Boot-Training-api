package br.com.jujubaprojects.Authenticacao.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jujubaprojects.Authenticacao.Model.User;
import br.com.jujubaprojects.Authenticacao.Repository.UserRepository;
import br.com.jujubaprojects.Authenticacao.Service.CreateRoleUserService;
import br.com.jujubaprojects.Authenticacao.Service.CreateUserService;
import br.com.jujubaprojects.Authenticacao.dto.CreateUserRoleDTO;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

     @Autowired
    CreateUserService createUserService;

     @Autowired
    CreateRoleUserService createRoleUserService;

    private List<User> users = new ArrayList<>();
    
    @GetMapping("/{id}")
    public User user(@PathVariable("id") long id){
        System.out.println("O id é "+id);
     
       Optional <User> userFind =  this.userRepository.findById(id);

       if (userFind.isPresent()) {
        System.out.println("Usuário encontrado: " + userFind.get());
        return userFind.get();
    } else {
        System.out.println("Usuário não encontrado para o ID: " + id);
        return null;
    }
    }

     @PostMapping("/create")
    public User create(@RequestBody User user){
        return createUserService.execute(user);
    }

      @PostMapping("/role")
    public User role(@RequestBody CreateUserRoleDTO createUserRoleDTO){
        return createRoleUserService.execute(createUserRoleDTO);
    }

     @GetMapping("/listarTodos")
    public List<User> list(){
     //   List<User> users = this.userRepository.findAll();
        return this.userRepository.findAll();
   }

    @GetMapping("/listMoreThan/{id}")
    public List<User> listMoreThan(@PathVariable("id") long id){
     //   List<User> users =this.userRepository.findAllMoreThan(id);
        return this.userRepository.findAllMoreThan(id);
   }


    @GetMapping("/greaterThan/{id}")
    public List<User> greaterThan(@PathVariable("id") long id){
     //   List<User> users =this.userRepository.findAllMoreThan(id);
        return this.userRepository.findByIdGreaterThan(id);
   }
   
    @GetMapping("/findByName/{name}")
    public List<User> findByName(@PathVariable("name") String name){
     //   List<User> users =this.userRepository.findAllMoreThan(id);
        return this.userRepository.findByNameIgnoreCase(name);
   }
   
}

package br.com.jujubaprojects.springboot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jujubaprojects.springboot.Model.User;
import br.com.jujubaprojects.springboot.Repository.UserRepository;

@Service
public class CreateUserService {

  @Autowired
  UserRepository userRepository;

  public User execute(User user) {

    User existsUser = userRepository.findByUsername(user.getUsername());

    if (existsUser != null) {
      throw new Error("User already exists!");

    }else{

    User createdUser = userRepository.save(user);
    
    return createdUser;
   }

  }

}
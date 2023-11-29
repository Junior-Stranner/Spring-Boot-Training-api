package br.com.jujubaprojects.Authenticacao.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.jujubaprojects.Authenticacao.Model.User;
import br.com.jujubaprojects.Authenticacao.Repository.UserRepository;

@Service
public class CreateUserService {

  @Autowired
  UserRepository userRepository;

  private BCryptPasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }

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
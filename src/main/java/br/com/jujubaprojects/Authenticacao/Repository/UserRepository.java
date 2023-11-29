package br.com.jujubaprojects.Authenticacao.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.jujubaprojects.Authenticacao.Model.User;

public interface UserRepository extends JpaRepository <User, Long>{
    
    @Query("Select u from User u where u.id > :id")
    List<User> findAllMoreThan(@Param("id") long id);

    public List<User> findByIdGreaterThan(long id);

    public List<User> findByNameIgnoreCase(String name);

    User findByUsername(String username);
}

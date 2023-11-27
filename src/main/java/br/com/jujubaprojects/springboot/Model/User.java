package br.com.jujubaprojects.springboot.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    
    private long id;
    private String name;
    private String username;
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", username=" + username + "]";
    }

}



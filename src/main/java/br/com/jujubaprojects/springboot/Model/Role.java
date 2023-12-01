package br.com.jujubaprojects.springboot.Model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role {

  @Id
  @GeneratedValue
  private UUID id;
  private String name;

  public Role(UUID id) {
    this.id = id;
  }

}

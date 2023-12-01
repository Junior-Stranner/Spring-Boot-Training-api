package br.com.jujubaprojects.springboot.Model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {

  @Id
  @GeneratedValue
  private UUID id;
  private String name;

  private String description;

  private String sku;

}

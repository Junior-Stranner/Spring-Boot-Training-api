package br.com.jujubaprojects.springboot.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jujubaprojects.springboot.Model.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {

}

package br.com.jujubaprojects.Authenticacao.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jujubaprojects.Authenticacao.Model.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {

}

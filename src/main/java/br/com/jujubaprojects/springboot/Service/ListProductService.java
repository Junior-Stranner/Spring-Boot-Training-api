package br.com.jujubaprojects.springboot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jujubaprojects.springboot.Model.Product;
import br.com.jujubaprojects.springboot.Repository.ProductRepository;

@Service
public class ListProductService {

  @Autowired
  ProductRepository productRepository;

  public List<Product> listAll() {
    return productRepository.findAll();
  }
}

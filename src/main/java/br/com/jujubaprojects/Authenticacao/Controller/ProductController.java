package br.com.jujubaprojects.Authenticacao.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jujubaprojects.Authenticacao.Model.Product;
import br.com.jujubaprojects.Authenticacao.Service.ListProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

  @Autowired
  ListProductService listProductService;

  @GetMapping
  public List<Product> list() {
    return listProductService.listAll();
  }

}

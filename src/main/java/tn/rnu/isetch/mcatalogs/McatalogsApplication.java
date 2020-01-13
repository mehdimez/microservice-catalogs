package tn.rnu.isetch.mcatalogs;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tn.rnu.isetch.mcatalogs.entity.Product;
import tn.rnu.isetch.mcatalogs.repository.ProductRepository;
import tn.rnu.isetch.mcatalogs.service.ProductService;
import tn.rnu.isetch.mcatalogs.service.ProductServiceImpl;

import javax.xml.ws.Service;

@SpringBootApplication
public class McatalogsApplication implements CommandLineRunner {

	@Autowired
	ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(McatalogsApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		productRepository.deleteAll();

	Product	p1 = new Product() ;
		Product	p2 = new Product() ;
		Product	p3 = new Product() ;
		Product	p4 = new Product() ;

		Product	look = new Product() ;
		Product	look1 = new Product() ;
		look.setName("classic");
		look1.setName("chic");

		p2.setLook(look);
		p4.setLook(look);
productRepository.save(look);
		productRepository.save(p2);
		productRepository.save(p3);
		productRepository.save(p4);



	}
}

package pe.isil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.isil.model.Product;
import pe.isil.repository.JdbcProductRepository;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    JdbcProductRepository jdbcProductRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        jdbcProductRepository.create(new Product(null,"Tornillo", 12.0));
        List<Product> products = jdbcProductRepository.findAll();
        listAll();

        if(!products.isEmpty()){
            Product product = products.get(0);
            product.setName("Madera comun");
            product.setPrice(25.0);

            //UPDATE
            jdbcProductRepository.update(product);
            listAll();

            //DELETE
            jdbcProductRepository.delete(product);
            listAll();

        }

    }

    private void listAll(){
        System.out.println();
        List<Product> products = jdbcProductRepository.findAll();
        for (Product p : products){
            System.out.println("->" + p);
        }
    }

}

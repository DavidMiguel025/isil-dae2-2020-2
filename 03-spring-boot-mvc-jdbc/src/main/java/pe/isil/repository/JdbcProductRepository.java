package pe.isil.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.isil.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcProductRepository implements ProductRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Product product) {
        final String SQL = "INSERT INTO product(name, price) VALUES (?,?)";
        jdbcTemplate.update(SQL, product.getName(), product.getPrice() );
    }

    @Override
    public void update(Product product) {
        final String SQL = "UPDATE product SET name=?, price=? WHERE id=?";
        jdbcTemplate.update(SQL, product.getName(), product.getPrice(), product.getId() );
    }

    @Override
    public void delete(Product product) {
        final String SQL = "DELETE product WHERE id=?";
        jdbcTemplate.update(SQL, product.getId() );
    }

    @Override
    public List<Product> findAll() {
        final String SQL = "SELECT * FROM product";
        List<Product> products = jdbcTemplate.query(SQL, JdbcProductRepository::ProductRowMapper);
        return products;
    }

    private static Product ProductRowMapper(ResultSet resultSet, int i) throws SQLException {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        double price = resultSet.getDouble("price");
        return new Product(id, name, price);
    }

    @Override
    public Product findById(Long id) {
        final String SQL = "SELECT * FROM product WHERE id=?";
        Product product = jdbcTemplate.queryForObject(SQL,
                new Object[]{id},
                JdbcProductRepository::ProductRowMapper);
        return product;
    }
}

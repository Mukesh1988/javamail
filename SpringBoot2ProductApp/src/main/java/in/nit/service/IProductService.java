package in.nit.service;

import java.util.List;

import in.nit.model.Product;

public interface IProductService {

	Integer saveProduct(Product p);
	void updateProduct(Product p);
	void deleteProduct(Integer id);
	Product getOneProduct(Integer id);
	List<Product> getAllProducts();
	
}

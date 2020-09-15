package in.nit.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nit.model.Product;
import in.nit.repo.ProductRepository;
import in.nit.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	private ProductRepository repo;

	public Integer saveProduct(Product p) {
		return repo.save(p).getProdId();
	}

	public void updateProduct(Product p) {
		repo.save(p);
	}

	public void deleteProduct(Integer id) {
		repo.deleteById(id);
	}

	public Product getOneProduct(Integer id) {
		Optional<Product> opt = repo.findById(id);
		if (opt.isPresent())
			return opt.get();
		return null;
	}

	public List<Product> getAllProducts() {
		return repo.findAll();
	}

}

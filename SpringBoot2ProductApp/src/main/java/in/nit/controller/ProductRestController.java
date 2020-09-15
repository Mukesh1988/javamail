package in.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nit.model.Product;
import in.nit.service.IProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductRestController {
	@Autowired
	private IProductService service;
	
	//1. save product
	@PostMapping("/insert")
	public ResponseEntity<String> saveProduct(
			@RequestBody Product product)
	{
		Integer id=service.saveProduct(product);
		return ResponseEntity.ok("Product '"+id+"' saved");
		//return new ResponseEntity<String>("Product '"+id+"' saved", HttpStatus.OK);
	}
	
	//2. get All products
	@GetMapping("/all")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> list=service.getAllProducts();
		return ResponseEntity.ok(list);
	}
	
	//3. get one product based on Id(path param)
	@GetMapping("/one/{id}")
	public ResponseEntity<Product> getOneProduct(
			@PathVariable("id")Integer id)
	{
		Product p=service.getOneProduct(id);
		return ResponseEntity.ok(p);
	}
	
	//4. remove one product
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> removeProduct(
			@PathVariable("id")Integer id)
	{
		service.deleteProduct(id);
		return ResponseEntity.ok("Product '"+id+"' deleted");
	}
	
	//5. update product
	@PutMapping("/modify")
	public ResponseEntity<String> updateProduct(
			@RequestBody Product product)
	{
		service.updateProduct(product);
		return ResponseEntity.ok("Product '"+product.getProdId()+"' Updated");
	}
}




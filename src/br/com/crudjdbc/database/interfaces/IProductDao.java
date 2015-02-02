package br.com.crudjdbc.database.interfaces;

import java.util.List;

import br.com.crudjdbc.database.entities.ProductEntity;

public interface IProductDao {
	
	public void insert(ProductEntity product);
	
	public List<ProductEntity> findALl();
	
	public ProductEntity findByID(Long id);

	public void update(ProductEntity product);

	public void delete(ProductEntity product);
	
}

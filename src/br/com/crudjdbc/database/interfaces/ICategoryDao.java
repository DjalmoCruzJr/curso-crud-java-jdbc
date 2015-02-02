package br.com.crudjdbc.database.interfaces;

import java.util.List;

import br.com.crudjdbc.database.entities.CategoryEntity;

public interface ICategoryDao {
	
	public void insert(CategoryEntity category);
	
	public List<CategoryEntity> findALl();
	
	public CategoryEntity findByID(Long id);

	public void update(CategoryEntity category);

	public void delete(CategoryEntity category);
	
}

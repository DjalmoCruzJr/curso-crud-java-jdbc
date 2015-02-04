package br.com.crudjdbc.test.daos;

import org.apache.log4j.Logger;

import br.com.crudjdbc.database.daos.CategoryDao;
import br.com.crudjdbc.database.entities.CategoryEntity;
import br.com.crudjdbc.database.interfaces.ICategoryDao;


public abstract class TestCategoryDao {

	private static final Logger logger;

	private static ICategoryDao categoryDao;
	
	static {
		logger = Logger.getLogger(TestCategoryDao.class);
		categoryDao = new CategoryDao();
	}
	
	public static void testInsert() {
		logger.debug(String.format("Testing %s insert method.", CategoryDao.class));
		CategoryEntity category = new CategoryEntity();
		category.setName("CATEGORY 1");		
		categoryDao.insert(category);
	}
	
	public static void testFindAll() {
		logger.debug(String.format("Testing %s findAll method.", CategoryDao.class));
		logger.debug(categoryDao.findALl());
	}
	
	public static void testFindById() {
		logger.debug(String.format("Testing %s findById method.", CategoryDao.class));
		CategoryEntity category= categoryDao.findByID(1L);
		logger.debug(category);
	}
	
	public static void testUpdate() {
		logger.debug(String.format("Testing %s update method.", CategoryDao.class));
		CategoryEntity category = new CategoryEntity();
		category.setId(1L);;
		category.setName("CATEGORY 1 UPDATED");
		categoryDao.update(category);
	}
	
	public static void testDelete() {
		logger.debug(String.format("Testing %s delete method.", CategoryDao.class));
		CategoryEntity category = new CategoryEntity();
		category.setId(1L);;
		categoryDao.delete(category);
	}

	/* Test Main Method */
	public static void main(String[] args) {
//		testInsert();
//		testFindAll();
//		testFindById();
//		testUpdate();
//		testDelete();
	}

}

package br.com.crudjdbc.database.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.crudjdbc.database.entities.CategoryEntity;
import br.com.crudjdbc.database.factories.ConnectionFactory;
import br.com.crudjdbc.database.interfaces.ICategoryDao;

public class CategoryDao implements ICategoryDao {
	
	private final Logger logger;
	
	private static final String INSERT_QUERY = "INSERT INTO tb_categories(category_name) VALUES(?)";
	private static final String FIND_ALl_QUERY = "SELECT * FROM tb_categories";
	private static final String FIND_BY_ID_QUERY = "SELECT * FROM tb_categories WHERE category_id = ?";
	private static final String UPDATE_QUERY = "UPDATE tb_categories SET category_name = ? WHERE category_id = ?";
	private static final String DELETE_QUERY = "DELETE FROM tb_categories WHERE category_id = ?";
	
	public CategoryDao() {
		this.logger = Logger.getLogger(getClass());
	}
	
	@Override
	public void insert(CategoryEntity category) {
		Connection conn;
		PreparedStatement ps;
		try {
			logger.info("Saving record...");
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(INSERT_QUERY);
			ps.setString(1, category.getName().trim().toUpperCase());
			ps.executeUpdate();
			logger.info(String.format("QUERY: %s", INSERT_QUERY));
			logger.info("Record successfully saved.");
		} catch(Exception e) {
			logger.error(e);
		}
	}
	
	@Override
	public List<CategoryEntity> findALl() {
		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		List<CategoryEntity> categories = null;
		try {
			logger.info("Searching records...");
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(FIND_ALl_QUERY);
			rs = ps.executeQuery();
			logger.info(String.format("QUERY: %s", FIND_ALl_QUERY));
			if(rs.first())  {
				categories = new ArrayList<CategoryEntity>();
				do {
					CategoryEntity category = new CategoryEntity();
					category.setId(rs.getLong("category_id"));
					category.setName(rs.getString("category_name"));
					categories.add(category);
				} while(rs.next());
			}
			logger.info("Search successfully done.");
		} catch(Exception e) {
			logger.error(e);
		}
		return categories;
	}
	
	@Override
	public CategoryEntity findByID(Long id) {
		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		CategoryEntity category = null;
		try {
			logger.info("Searching records...");
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(FIND_BY_ID_QUERY);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			logger.info(String.format("QUERY: %s", FIND_BY_ID_QUERY));
			if(rs.first())  {
				category = new CategoryEntity();
				category.setId(rs.getLong("category_id"));
				category.setName(rs.getString("category_name"));
			}
			logger.info("Search successfully done.");
		} catch(Exception e) {
			logger.error(e);
		}
		return category;
	}
	
	@Override
	public void update(CategoryEntity category) {
		Connection conn;
		PreparedStatement ps;
		try {
			logger.info("Updating record...");
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(UPDATE_QUERY);
			ps.setString(1, category.getName().trim().toUpperCase());
			ps.setLong(2, category.getId());
			ps.executeUpdate();
			logger.info(String.format("QUERY: %s", UPDATE_QUERY));
			logger.info("Record successfully updated.");
		} catch(Exception e) {
			logger.error(e);
		}
	}
	
	@Override
	public void delete(CategoryEntity category) {
		Connection conn;
		PreparedStatement ps;
		try {
			logger.info("Deleting record...");
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(DELETE_QUERY);
			ps.setLong(1, category.getId());
			ps.executeUpdate();
			logger.info(String.format("QUERY: %s", DELETE_QUERY));
			logger.info("Record successfully deleted.");
		} catch(Exception e) {
			logger.error(e);
		}
	}

}

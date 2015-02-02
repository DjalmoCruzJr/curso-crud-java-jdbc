package br.com.crudjdbc.database.entities;

public class ProductEntity extends BaseEntity {

	private static final long serialVersionUID = 8578662769938479960L;
	
	private Long id;
	private String name;
	private String description;
	private CategoryEntity category;
	
	public ProductEntity() {
	}

	public ProductEntity(Long id, String name, String description, CategoryEntity category) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

}

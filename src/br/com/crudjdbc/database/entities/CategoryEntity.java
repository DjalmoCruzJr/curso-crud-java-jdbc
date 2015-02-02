package br.com.crudjdbc.database.entities;

public class CategoryEntity extends BaseEntity {

	private static final long serialVersionUID = 7085125015117881681L;
	
	private Long id;
	private String name;
	
	public CategoryEntity() {
	}

	public CategoryEntity(Long id, String name) {
		this.id = id;
		this.name = name;
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

}

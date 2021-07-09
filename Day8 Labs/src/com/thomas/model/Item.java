package com.thomas.model;

public class Item {
	private int id;
	private String description;
	
	public Item() {}
	
	public Item(int id, String description) {
		super();
		this.setId(id);
		this.setDescription(description);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", description=" + description + "]";
	}
}

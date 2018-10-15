package com.eshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="phones")
public class Phones {
	
	@Id
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private String price;
	
    @Column(name="color")
	private String color;
	
	@Column(name="photo")
	private String photo;
	
	@Column(name="brandname")
	private String brandname;
	
	@Column(name="imagename")
	private String imageName;
	
	
	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

public void setColor(String color) {
		this.color = color;
}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}


	
	

}

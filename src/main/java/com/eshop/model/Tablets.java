package com.eshop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tablets")
public class Tablets implements Serializable {
	
	@Id
	private int id;
	@Column(name="tabletname")
	private String Tabletname;
	@Column(name="tabletprice")
	private String tabletprice;
	@Column(name="installmentplan")
	private String installmentplan;
	@Column(name="installmentduration")
	private String installmentduration;
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
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	@Column(name="color")
    private String color;
	@Column(name="photo")
	private String photo;
	@Column(name="capacity")
	private String capacity;
	
	@Column(name = "imagename")
	private String imagename;
	
	
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTabletname() {
		return Tabletname;
	}
	public void setTabletname(String tabletname) {
		Tabletname = tabletname;
	}
	public String getTabletprice() {
		return tabletprice;
	}
	public void setTabletprice(String tabletprice) {
		this.tabletprice = tabletprice;
	}
	public String getInstallmentplan() {
		return installmentplan;
	}
	public void setInstallmentplan(String installmentplan) {
		this.installmentplan = installmentplan;
	}

	public String getInstallmentduration() {
		return installmentduration;
	}
	public void setInstallmentduration(String installmentduration) {
		this.installmentduration = installmentduration;
	}
	

}

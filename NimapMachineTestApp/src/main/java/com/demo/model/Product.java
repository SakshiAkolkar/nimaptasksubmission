package com.demo.model;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Product 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
    private String pnameString;
    @Column(columnDefinition = "double(5,2)")
    private double pprice;
    @ManyToOne
    private Category category;
	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}
	/**
	 * @return the pid
	 */
	public int getPid() {
		return pid;
	}
	/**
	 * @param pid the pid to set
	 */
	public void setPid(int pid) {
		this.pid = pid;
	}
	/**
	 * @return the pnameString
	 */
	public String getPnameString() {
		return pnameString;
	}
	/**
	 * @param pnameString the pnameString to set
	 */
	public void setPnameString(String pnameString) {
		this.pnameString = pnameString;
	}
	/**
	 * @return the pprice
	 */
	public double getPprice() {
		return pprice;
	}
	/**
	 * @param pprice the pprice to set
	 */
	public void setPprice(double pprice) {
		this.pprice = pprice;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pnameString=" + pnameString + ", pprice=" + pprice + "]";
	}
    
    

}


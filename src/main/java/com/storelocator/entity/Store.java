package com.storelocator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * @author 
 * JPA Entity class to represent a store
 *
 */
@Entity
@Table(name = "STORES")
public class Store {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STORE_ID")
	private Long storeId;
	@Column(name = "STORE_LOCATION")
	@NotNull
	@Length(max = 100)
	private String storeLocation;
	@Column(name = "STORE_NAME")
	@NotNull
	@Length(max = 100)
	private String storeName;

	@Column(name = "STORE_DESCRIPTION")
	@Length(max = 1000)
	private String storeDescription;

	@Column(name = "ZIP_CODE")
	@NotNull
	private long zipCode;

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreDescription() {
		return storeDescription;
	}

	public void setStoreDescription(String storeDescription) {
		this.storeDescription = storeDescription;
	}

	public long getZipCode() {
		return zipCode;
	}

	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}

	public String getStoreLocation() {
		return storeLocation;
	}

	public void setStoreLocation(String storeLocation) {
		this.storeLocation = storeLocation;
	}

}

package com.storelocator.repository;

import java.util.List;

import com.storelocator.entity.Store;

/**
 * @author 
 * Store Repository Interface
 */
public interface StoreRepository{

	/**
	 * Get stores based on zipcode from database
	 * @param zipCode
	 * @return List of stores
	 */
	public List<Store> findByZipCode(long zipCode);
	/**
	 * Save a store to database
	 * @param store
	 * @return
	 */
	public Store saveStore(Store store);

}

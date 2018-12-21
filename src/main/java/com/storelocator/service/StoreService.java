package com.storelocator.service;

import java.util.List;

import com.storelocator.entity.Store;

/**
 * @author 
 * Store Service Interface
 */
public interface StoreService {
	/**
	 * Get stores based on zipcode from repository
	 * @param zipCode
	 * @return List of stores
	 */
	public List<Store> findByZipCode(long zipCode);
	/**
	 * Save a store to repository
	 * @param store
	 * @return
	 */
	public Store saveStore(Store store);
}

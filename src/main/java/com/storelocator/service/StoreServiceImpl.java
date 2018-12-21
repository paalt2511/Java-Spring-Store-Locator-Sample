package com.storelocator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storelocator.entity.Store;
import com.storelocator.repository.StoreRepository;
/**
 * @author 
 * Store Service Implementation class
 */
@Service
public class StoreServiceImpl implements StoreService{

	@Autowired
	private StoreRepository storeRepository;

	/* (non-Javadoc)
	 * @see com.storelocator.service.StoreService#findByZipCode(long)
	 */
	@Override
	public List<Store> findByZipCode(long zipCode) {
		// TODO Auto-generated method stub
		return this.storeRepository.findByZipCode(zipCode);
	}

	/* (non-Javadoc)
	 * @see com.storelocator.service.StoreService#saveStore(com.storelocator.entity.Store)
	 */
	@Override
	public Store saveStore(Store store) {
		// TODO Auto-generated method stub
		return this.storeRepository.saveStore(store);
	}
}

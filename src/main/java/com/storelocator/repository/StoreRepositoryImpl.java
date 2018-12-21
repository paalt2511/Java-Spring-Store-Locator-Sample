package com.storelocator.repository;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.storelocator.entity.Store;
/**
 * @author 
 * Store Repository Implementation Class
 */
@Repository
@Transactional
public class StoreRepositoryImpl implements StoreRepository {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 *  (non-Javadoc)
	 * @see com.storelocator.repository.StoreRepository#findByZipCode(long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Store> findByZipCode(long zipCode) {
		// TODO Auto-generated method stub
		/* 
		 * Store Search Logic based on zip code		 
		 * Get the stores whose zipcode match the provided zipcode via one-way like search
		 * 
		 * */
		Query queryObj = this.sessionFactory.getCurrentSession().createQuery("from Store where cast(zipCode as string) like :zipCode ");
		queryObj.setParameter("zipCode", String.valueOf(zipCode)+"%");
		return queryObj.list();
	}

	/* (non-Javadoc)
	 * @see com.storelocator.repository.StoreRepository#saveStore(com.storelocator.entity.Store)
	 */
	@Override
	public Store saveStore(Store store) {
		// TODO Auto-generated method stub
		Serializable id = this.sessionFactory.getCurrentSession().save(store);
		if (id != null) {
			store.setStoreId((Long) id);
		} else {
			store = null;
		}
		return store;
	}

}

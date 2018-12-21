package com.storelocator.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.storelocator.entity.Store;
import com.storelocator.service.StoreService;
/**
 * @author  
 * 		   This class is responsible for inserting sample data at the start of the application
 * 		   It reads data from a file stores.data placed in resources folder and inserts it into 
 * 		   database.
 */
@Component
public class DatabaseInitializer {

	/**
	 * Create data when the instance of DatabaseInitializer is created by spring
	 * @param storeService
	 * @throws IOException
	 */
	@Autowired
	public DatabaseInitializer(StoreService storeService) throws IOException {

		/* Read Data.txt and create Dummy data */
		ClassPathResource resource = new ClassPathResource("stores.txt");
		InputStream stream = resource.getInputStream();
		Store store = null;
		List<String> storesData = readTextFile(stream);
		String[] storeData = null;
		for (String data : storesData) {
			store = new Store();
			storeData = data.split(",");
			store.setStoreLocation(storeData[2]);
			store.setStoreName(storeData[0]);
			store.setStoreDescription(storeData[0]);
			store.setZipCode(Long.valueOf(storeData[1]));
			storeService.saveStore(store);
		}

	}
	
	
	/*
	 * Read the file 
	 * @param file
	 * @return List of lines read from file
	 */
	private List<String> readTextFile(InputStream stream) {
		List<String> lines = new ArrayList<String>();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(stream));
			String str;
			while ((str = in.readLine()) != null) {
				lines.add(str);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
}

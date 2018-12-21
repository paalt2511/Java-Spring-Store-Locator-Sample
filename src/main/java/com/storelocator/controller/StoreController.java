package com.storelocator.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.storelocator.entity.Store;
import com.storelocator.service.StoreService;

/**
 * @author 
 * Controller class to expose the Store Rest API
 *
 */
@RestController
@RequestMapping("/store")
public class StoreController {

	@Autowired
	private StoreService storeService;

	/**
	 * Get the nearby stores based on zipcode
	 * @param zipCode
	 * @return List of stores nearby 
	 * @throws Exception
	 */
	@ApiOperation(value = "/", nickname = "Search Stores by Zip Code", notes = "This API will search based on Zip Code(Supports wild card search also e.g Try Search with 5).")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = List.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Server Error") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "zipCode", value = "Zip Code to be searched (Supports wild card search also)", required = true, dataType = "string", paramType = "path", defaultValue = "5") })
	@RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "{zipCode}")
	@ResponseBody
	public List<Store> getStores(@PathVariable String zipCode) throws Exception {
	
		if (zipCode != null && !zipCode.isEmpty()) {
			
			return storeService.findByZipCode(Long.valueOf(zipCode));
		}
		return null;
	}

	/**
	 * Save a store
	 * @param store
	 * @return Saved instance of store
	 * @throws Exception
	 */
	@ApiOperation(value = "", nickname = "Save a Store", notes = "Create a new store in the system")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Store.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Server Error") })
	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Store saveStore(@RequestBody Store store) throws Exception {
		if (store != null) {
		
			return storeService.saveStore(store);
		}
		else{
			return null;
		}
	}
}

package com.capgemini.drinksanddelight.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.drinksanddelight.entities.Distributordetails;
import com.capgemini.drinksanddelight.entities.ProductorderDetails;
import com.capgemini.drinksanddelight.exception.OrderIdNotFoundException;
import com.capgemini.drinksanddelight.service.DistributorDetailsService;
import com.capgemini.drinksanddelight.service.TrackOrderService;
import com.capgemini.drinksanddelight.service.UpdateTrackOrderService;






@RestController
@RequestMapping("/")
public class ProjectController {
	
	@Autowired
	DistributorDetailsService serviceObj;
	
	@Autowired
	TrackOrderService trackObj;
	
	
	@Autowired
	UpdateTrackOrderService updateObj;
	
	
	
	
	
	@GetMapping("/getDistributorDetails")
    public ResponseEntity<List<Distributordetails>> getProductList() {
			List<Distributordetails> list = serviceObj.reterive();
			System.out.println("hi");
			return new ResponseEntity<List<Distributordetails>>(list,HttpStatus.OK);
	}
	
	
	
	
	@GetMapping("/trackOrder/{id}")
    public ResponseEntity<ProductorderDetails> trackOrder(@PathVariable("id") String id) throws OrderIdNotFoundException {
			ProductorderDetails object = trackObj.trackOrder(id);
			
			
			
			return new ResponseEntity<ProductorderDetails>(object,HttpStatus.OK);
	}
	
	
	
	@PutMapping("/update/{orderId}/{location}/{date}")
	
	public  boolean updateTrackOrder(@PathVariable("orderId") String id,@PathVariable("location")String location,@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws OrderIdNotFoundException
	{
		
		
		return updateObj.updateTrackOrder(id, location, date);
		
		
		
	}
	 
	
	
	

}

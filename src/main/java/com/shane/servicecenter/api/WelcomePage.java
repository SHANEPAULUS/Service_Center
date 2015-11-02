package com.shane.servicecenter.api;


import com.shane.servicecenter.domain.ContactDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.shane.servicecenter.domain.Station;

@RestController
@RequestMapping("/")
public class WelcomePage{

	@RequestMapping(method = RequestMethod.GET)
	public Station getStation(){
		ContactDetails address=new ContactDetails
		.Builder("0611092633")
		//.email("legends@gmail.com")
		.address("5 BarkleyRoad, Kimberley")
		.build();

		Station station=new Station
		.Builder("Legends Service")
		.address(address)
		.build();
		return station;
	}
}

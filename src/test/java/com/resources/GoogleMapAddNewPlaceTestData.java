package com.resources;

import java.util.ArrayList;
import java.util.List;

import com.pojo.classes.GoogleMapAddNewPlace;
import com.pojo.classes.GoogleMapNewPlaceDetails;

public class GoogleMapAddNewPlaceTestData {

	public GoogleMapAddNewPlace addNewPlaceRequestPayload(String placeName, String placeLanguage, String placeAddress) {
		GoogleMapAddNewPlace addMap=new GoogleMapAddNewPlace();
		addMap.setAccuracy(100);
		addMap.setAddress(placeAddress);
		addMap.setLanguage(placeLanguage);
		addMap.setName(placeName);
		addMap.setPhone_number("9923580883");
		addMap.setWebsite("www.ashok.com");
		
		List<String> types=new ArrayList<String>();
		types.add("Home");
		types.add("House");
		types.add("Resident");
		addMap.setTypes(types);
		
		GoogleMapNewPlaceDetails loc=new GoogleMapNewPlaceDetails();
		loc.setLat(-12.077);
		loc.setLng(35.2747);
		addMap.setLocation(loc);
		
		return addMap;
	}
}

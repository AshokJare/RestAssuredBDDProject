Feature: Validate new place is added on google map

Scenario Outline: Verify that new place is added on google map using AddPlaceAPI
								Given User having request payload with "<placeName>" "<placeLanguage>" "<placeAddress>"
								When User requests "AddPlaceAPI" API with "POST" Http request
								Then Validate status code is "200"
								And Validate response having jsonPath key "status" with value as "OK"
								And Validate response having jsonPath key "scope" with value as "APP"
Examples:
	|placeName						| placeLanguage	|	placeAddress	|
	|Jarewadi School		| India									|	Jarewadi					|
	|Beed School					| India									|	Beed								|
	|Jarewadi Temple		| India									|	Jarewadi					|
	
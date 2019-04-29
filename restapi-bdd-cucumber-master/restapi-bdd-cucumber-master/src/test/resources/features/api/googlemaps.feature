@sanity
Feature: Verify Googlemap and Reverse GeocodingAPI of Google 

Scenario: Verify Google Geocoding API with Valid data 
	Given The user have proper API key 
	And Have valid location address as "-33.8670522,151.1957362"
  When The user sents GET request to google Geocoding API with API key 
	#Then API should return status as 200 
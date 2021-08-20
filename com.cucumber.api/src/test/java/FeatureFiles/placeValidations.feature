Feature: Validating post API

   
	Scenario Outline: Verify whether the place is successfulyy added using AddPlaceAPI
		Given Add the place payload "<Name>" "<Language>"
		When user calls the 'AddPlaceAPI'  payload with "Post" http request
		Then the API got Success with Status code 200
		And 'status' in response body is 'ok'
		And  verify place_id created maps to "<Name>" using "GetPlaceAPI"

	Examples:
  	| Name | Language |
  	| Steve | English |
  	| Nandini | Telugu |
  	
   
  	Scenario: Verify delete place fucntionality
  	
  	Given Deleteplace payload
  	When user calls the 'DeletePlaceAPI'  payload with "Post" http request
	Then the API got Success with Status code 200
	And 'status' in response body is 'ok'
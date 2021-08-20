package StepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {


	 public void beforeScenario() throws IOException
	 {
	
		 
		 StepDefinitions sd = new StepDefinitions();
		 if(sd.place_id==null)
		 {
		 sd.add_the_place_payload("sampath", "india");
		 sd.user_calls_the_addplaceapi_payload_with_post_http_request("AddPlaceAPI", "POST");
		 sd.verify_place_id_created_maps_to_using("sampath",  "getPlaceAPI");
		 
	 }
	 }
}

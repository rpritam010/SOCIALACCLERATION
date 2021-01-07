/**
 * @author Pritam Raj
 *
 * 07-Dec-2020
socialdemoSocialAccleration
 */

package com.socialdemo.socialdemo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialdemo.socialdemo.dto.EngineerWorkDTO;
import com.socialdemo.socialdemo.dto.FaceTimeResponseDTO;
import com.socialdemo.socialdemo.dto.ReviewDTO;
import com.socialdemo.socialdemo.dto.StatusResponseDTO;
import com.socialdemo.socialdemo.entity.EngineerDetails;
import com.socialdemo.socialdemo.entity.EngineerPrefrence;
import com.socialdemo.socialdemo.entity.Profile;
import com.socialdemo.socialdemo.entity.Review;
import com.socialdemo.socialdemo.entity.Status;
import com.socialdemo.socialdemo.repository.EngineerDetailsRepository;
import com.socialdemo.socialdemo.repository.ProfileRepository;
import com.socialdemo.socialdemo.repository.StatusRepository;
import com.socialdemo.socialdemo.service.EngineerService;

@RestController
public class EngineerController {

	@Autowired
	private EngineerService engineerService;

	RestTemplate restTemplate = new RestTemplate();

	@GetMapping("/findAllOrders/techcode/{techcode}")
	public List<EngineerDetails> retriveEngineerDetails(@PathVariable String techcode) {
		return engineerService.getEngineer(techcode);
	}

	@GetMapping("/profile/TechCode/{TechCode}")
	public Profile getEngineerDetails(@PathVariable String TechCode) {
		return engineerService.getProfile(TechCode);
	}

	@Autowired
	private StatusRepository statusRepository;

	@GetMapping("/getStatus")
	public List<Status> get() {
		return statusRepository.findAll();
	}

//	@PatchMapping(value = "/Status/{techCode}")
//	public void updateStatus(@PathVariable("techCode") String techCode) {
//		engineerService.updateStatus(techCode);
//
//	}

	@PatchMapping(value = "/status/")
	public void updateStatus(@RequestBody StatusResponseDTO statusResponseDTO) {
		engineerService.updateStatus(statusResponseDTO);
	}

	@PatchMapping(value = "/faceTimeResponseDTO/")
	public void updateStatus(@RequestBody FaceTimeResponseDTO faceTimeResponseDTO) {
		engineerService.updateFaceTime(faceTimeResponseDTO);
	}

	@PatchMapping(value = "/token/{techCode}/{deviceToken}")
	public void updateDeviceToken(@PathVariable("techCode") String techCode,
			@PathVariable("deviceToken") String deviceToken) {
		engineerService.updateDeviceToken(techCode, deviceToken);

	}

	@RequestMapping(value = "/sendNotification", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> sendNotification(@RequestBody String jsonParam) throws Exception {

//				List<String> skill = new ArrayList<String>();
//				
//				for(EngineerPrefrence prefrence : wrapper.getEngineerPrefrence()) {
//					engineerService.sendNotification(jsonParam);
//					prefrence.getClass();
//					
//				}
//			

		/*
		 * the below lines are for the sending the response to the URL
		 * 
		 * 
		 * final String uri = "https://fcm.googleapis.com/fcm/send";
		 * 
		 * HttpHeaders headers = new HttpHeaders();
		 * 
		 * headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		 * 
		 * headers.set("Content-Type", "application/json");
		 * 
		 * headers.set("Authorization",
		 * "key=AAAAbwhaNR4:APA91bEyGTqrH-UoX4b9OBOXWwVl5dV3pkyC2SubM_UMHJiJzlmXQbSx4WKUhTeUAiYaY4_jorjT0k1mAAu5KV9Z5FXjZ1f2z_jZZnjZw2_4sjP-9J--2kkadx7PnrVzns2DXPnev8Cz"
		 * );
		 * 
		 * HttpEntity<String> entity = new HttpEntity<String>(headers);
		 * 
		 * ResponseEntity<String> response = restTemplate.exchange(uri,
		 * HttpMethod.POST,entity,String.class);
		 * 
		 * return ResponseEntity.ok(response.getBody();
		 */

		// return ResponseEntity.ok().body(body);
		return ResponseEntity.ok(engineerService.sendNotification(jsonParam));
	}

	// getUiMessage method for getting message from ui to terminate the process
	@RequestMapping(value = "/message", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void getUiMessage(@RequestBody String UiMessage) {
		engineerService.getUiMessage(UiMessage);
	}

	@GetMapping("/engineer/{techcode}")
	public List<EngineerWorkDTO> getEngineer(@PathVariable String techcode) {
		return engineerService.getEngineerWork(techcode);
	}

	// The Below logic is to save review from the engineers

	@RequestMapping(value = "/saveReview", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void saveReview(@RequestBody final ReviewDTO reviewDTO) {
		engineerService.saveReviewData(reviewDTO);
	}

	@GetMapping("/review")
	public List<Review> getAll() {
		return engineerService.getAll();
	}

}

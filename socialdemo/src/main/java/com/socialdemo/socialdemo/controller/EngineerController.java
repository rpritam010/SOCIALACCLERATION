/**
 * @author Pritam Raj
 *
 * 07-Dec-2020
socialdemoSocialAccleration
 */

package com.socialdemo.socialdemo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.socialdemo.socialdemo.dto.AcceptedNotificationDTO;
import com.socialdemo.socialdemo.dto.EngineerWorkDTO;
import com.socialdemo.socialdemo.dto.FaceTimeResponseDTO;
import com.socialdemo.socialdemo.dto.ReceiverNotificationDTO;
import com.socialdemo.socialdemo.dto.ReviewDTO;
import com.socialdemo.socialdemo.dto.StatusResponseDTO;
import com.socialdemo.socialdemo.entity.EngineerDetails;
import com.socialdemo.socialdemo.entity.Profile;
import com.socialdemo.socialdemo.entity.ReceiverNotification;
import com.socialdemo.socialdemo.entity.Review;
import com.socialdemo.socialdemo.entity.Status;
import com.socialdemo.socialdemo.repository.StatusRepository;
import com.socialdemo.socialdemo.service.EngineerService;

@RestController
public class EngineerController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EngineerService engineerService;

	RestTemplate restTemplate = new RestTemplate();

	@GetMapping("/findAllOrders/techcode/{techcode}")
	public List<EngineerDetails> retriveEngineerDetails(@PathVariable String techcode) {
		return engineerService.getEngineer(techcode);
	}

	@GetMapping("/profile/TechCode/{techcode}")
	public Profile getEngineerDetails(@PathVariable String techcode) {

		return engineerService.getProfile(techcode);

	}

	@Autowired
	private StatusRepository statusRepository;

	@GetMapping("/getStatus")
	public List<Status> get() {
		return statusRepository.findAll();
	}

	@PatchMapping(value = "/status/")
	public void updateStatus(@RequestBody StatusResponseDTO statusResponseDTO) {
		engineerService.updateStatus(statusResponseDTO);
	}

	@PatchMapping(value = "/token/{techCode}/{deviceToken}")
	public void updateDeviceToken(@PathVariable("techCode") String techCode,
			@PathVariable("deviceToken") String deviceToken) {
		engineerService.updateDeviceToken(techCode, deviceToken);

	}

	@PatchMapping(value = "/faceTimeResponseDTO/")
	public void updateStatus(@RequestBody FaceTimeResponseDTO faceTimeResponseDTO) {
		engineerService.updateFaceTime(faceTimeResponseDTO);
	}

	@RequestMapping(value = "/sendNotification", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> sendNotification(@RequestBody String jsonParam) throws Exception {

		return ResponseEntity.ok(engineerService.sendNotification(jsonParam));
	}

	// for getting Message to terminate the process
	@RequestMapping(value = "/message", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void getUiMessage(@RequestBody String UiMessage) {
		engineerService.getUiMessage(UiMessage);
	}

	@GetMapping("/engineer/{techcode}")
	public List<EngineerWorkDTO> getEngineer(@PathVariable String techcode) {
		return engineerService.getEngineerWork(techcode);
	}

	// The below logic is to save the review
	@RequestMapping(value = "/saveReview", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void saveReview(@RequestBody final ReviewDTO reviewDTO) {

		engineerService.saveReviewData(reviewDTO);

	}

	@GetMapping("/review")
	public List<Review> getAll() {
		return engineerService.getAll();
	}

	// the below logic for updating the status for the receviernotification

	@PatchMapping(value = "/notification/status/")
	public void updateNotificationStatus(@RequestBody ReceiverNotificationDTO receiverNotificationDTO) {
		engineerService.updateNotificationStatus(receiverNotificationDTO);
	}

	@PostMapping(value = "/acceptedcall")
	public String getAcceptedCallDetails(@RequestBody AcceptedNotificationDTO acceptedNotificationDTO) {
		return engineerService.getAcceptedCallDetail(acceptedNotificationDTO);
	}

}

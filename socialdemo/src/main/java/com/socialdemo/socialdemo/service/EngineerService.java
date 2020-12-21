package com.socialdemo.socialdemo.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.socialdemo.socialdemo.dto.FaceTimeResponseDTO;
import com.socialdemo.socialdemo.dto.StatusResponseDTO;
import com.socialdemo.socialdemo.entity.DataPojo;
import com.socialdemo.socialdemo.entity.EngineerDetails;
import com.socialdemo.socialdemo.entity.EngineerPrefrence;
import com.socialdemo.socialdemo.entity.NotificationPojo;
import com.socialdemo.socialdemo.entity.Profile;
import com.socialdemo.socialdemo.entity.Status;
import com.socialdemo.socialdemo.repository.EngineerDetailsRepository;
import com.socialdemo.socialdemo.repository.EngineerPrefrenceRepository;
import com.socialdemo.socialdemo.repository.EngineerProfileRepository;
import com.socialdemo.socialdemo.repository.ProfileRepository;
import com.socialdemo.socialdemo.repository.StatusRepository;

@Service
public class EngineerService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private EngineerDetailsRepository repository;

	@Autowired
	private ProfileRepository profileRepo;

	@Autowired
	private EngineerProfileRepository repository1;

	@Autowired
	StatusRepository repo;

	Status status;

	@Autowired
	private EngineerPrefrenceRepository epRepository;

	public List<EngineerDetails> getEngineer(String techcode) {

		logger.info("techCode value =:" + techcode);

		List<EngineerDetails> detail = (repository.findByEngineerDetails(techcode));

		logger.info("show detail value:" + detail.toString());

		logger.info("show detail value2:" + detail);

		return detail;
	}

	public Profile getProfile(String TechCode) {

		Profile ProfileDetail = (repository1.findByProfile(TechCode));

		logger.info("show detail value:" + ProfileDetail.toString());

		logger.info("show detail value2:" + ProfileDetail);

		return ProfileDetail;
	}

	// public void updateStatus(String techCode) {
//		Optional<Status> opt = repo.findById(techCode);
//		Status status1 = opt.isPresent()?opt.get():null;
//		if(status1.getStatus().equalsIgnoreCase("N")){
//			status1.setStatus("Y");
//		}
//		else {
//			status1.setStatus("N");
//		}
//		repo.save(status1);
//	}

	public void updateStatus(StatusResponseDTO statusResponseDTO) {
		try {

			Optional<Status> opt = repo.findById(statusResponseDTO.getTechCode());

			Status status1 = opt.isPresent() ? opt.get() : null;

			status1.setStatus(statusResponseDTO.getStatus());

			repo.save(status1);

		} catch (Exception e) {

			logger.info("No such techcode exist");

		}

	}
	
	
	public void updateFaceTime(FaceTimeResponseDTO faceTimeResponseDTO) {
		try {

			Optional<Status> opt = repo.findById(faceTimeResponseDTO.getTechCode());

			Status status1 = opt.isPresent() ? opt.get() : null;

			status1.setStatus(faceTimeResponseDTO.getFaceTimeId());

			repo.save(status1);

		} catch (Exception e) {

			logger.info("No such techcode exist");

		}

	}

	

	public void updateDeviceToken(String techCode, String deviceToken) {

		Optional<Status> opt = repo.findById(techCode);
		Status status1 = opt.isPresent() ? opt.get() : null;
		status1.setDeviceToken(deviceToken);
		repo.save(status1);

	}

	public String sendNotification(String jsonParam) {

		JSONObject jsonObject = new JSONObject(jsonParam);

		JSONArray skillsArr = jsonObject.getJSONArray("requestedSkill");
		
		String taskType = jsonObject.getString("taskType");

		String comments = jsonObject.getString("comments");


		JSONObject jsonToReturn = new JSONObject();

		ArrayList<String> skillList = new ArrayList<String>();

		if (skillsArr != null && skillsArr.length() > 0) {

			for (int i = 0; i < skillsArr.length(); i++) {

				skillList.add(skillsArr.getString(i));

			}

		}

		List<EngineerPrefrence> prefrenceDetail = (epRepository.findByEngineerPrefrence(skillList));

		if (prefrenceDetail != null && prefrenceDetail.size() > 0) {

			for (int i = 0; i < prefrenceDetail.size(); i++) {

				if (prefrenceDetail.get(i).getActive().equals("Y")) {

					List<Profile> empProfile = profileRepo.findByProfile(prefrenceDetail.get(i).getTechCode());

					if (empProfile != null && empProfile.size() > 0) {

						for (int j = 0; j < empProfile.size(); j++) {

							NotificationPojo notificationModal = new NotificationPojo();
							
							DataPojo dataModal = new DataPojo();
							
							List<Profile> reqEmpProfile = profileRepo.findByProfile(jsonObject.get("techCode").toString());


							jsonToReturn.put("to", empProfile.get(j).getDeviceToken());

							notificationModal.setClickAction("FACETIME_CALL");

							notificationModal.setTitle("join Facetime call now");

							notificationModal.setMutableContent("0");

							notificationModal.setBody(reqEmpProfile.get(0).getName()+" "+"is working on "+"'"+taskType+"'"+"."+" "+"He needs assistance on "+"'"+comments+"'"+" "+"can you help?");
							
							dataModal.setTitle("join Facetime call now");
							
							dataModal.setBody(reqEmpProfile.get(0).getName()+" "+"is working on "+"'"+taskType+"'"+"."+" "+"He needs assistance on "+"'"+comments+"'"+" "+"can you help?");
							
							
							//jsonToReturn.put("facetimeID", reqEmpProfile.get(0).getFaceTimeId());
							dataModal.setFaceTimeId(reqEmpProfile.get(0).getFaceTimeId());
						
							
							//jsonToReturn.put("notification", notificationModal);
							ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
							
							try {
								jsonToReturn.put("notification", new JSONObject(ow.writeValueAsString(notificationModal)));
							} catch (JSONException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (JsonProcessingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							//for the dataModal															
							
							try {
								jsonToReturn.put("data", new JSONObject(ow.writeValueAsString(dataModal)));
							} catch (JSONException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (JsonProcessingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
							
					}

				}

			}

		}
		 		//return jsonToReturn.toString();

//		RestTemplate restTemplate = new RestTemplate();
//		
//		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://fcm.googleapis.com/fcm/send");
//		
//		HttpHeaders headers = new HttpHeaders();
//		
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		
//		HttpEntity<String> entity = new HttpEntity<String>(jsonToReturn.toString(), headers);
//		
//		ResponseEntity<String> response = restTemplate.postForEntity(builder.build().encode().toUri(), entity, String.class);

		URL url = null;

		try {

			url = new URL("https://fcm.googleapis.com/fcm/send");

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HttpURLConnection con = null;
		try {
			con = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		con.setDoOutput(true);
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Authorization",
				"key=AAAASK8QTug:APA91bGsldhw8ldQTmhloi1HgjgGm8tZxluzLiQmdJ9YjqhbeRm5Lc7LjIr4Td8eLh8MD6awYDv2Z8vupAPboFx4IrbHUAJUdITqZNJIDDeXnQS2Bdx2kd1nH0Le6_t69fp9rJ_lxWVe");
				//"key=AAAAbwhaNR4:APA91bEyGTqrH-UoX4b9OBOXWwVl5dV3pkyC2SubM_UMHJiJzlmXQbSx4WKUhTeUAiYaY4_jorjT0k1mAAu5KV9Z5FXjZ1f2z_jZZnjZw2_4sjP-9J--2kkadx7PnrVzns2DXPnev8Cz");
		try {
			con.setRequestMethod("POST");
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		con.setInstanceFollowRedirects(false);
		// connect
		try {
			con.connect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
			wr.write(jsonToReturn.toString());
			wr.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BufferedReader reader = null;

		String response = null;

		int status = 0;

		if (null != con) {

			try {
				status = con.getResponseCode();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if (status != 0) {

			if (status == 200) {

				try {
					reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
					response = reader.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		return response;


	}

}

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
import java.util.TreeSet;
import java.util.UUID;
import java.util.stream.Collectors;

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
import com.socialdemo.socialdemo.dto.AcceptedNotificationDTO;
import com.socialdemo.socialdemo.dto.EngineerWorkDTO;
import com.socialdemo.socialdemo.dto.FaceTimeResponseDTO;
import com.socialdemo.socialdemo.dto.Feedback;
import com.socialdemo.socialdemo.dto.ReceiverNotificationDTO;
import com.socialdemo.socialdemo.dto.ReviewDTO;
import com.socialdemo.socialdemo.dto.SkillMapping;
import com.socialdemo.socialdemo.dto.StatusResponseDTO;
import com.socialdemo.socialdemo.entity.DataPojo;
import com.socialdemo.socialdemo.entity.EngineerDetails;
import com.socialdemo.socialdemo.entity.EngineerPrefrence;
import com.socialdemo.socialdemo.entity.JobDetails;
import com.socialdemo.socialdemo.entity.NotificationPojo;
import com.socialdemo.socialdemo.entity.Profile;
import com.socialdemo.socialdemo.entity.ReceiverNotification;
import com.socialdemo.socialdemo.entity.Review;
import com.socialdemo.socialdemo.entity.Status;
import com.socialdemo.socialdemo.entity.TaskType;
import com.socialdemo.socialdemo.repository.EinsetRepository;
import com.socialdemo.socialdemo.repository.EngineerDetailsRepository;
import com.socialdemo.socialdemo.repository.EngineerPrefrenceRepository;
import com.socialdemo.socialdemo.repository.EngineerProfileRepository;
import com.socialdemo.socialdemo.repository.JobDetailsRepository;
import com.socialdemo.socialdemo.repository.ProfileRepository;
import com.socialdemo.socialdemo.repository.ReceiverNotificationRepository;
import com.socialdemo.socialdemo.repository.ReviewRepository;
import com.socialdemo.socialdemo.repository.StatusRepository;
import com.socialdemo.socialdemo.repository.TaskTypeRepository;
import com.socialdemo.socialdemo.repository.TaskTypeSkillRepository;

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

	ReceiverNotification receiverNotification;

	Status status;

	@Autowired
	private EngineerPrefrenceRepository epRepository;

	@Autowired
	EinsetRepository einsetRepository;

	@Autowired
	JobDetailsRepository jobDetailsRepository;

	@Autowired
	TaskTypeSkillRepository taskTypeSkillRepository;

	@Autowired
	TaskTypeRepository taskTypeRepository;

	@Autowired
	ReviewRepository reviewRepository;

	@Autowired
	ReceiverNotificationRepository receiverNotificationRepository;

	List<EngineerWorkDTO> engineerWorkDTOList = new ArrayList<EngineerWorkDTO>();

	String datetime;

	String commitdate;

	String task;

	String description;

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
	// Optional<Status> opt = repo.findById(techCode);
	// Status status1 = opt.isPresent()?opt.get():null;
	// if(status1.getStatus().equalsIgnoreCase("N")){
	// status1.setStatus("Y");
	// }
	// else {
	// status1.setStatus("N");
	// }
	// repo.save(status1);
	// }

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

			status1.setFaceTimeId(faceTimeResponseDTO.getFaceTimeId());

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

		List<String> deviceTokenList = new ArrayList<String>();

		for (int k = 0; k < skillList.size(); k++) {

			List<EngineerPrefrence> prefrenceDetail = null;

			if (deviceTokenList.size() < 4) {

				prefrenceDetail = epRepository.findByEngineerPrefrence(skillList.get(k));

			}

			// prefrenceDetail.addAll((epRepository.findByEngineerPrefrence(skillList.get(k))));

			if (prefrenceDetail != null && prefrenceDetail.size() > 0) {

				for (int i = 0; i < prefrenceDetail.size(); i++) {

					if (prefrenceDetail.get(i).getActive().equals("Y") && deviceTokenList.size() < 5) {

						List<Profile> empProfile = profileRepo.findByProfile(prefrenceDetail.get(i).getTechCode());
						if (empProfile != null && empProfile.size() > 0) {

							for (int j = 0; j < empProfile.size(); j++) {
								if (!((empProfile.get(j).getTechcode())
										.equals(jsonObject.get("techCode").toString()))) {
									deviceTokenList.add(empProfile.get(j).getDeviceToken());
								}
							}
							// deviceTokenList.stream().distinct().collect(Collectors.toList());

						}
					}

				}

			}
		}

		jsonToReturn.put("to", deviceTokenList);

		jsonToReturn.getJSONArray("to");

		List<String> techCodeValues = new ArrayList<>();
		List<ReceiverNotification> listReceiverNotification = new ArrayList<ReceiverNotification>();

		for (int i = 0; i < jsonToReturn.getJSONArray("to").length(); i++) {
			techCodeValues.add(profileRepo.getTechcode(jsonToReturn.getJSONArray("to").get(i).toString()));
		}
		logger.info("this is for getting techcode from devicetoken ::");

		// logger.info("token techcode size::"+techCodeValues.size());

		String groupid = UUID.randomUUID().toString();
		for (int k = 0; k < techCodeValues.size(); k++) {
			ReceiverNotification receiverNotification = new ReceiverNotification();
			// logger.info("requesttechcode ::"+jsonObject.get("techCode").toString());
			receiverNotification.setGroupid(groupid);
			receiverNotification.setReqtechcode(jsonObject.get("techCode").toString());
			receiverNotification.setRecetechcode(techCodeValues.get(k));
			listReceiverNotification.add(receiverNotification);
		}
		receiverNotificationRepository.saveAll(listReceiverNotification);

		jsonToReturn.put("groupid", groupid);

		NotificationPojo notificationModal = new NotificationPojo();

		DataPojo dataModal = new DataPojo();

		List<Profile> reqEmpProfile = profileRepo.findByProfile(jsonObject.get("techCode").toString());

		// jsonToReturn.put("to", empProfile.get(j).getDeviceToken());

		notificationModal.setClickAction("FACETIME_CALL");

		notificationModal.setTitle("join Facetime call now");

		notificationModal.setMutableContent("0");

		notificationModal.setBody(reqEmpProfile.get(0).getName() + " " + "is working on " + "'" + taskType + "'" + "."
				+ " " + "He needs assistance on " + "'" + comments + "'" + " " + "can you help?");

		dataModal.setTitle("join Facetime call now");

		dataModal.setBody(reqEmpProfile.get(0).getName() + " " + "is working on " + "'" + taskType + "'" + "." + " "
				+ "He needs assistance on " + "'" + comments + "'" + " " + "can you help?");

		// jsonToReturn.put("facetimeID", reqEmpProfile.get(0).getFaceTimeId());
		dataModal.setFaceTimeId(reqEmpProfile.get(0).getFaceTimeId());

		// jsonToReturn.put("notification", notificationModal);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

		try {
			jsonToReturn.put("notification", new JSONObject(ow.writeValueAsString(notificationModal)));
			jsonToReturn.put("data", new JSONObject(ow.writeValueAsString(dataModal)));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//return jsonToReturn.toString();

	//}
	// RestTemplate restTemplate = new RestTemplate();
	//
	// UriComponentsBuilder builder =
	// UriComponentsBuilder.fromHttpUrl("https://fcm.googleapis.com/fcm/send");
	//
	// HttpHeaders headers = new HttpHeaders();
	//
	// headers.setContentType(MediaType.APPLICATION_JSON);
	//
	// HttpEntity<String> entity = new HttpEntity<String>(jsonToReturn.toString(),
	// headers);
	//
	// ResponseEntity<String> response =
	// restTemplate.postForEntity(builder.build().encode().toUri(), entity,
	// String.class);

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
	// "key=AAAAbwhaNR4:APA91bEyGTqrH-UoX4b9OBOXWwVl5dV3pkyC2SubM_UMHJiJzlmXQbSx4WKUhTeUAiYaY4_jorjT0k1mAAu5KV9Z5FXjZ1f2z_jZZnjZw2_4sjP-9J--2kkadx7PnrVzns2DXPnev8Cz");
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
	public void getUiMessage(String uiMessage) {

	}

	public List<EngineerWorkDTO> getEngineerWork(String techcode) {

		List<String> vpin = einsetRepository.findAllById(techcode);

		logger.info("the vpin is :" + vpin);

		logger.info("getTask started");

		List<JobDetails> jobDetails = jobDetailsRepository.getTaskType(vpin.get(0));

		jobDetails.stream().forEach(jobDetailsList -> {
			datetime = jobDetailsList.getDatetime();

			commitdate = jobDetailsList.getEnddate();

			task = jobDetailsList.getTasktype();

			EngineerWorkDTO engineerWorkDTO = new EngineerWorkDTO();

			logger.info("get tasks ends --- subskill started");

			logger.info("tell me the task :" + task);

			List<String> subSkills = jobDetailsRepository.getListOfSubSkills(task);

			logger.info("get primary skills started:");

			List<String> primarySkill = taskTypeSkillRepository.getPrimarySkill(task);

			logger.info("get primary skill : " + primarySkill.get(0));

			logger.info("get description started:");

			List<TaskType> taskType = taskTypeRepository.getDescription(task);

			taskType.stream().forEach(taskTypeList -> {
				description = taskTypeList.getDescription1() + taskTypeList.getDescription2();
			});
			logger.info("subskill ended");

			engineerWorkDTO.setWm_pin(vpin.get(0));

			engineerWorkDTO.setStartTime(datetime);

			engineerWorkDTO.setEndTime(commitdate);

			engineerWorkDTO.setTaskDescription(description);

			engineerWorkDTO.setTaskType(task);

			engineerWorkDTO.setTechcode(techcode);

			SkillMapping skillMapping = new SkillMapping();

			skillMapping.setSkillId(primarySkill.get(0));

			skillMapping.setDefaultSkill("1");

			// List<SkillMapping> skillMappingLs = new ArrayList<>();
			//
			// skillMappingLs.add(skillMapping);
			//
			// engineerWorkDTO.setSkillMapping(skillMappingLs);
			//
			// subSkills.stream().forEach(subSkillsList->{
			// SkillMapping skillMapping1 = new SkillMapping();
			//
			// skillMapping1.setSkillId(subSkillsList);
			//
			// skillMapping1.setDefaultSkill("0");
			//
			// List<SkillMapping> skillMappingLs1 = new ArrayList<>();
			//
			// skillMappingLs1.add(skillMapping1);
			//
			// engineerWorkDTO.setSkillMapping(skillMappingLs1);
			// });
			//
			// engineerWorkDTOList.add(engineerWorkDTO);
			// });
			List<SkillMapping> skillMappingLs = new ArrayList<>();
			skillMappingLs.add(skillMapping);
			TreeSet<SkillMapping> uniqueSkills = new TreeSet<>();
			subSkills.stream().forEach(subSkillsList -> {
				SkillMapping skillMapping1 = new SkillMapping();

				skillMapping1.setSkillId(subSkillsList);
				skillMapping1.setDefaultSkill("0");
				uniqueSkills.add(skillMapping1);
			});
			skillMappingLs.addAll(uniqueSkills);
			engineerWorkDTO.setSkillMapping(skillMappingLs);
			engineerWorkDTOList.add(engineerWorkDTO);
		});

		return engineerWorkDTOList;
	}

	public void saveReviewData(ReviewDTO reviewDTO) {

		Review review = new Review();

		List<Feedback> feedbackList = reviewDTO.getFeedback();
		feedbackList.stream().forEach(feedbackobj -> {
			review.setTechcode(reviewDTO.getTechcode());
			review.setQuestion(feedbackobj.getQuestion());
			review.setAnswer(feedbackobj.getAnswer());
			reviewRepository.save(review);
		});

	}

	public List<Review> getAll() {
		return reviewRepository.findAll();
	}

	public void updateNotificationStatus(ReceiverNotificationDTO receiverNotificationDTO) {
		try {
			logger.info("recivernotification groupid  ::" + receiverNotificationDTO.getGroupid());
			logger.info("recivernotification techcode  ::" + receiverNotificationDTO.getRecetechcode());

			ReceiverNotification receiverNotification = receiverNotificationRepository
					.getStatus(receiverNotificationDTO.getRecetechcode(), receiverNotificationDTO.getGroupid());

			// ReceiverNotification receiverNotification = opt.isPresent() ? opt.get() :
			// null;
			receiverNotification.setStatus(receiverNotificationDTO.getStatus());
			logger.info("recivernotification status ::" + receiverNotification.getStatus());

			receiverNotificationRepository.save(receiverNotification);

		} catch (Exception e) {

			logger.info("No such groupId exist:: " + e.getStackTrace());

		}

	}

	public String getAcceptedCallDetail(AcceptedNotificationDTO acceptedNotificationDTO) {

		ReceiverNotification receiverNotification = receiverNotificationRepository
				.getTechcodeByStatus(acceptedNotificationDTO.getReqtechcode(), acceptedNotificationDTO.getStatus());

		return receiverNotification.getRecetechcode();
	}

}

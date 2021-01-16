package com.socialdemo.socialdemo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.socialdemo.socialdemo.entity.ReceiverNotification;

@Repository
public interface ReceiverNotificationRepository extends JpaRepository<ReceiverNotification, Integer> {
	
	
	@Query(value = "SELECT * FROM receiver_notification WHERE groupid =:groupid AND recetechcode =:recetechcode", nativeQuery = true)
	ReceiverNotification getStatus(@Param ("recetechcode") String recetechcode,@Param("groupid") String groupid);
	//Optional<ReceiverNotification> findAll(String recetechcode, String groupid); 
	@Query(value = "SELECT * FROM receiver_notification WHERE reqtechcode=:reqtechcode AND status=:status", nativeQuery = true)
	ReceiverNotification getTechcodeByStatus(@Param("reqtechcode") String reqtechcode,@Param("status") String status);
	
	
//	@Query("update ReceiverNotification rn set rn.status=:status where rn.groupid =:groupid AND rn.recetechcode =:recetechcode")
	//void setStatusValue(@Param("groupid") String groupid, @Param ("recetechcode") String recetechcode,@Param("status") String status);
	
	}

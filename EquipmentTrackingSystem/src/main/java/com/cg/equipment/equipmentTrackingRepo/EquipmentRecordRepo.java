package com.cg.equipment.equipmentTrackingRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.equipment.bean.EquipmentRecord;
import com.cg.equipment.equipmentTrackingException.TrackingException;
@Repository
public interface EquipmentRecordRepo extends JpaRepository<EquipmentRecord, String>{
	
	@Query("SELECT E FROM EquipmentRecord E WHERE E.equipmentTag=:equipmentTag")
	public EquipmentRecord findByEquipmentTag(@Param(value="equipmentTag") String equipmentTag) throws TrackingException;
	
	@Query("SELECT E FROM EquipmentRecord E INNER JOIN E.user u WHERE u.userId=:userId")
	public EquipmentRecord findByUserId(@Param(value="userId")String userId) throws TrackingException;
	
	@Query("SELECT E FROM EquipmentRecord E INNER JOIN E.location l WHERE l.locationName=:locationName")
	public EquipmentRecord findByLocation(@Param(value="locationName")String locationName) throws TrackingException;

	@Query("SELECT E FROM EquipmentRecord E WHERE E.equipmentType=:equipmentType")
	public EquipmentRecord findByEquipmentType(@Param(value="equipmentType")String equipmentType) throws TrackingException;

	@Query("SELECT E FROM EquipmentRecord E WHERE E.seqNo=:seqNo")
	public EquipmentRecord findBySeqNo(@Param(value="seqNo") String seqNo) throws TrackingException;
	

}

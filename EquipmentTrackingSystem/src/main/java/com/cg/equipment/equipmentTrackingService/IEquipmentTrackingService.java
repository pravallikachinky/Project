package com.cg.equipment.equipmentTrackingService;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.cg.equipment.bean.EquipmentRecord;
import com.cg.equipment.equipmentTrackingException.TrackingException;

public interface IEquipmentTrackingService {

	public EquipmentRecord addEquipmentRecord(EquipmentRecord record) throws TrackingException;
	
	public EquipmentRecord findByEquipmentTag(String equipmentTag) throws TrackingException;

	EquipmentRecord findByUserId(String userId) throws TrackingException;

	EquipmentRecord findByLocation(String location) throws TrackingException;

	EquipmentRecord updateEquipment(EquipmentRecord equipment) throws TrackingException;

	List<EquipmentRecord> viewAllEquipments(EquipmentRecord record) throws TrackingException;
	
	EquipmentRecord findByEquipmentType(String equipmentType) throws TrackingException;

	EquipmentRecord findBySeqNo(String seqNo) throws TrackingException;

}

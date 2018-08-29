package com.cg.equipment.equipmentTrackingService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.equipment.bean.EquipmentRecord;
import com.cg.equipment.equipmentTrackingException.TrackingException;
import com.cg.equipment.equipmentTrackingRepo.EquipmentRecordRepo;

@Service
public class EquipementTrackingServiceImpl implements IEquipmentTrackingService {

	@Autowired
	private EquipmentRecordRepo repo;
	
	@Override
	public EquipmentRecord addEquipmentRecord(EquipmentRecord record) throws TrackingException {
		/*if(!record.getEquipmentTag().matches("//d{10}")) {
			throw new TrackingException("EquipmentTag should contain only numbers and should not exceed 10");
			}*/
		return repo.save(record);
	}

	@Override
	public EquipmentRecord findByEquipmentTag(String equipmentTag) throws TrackingException {
		/*if(!equipmentTag.matches("[0-9]{10}")) {
			throw new TrackingException("EquipmentTag should contain only numbers and should not exceed 10");
			}*/
		return repo.findByEquipmentTag(equipmentTag);
	}
	
	@SuppressWarnings("unused")
	@Override
	public EquipmentRecord findByUserId(String userId) throws TrackingException {
	EquipmentRecord record = new EquipmentRecord();
	if(record==null) {
	throw new TrackingException("Given user Id is not present in the record");
	}
	else {
	return repo.findByUserId(userId);
	}
	}

	@SuppressWarnings("unused")
	@Override
	public EquipmentRecord findByLocation(String location) throws TrackingException {
	EquipmentRecord record = new EquipmentRecord();
	if(record==null) {
	throw new TrackingException("Given Location is not present in the record");
	}
	else {
	return repo.findByLocation(location);
	}
	}

	@Override
	public EquipmentRecord updateEquipment(EquipmentRecord equipment) throws TrackingException {
		EquipmentRecord record= repo.findByEquipmentTag(equipment.getEquipmentTag());
		if(record.getUseStatus().matches("retired")) {
			record.setComments(equipment.getComments());
			return repo.save(record);
			
		}else {
		 return repo.saveAndFlush(equipment);
		}
	}

	@Override
	public List<EquipmentRecord> viewAllEquipments(EquipmentRecord record) throws TrackingException {
		
		return repo.findAll();
	}

	@SuppressWarnings("unused")
	@Override
	public EquipmentRecord findByEquipmentType(String equipmentType) throws TrackingException {
		EquipmentRecord record = new EquipmentRecord();
		if(record==null) {
		throw new TrackingException("Given Equipment Type is not present in the record");
		}
		else {
		return repo.findByEquipmentType(equipmentType);
		}
	}

	@SuppressWarnings("unused")
	@Override
	public EquipmentRecord findBySeqNo(String seqNo) throws TrackingException {
		EquipmentRecord record = new EquipmentRecord();
		if(record==null) {
		throw new TrackingException("Given user Id is not present in the record");
		}
		else {
		return repo.findBySeqNo(seqNo);
		}
	}

	
	

}

package com.cg.equipment.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.equipment.bean.EquipmentRecord;
import com.cg.equipment.equipmentTrackingException.TrackingException;
import com.cg.equipment.equipmentTrackingService.IEquipmentTrackingService;

@RestController
public class EquipmentController {
	
	@Autowired
	private IEquipmentTrackingService service;
	
	@RequestMapping(value="/addrecord",method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EquipmentRecord> acceptProductDetails(@RequestBody EquipmentRecord record) throws TrackingException{
		
		return new ResponseEntity<EquipmentRecord>(service.addEquipmentRecord(record),HttpStatus.OK);
	}
	
	/*@RequestMapping(value="/addrecord",method=RequestMethod.POST)
	public EquipmentRecord addEquipmentRecord(@RequestBody EquipmentRecord record) throws TrackingException  {
		try {
			return service.addEquipmentRecord(record);
		} catch (TrackingException e) {
			throw new TrackingException(e.getMessage());
		}

	}*/
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(method=RequestMethod.GET,value= {"/records"},produces= {"application/JSON"})
	public ResponseEntity<List> viewAllProductDetails(EquipmentRecord record) throws TrackingException{
		return new ResponseEntity<List>(service.viewAllEquipments(record),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value= {"/recordsbyEquipmentTag/{equipmentTag}"})
	public ResponseEntity<EquipmentRecord> viewByEquipmentTag(@PathParam(value="equipmentTag") String equipmentTag) throws TrackingException{
		return new ResponseEntity<EquipmentRecord>(service.findByEquipmentTag(equipmentTag),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value= {"/recordsbyUserId/{userId}"})
	public ResponseEntity<EquipmentRecord> viewByUserId(@PathVariable(value="userId") String userId) throws TrackingException{
		return new ResponseEntity<EquipmentRecord>(service.findByUserId(userId),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/getbyLocation/{location}")
	public ResponseEntity<EquipmentRecord> viewByLocation(@RequestParam(value="location") String location) throws TrackingException{
		return new ResponseEntity<EquipmentRecord>(service.findByLocation(location),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value= {"/recordsbyEquipmentType/{equipmentType}"})
	public ResponseEntity<EquipmentRecord> viewByEquipmentType(@RequestParam(value="equipmentType") String equipmentType) throws TrackingException{
		return new ResponseEntity<EquipmentRecord>(service.findByEquipmentType(equipmentType),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value= {"/recordsbySeqNo/{seqNo}"})
	public ResponseEntity<EquipmentRecord> viewBySeqNo(@RequestParam(value="seqNo") String seqNo) throws TrackingException{
		return new ResponseEntity<EquipmentRecord>(service.findBySeqNo(seqNo),HttpStatus.OK);
	}
	
	@RequestMapping(value="/updateRecord",method=RequestMethod.PUT,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EquipmentRecord> updateRecord(@RequestBody EquipmentRecord equipment ) throws TrackingException{
		return new ResponseEntity<EquipmentRecord>(service.updateEquipment(equipment),HttpStatus.OK);
	}
	
	@RequestMapping(value="/getbyEquipmentTag")
	public EquipmentRecord findByEquipmentTag(String equipmentTag) throws TrackingException {
		
		try {
			return service.findByEquipmentTag(equipmentTag);
		} catch (TrackingException e) {
			throw new TrackingException(e.getMessage());
		}
		
	}
	
	@RequestMapping(value="/getbyUserId")
	public EquipmentRecord findByUserId(String userId) throws TrackingException{
		
	return service.findByUserId(userId);
	
	}
	@RequestMapping(value="/getbyLocation")
	public EquipmentRecord findByLocation(String location) throws TrackingException{
		
	return service.findByLocation(location);
	
	}
	@RequestMapping(value="/updateEquipment",method=RequestMethod.PUT)
	public EquipmentRecord updateEquipment(@RequestBody EquipmentRecord equipment) throws TrackingException{
		
		return service.updateEquipment(equipment);
	}
	
	@RequestMapping(value="/displayAll")
	public List<EquipmentRecord> viewAllEquipments(EquipmentRecord record) throws TrackingException{
		return service.viewAllEquipments(record);
	}
	


}

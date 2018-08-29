package com.cg.equipment.bean;

import javax.persistence.CascadeType;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class EquipmentRecord {
	
	@Id
	private String eId;
	private String useStatus;
	private boolean auditIndicator;
	private String auditDate;
	private String comments;
	private String stockLocation;
	private String equipmentTag;
	private String equipmentType;
	private String seqNo;
	private int quantity;
	private String lastScanDate;
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private UserBean user;
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Location location;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private PurchaseType purchaseType;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private CompTrak compTrak;
	
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getEquipmentType() {
		return equipmentType;
	}
	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}
	public String getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	public CompTrak getCompTrak() {
		return compTrak;
	}
	public void setCompTrak(CompTrak compTrak) {
		this.compTrak = compTrak;
	}
	public String getLastScanDate() {
		return lastScanDate;
	}
	public void setLastScanDate(String lastScanDate) {
		this.lastScanDate = lastScanDate;
	}
	public String geteId() {
		return eId;
	}
	public void seteId(String eId) {
		this.eId = eId;
	}
	public String getEquipmentTag() {
		return equipmentTag;
	}
	public void setEquipmentTag(String equipmentTag) {
		this.equipmentTag = equipmentTag;
	}
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public PurchaseType getPurchaseType() {
		return purchaseType;
	}
	public void setPurchaseType(PurchaseType purchaseType) {
		this.purchaseType = purchaseType;
	}
	public String getUseStatus() {
		return useStatus;
	}
	public void setUseStatus(String useStatus) {
		this.useStatus = useStatus;
	}
	public boolean isAuditIndicator() {
		return auditIndicator;
	}
	public void setAuditIndicator(boolean auditIndicator) {
		this.auditIndicator = auditIndicator;
	}
	public String getAuditDate() {
		return auditDate;
	}
	public void setAuditDate(String auditDate) {
		this.auditDate = auditDate;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getStockLocation() {
		return stockLocation;
	}
	public void setStockLocation(String stockLocation) {
		this.stockLocation = stockLocation;
	}
	
	

}

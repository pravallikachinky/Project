package com.cg.equipment.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author pgilla
 *
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class CompTrak {

	@Id
	private String machineId;
	private String computerName;
	private String diskCapacity;
	private String totalInstalledMemory;
	private String networkCardNumber;
	private String networkCardManufacturer;
	private String freeSpace;
	private String operatingSystem;
	private String osVersion;
	private String lastScanDateComp;
	
	
	public String getMachineId() {
		return machineId;
	}
	public void setMachineId(String machineId) {
		this.machineId = machineId;
	}
	public String getComputerName() {
		return computerName;
	}
	public void setComputerName(String computerName) {
		this.computerName = computerName;
	}
	public String getDiskCapacity() {
		return diskCapacity;
	}
	public void setDiskCapacity(String diskCapacity) {
		this.diskCapacity = diskCapacity;
	}
	public String getTotalInstalledMemory() {
		return totalInstalledMemory;
	}
	public void setTotalInstalledMemory(String totalInstalledMemory) {
		this.totalInstalledMemory = totalInstalledMemory;
	}
	public String getNetworkCardNumber() {
		return networkCardNumber;
	}
	public void setNetworkCardNumber(String networkCardNumber) {
		this.networkCardNumber = networkCardNumber;
	}
	public String getNetworkCardManufacturer() {
		return networkCardManufacturer;
	}
	public void setNetworkCardManufacturer(String networkCardManufacturer) {
		this.networkCardManufacturer = networkCardManufacturer;
	}
	public String getFreeSpace() {
		return freeSpace;
	}
	public void setFreeSpace(String freeSpace) {
		this.freeSpace = freeSpace;
	}
	public String getOperatingSystem() {
		return operatingSystem;
	}
	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	public String getOsVersion() {
		return osVersion;
	}
	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}
	public String getLastScanDateComp() {
		return lastScanDateComp;
	}
	public void setLastScanDateComp(String lastScanDateComp) {
		this.lastScanDateComp = lastScanDateComp;
	}
	
	
}

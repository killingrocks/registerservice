package edu.uark.models.api;

import java.time.LocalDateTime;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.models.api.enums.ProductApiRequestStatus;
import edu.uark.models.entities.ProductEntity;

public class Product {
	
	public Product() {
		this.count = -1;
		this.lookupCode = "";
		this.firstName = "";
		this.id = new UUID(0, 0);
		this.createdOn = LocalDateTime.now();
		this.apiRequestMessage = StringUtils.EMPTY;
		this.apiRequestStatus = ProductApiRequestStatus.OK;
	}
	
	public Product(ProductEntity productEntity) {
		this.id = productEntity.getId();
		this.lookupCode = productEntity.getLookupCode();
		this.firstName = productEntity.getFirstName();
		this.count = productEntity.getCount();
		this.createdOn = productEntity.getCreatedOn();
		this.apiRequestMessage = StringUtils.EMPTY;
		this.apiRequestStatus = ProductApiRequestStatus.OK;
	}
	
	
	private UUID id;
	private String lookupCode;
	private String firstName;
	private int count;
	private LocalDateTime createdOn;
	private String apiRequestMessage;
	private ProductApiRequestStatus apiRequestStatus;
	
	public UUID getId() {return this.id;}
	public String getLookupCode() {return this.lookupCode;}
	public String getFirstName(){return this.firstName;}
	public int getCount() {	return this.count;}
	public LocalDateTime getCreatedOn() {return this.createdOn;}
	public String getApiRequestMessage() {	return this.apiRequestMessage;}
	public ProductApiRequestStatus getApiRequestStatus() {	return this.apiRequestStatus;	}
	
	public Product setId(UUID id) {
		this.id = id;
		return this;
	}
	public Product setLookupCode(String lookupCode) {
		this.lookupCode = lookupCode;
		return this;
	}
	public Product setFirstName(String firstName){
		this.firstName = firstName;
		return this;
	}
	public Product setCount(int count) {
		this.count = count;
		return this;
	}
	public Product setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
		return this;
	}
	public Product setApiRequestMessage(String apiRequestMessage) {
		if (!StringUtils.equalsIgnoreCase(this.apiRequestMessage, apiRequestMessage)) {
			this.apiRequestMessage = apiRequestMessage;
		}
		return this;
	}
	
	public Product setApiRequestStatus(ProductApiRequestStatus apiRequestStatus) {
		if (this.apiRequestStatus != apiRequestStatus) {
			this.apiRequestStatus = apiRequestStatus;
		}
		return this;
	}	

}

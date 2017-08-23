package edu.uark.models.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.dataaccess.entities.BaseEntity;
import edu.uark.models.api.Product;
import edu.uark.models.entities.fieldnames.ProductFieldNames;
import edu.uark.models.repositories.ProductRepository;

public class ProductEntity extends BaseEntity<ProductEntity> {
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		this.lookupCode = rs.getString(ProductFieldNames.LOOKUP_CODE);
		this.firstname = rs.getString(ProductFieldNames.FIRST_NAME);
		this.count = rs.getInt(ProductFieldNames.COUNT);
		this.createdOn = rs.getTimestamp(ProductFieldNames.CREATED_ON).toLocalDateTime();
	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		record.put(ProductFieldNames.LOOKUP_CODE, this.lookupCode);
		record.put(ProductFieldNames.FIRST_NAME, this.firstname);
		record.put(ProductFieldNames.COUNT, this.count);
		record.put(ProductFieldNames.CREATED_ON, Timestamp.valueOf(this.createdOn));
		return record;
	}

	public Product synchronize(Product apiProduct) {
		this.setLookupCode(apiProduct.getLookupCode());
		this.setFirstName(apiProduct.getFirstName());
		this.setCount(apiProduct.getCount());
		apiProduct.setCreatedOn(this.createdOn);
		return apiProduct;
	}
	
	public ProductEntity() {
		super(new ProductRepository());
		this.lookupCode = StringUtils.EMPTY;
		this.firstname =StringUtils.EMPTY;
		this.count = -1;
		this.createdOn = LocalDateTime.now();
	}
	
	public ProductEntity(UUID id) {
		super(id, new ProductRepository());
		this.lookupCode = StringUtils.EMPTY;
		this.firstname =StringUtils.EMPTY;
		this.count = -1;
		this.createdOn = LocalDateTime.now();
	}

	public ProductEntity(Product apiProduct) {
		super(apiProduct.getId(), new ProductRepository());

		this.lookupCode = apiProduct.getLookupCode();
		this.firstname = apiProduct.getFirstName();
		this.count = apiProduct.getCount();
		this.createdOn = LocalDateTime.now();
	}
	
	private String lookupCode;
	private String firstname;
	private int count;
	private LocalDateTime createdOn;
	
	
	public String getLookupCode() {return this.lookupCode;}
	public String getFirstName() {return this.firstname;}
	public int getCount() {	return this.count;}
	public LocalDateTime getCreatedOn() {return this.createdOn;}
	
	
	public ProductEntity setLookupCode(String lookupCode) {
		if (!StringUtils.equals(this.lookupCode, lookupCode)) {
			this.lookupCode = lookupCode;
			this.propertyChanged(ProductFieldNames.LOOKUP_CODE);
		}
		return this;
	}
	
	public ProductEntity setFirstName(String firstname){
		if (!StringUtils.equals(this.firstname, firstname)){
			this.firstname = firstname;
			this.propertyChanged(ProductFieldNames.FIRST_NAME);
		}
		return this;
	}

	public ProductEntity setCount(int count) {
		if (this.count != count) {
			this.count = count;
			this.propertyChanged(ProductFieldNames.COUNT);
		}
		
		return this;
	}
}

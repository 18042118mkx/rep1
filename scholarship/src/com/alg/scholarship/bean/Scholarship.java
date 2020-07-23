package com.alg.scholarship.bean;

public class Scholarship {
	private Integer scholarshipId;
	private String scholarshipName;
	private Integer amount;
	private Integer scholarshipType;
	private Integer quota;
	private Integer declareNum;
	private Integer successfulNum;
	public Integer getScholarshipId() {
		return scholarshipId;
	}
	public void setScholarshipId(Integer scholarshipId) {
		this.scholarshipId = scholarshipId;
	}
	public String getScholarshipName() {
		return scholarshipName;
	}
	public void setScholarshipName(String scholarshipName) {
		this.scholarshipName = scholarshipName;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getScholarshipType() {
		return scholarshipType;
	}
	public void setScholarshipType(Integer scholarshipType) {
		this.scholarshipType = scholarshipType;
	}
	public Integer getQuota() {
		return quota;
	}
	public void setQuota(Integer quota) {
		this.quota = quota;
	}
	public Integer getDeclareNum() {
		return declareNum;
	}
	public void setDeclareNum(Integer declareNum) {
		this.declareNum = declareNum;
	}
	public Integer getSuccessfulNum() {
		return successfulNum;
	}
	public void setSuccessfulNum(Integer successfulNum) {
		this.successfulNum = successfulNum;
	}
	
}

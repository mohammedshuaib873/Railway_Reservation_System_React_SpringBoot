package com.RailwayUserManagenet.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Mohammed Shuaib A T
 * This Model Class Is Used For Storing Payment Details From The User
 */
@Document(collection = "paymentDetails")
public class PaymentDetails {
	private String cardNo;
	@Id
	private long pnrNo;
	private int cvv;
	private String bankName;
	private String classType;

	public PaymentDetails() {
		super();
	}
    
	public PaymentDetails(String cardNo, long pnrNo, int cvv, String bankName, String classType) {
		super();
		this.cardNo = cardNo;
		this.pnrNo = pnrNo;
		this.cvv = cvv;
		this.bankName = bankName;
		this.classType = classType;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public long getPnrNo() {
		return pnrNo;
	}

	public void setPnrNo(long pnrNo) {
		this.pnrNo = pnrNo;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	@Override
	public String toString() {
		return "PaymentDetails [cardNo=" + cardNo + ", pnrNo=" + pnrNo + ", cvv=" + cvv + ", bankName=" + bankName
				+ ", classType=" + classType + "]";
	}
}

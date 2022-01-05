package com.RailwayReservationPaymentService.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * @author Mohammed Shuaib A T
 * Model Class For Getting User Details For Train Booking
 */
@Document(collection = "userDetails")
public class UserDetailsData {
	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";

	@Id
	@NotNull
	private int id;

	@NotNull
	private long pnrNo;

	@NotNull
	@Size(min = 3, message = "Name should be minimum of 3 characters")
	private String name;

	@NotNull
	@Max(value = 99, message = "Age cannot be more than 99")
	private int age;

	@NotNull
	@Size(max = 6, message = "Either male,female or other ")
	private String sex;

	@NotNull
	@Size(max = 70, message = "Address cannot exceed 70 characters..!!")
	private String address;

	@NotNull
	@Max(value = 99999, message = "Train number cannot exceed 5 digits")
	private int trainNo;

	@NotNull
	@Size(min = 5, message = "Train name should be minimum of 5 characters")
	private String trainName;

	@NotNull
	@Size(min = 2, message = "Start Station should be minimum of 2 characters")
	private String sourceStation;

	@NotNull
	@Size(min = 2, message = "Destination Station should be minimum of 2 characters")
	private String destinationStation;

	@NotNull
	@Size(min = 2, message = "Class type should be minimum of 2 characters")
	private String classType;

	private int adults;
	private int children;

	@NotNull
	private String payment;

	public UserDetailsData() {
		super();
	}

	public UserDetailsData(@NotNull int id, @NotNull long pnrNo,
			@NotNull @Size(min = 3, message = "Name should be minimum of 3 characters") String name,
			@NotNull @Max(value = 99, message = "Age cannot be more than 99") int age,
			@NotNull @Size(max = 6, message = "Either male,female or other ") String sex,
			@NotNull @Size(max = 70, message = "Address cannot exceed 70 characters..!!") String address,
			@NotNull @Max(value = 99999, message = "Train number cannot exceed 5 digits") int trainNo,
			@NotNull @Size(min = 5, message = "Train name should be minimum of 5 characters") String trainName,
			@NotNull @Size(min = 2, message = "Start Station should be minimum of 2 characters") String sourceStation,
			@NotNull @Size(min = 2, message = "Destination Station should be minimum of 2 characters") String destinationStation,
			@NotNull @Size(min = 2, message = "Class type should be minimum of 2 characters") String classType,
			int adults, int children, @NotNull String payment) {
		super();
		this.id = id;
		this.pnrNo = pnrNo;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.address = address;
		this.trainNo = trainNo;
		this.trainName = trainName;
		this.sourceStation = sourceStation;
		this.sourceStation = destinationStation;
		this.classType = classType;
		this.adults = adults;
		this.children = children;
		this.payment = payment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getPnrNo() {
		return pnrNo;
	}

	public void setPnrNo() { // 0 to 1
		long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
		this.pnrNo = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getSourceStation() {
		return sourceStation;
	}

	public void setSourceStation(String sourceStation) {
		this.sourceStation = sourceStation;
	}

	public String getDestinationStation() {
		return destinationStation;
	}

	public void setDestinationStation(String destinationStation) {
		this.destinationStation = destinationStation;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public int getAdults() {
		return adults;
	}

	public void setAdults(int adults) {
		this.adults = adults;
	}

	public int getChildren() {
		return children;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", pnrNo=" + pnrNo + ", name=" + name + ", age=" + age + ", sex=" + sex
				+ ", address=" + address + ", trainNo=" + trainNo + ", trainName=" + trainName + ", startStation="
				+ sourceStation + ", destStation=" + destinationStation + ", classType=" + classType + ", adults="
				+ adults + ", children=" + children + ", payment=" + payment + "]";
	}

}
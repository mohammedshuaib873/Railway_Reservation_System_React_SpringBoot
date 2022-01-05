package com.RailwayUserManagenet.service;

import java.util.List;

import com.RailwayUserManagenet.model.TrainDetails;

/**
 * @author MOHAMMED SHUAIB A T
 * This Is A User Service Interface 
 *
 */
public interface UserService {

	public List<TrainDetails> getAllDetails();
	
	public String pnrStatus(long pnrNo);
	
	public TrainDetails getDetailsByTrainNo(int trainNo);
	
	public List<TrainDetails> getTrainDetailsByEndPoints(String sourceStation,String destinationStation);

}


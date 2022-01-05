package com.RailwayUserManagenet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RailwayUserManagenet.Exception.ResourceNotFoundException;
import com.RailwayUserManagenet.Repository.UserPaymentRepository;
import com.RailwayUserManagenet.Repository.UserRepository;
import com.RailwayUserManagenet.model.PaymentDetails;
import com.RailwayUserManagenet.model.TrainDetails;

/**
 * @author MOHAMMED SHUAIB A T 
 * This Is A User Service Implementation Class
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserPaymentRepository userPayReposotory;

	@Override
	public List<TrainDetails> getAllDetails() {
		List<TrainDetails> trainDetails = new ArrayList<TrainDetails>();
		userRepository.findAll().forEach(trainDetails1 -> trainDetails.add(trainDetails1));
		return trainDetails;
	}

	@Override
	public String pnrStatus(long pnrNo) {
		Random rand = new Random();
		List<String> status = new ArrayList<String>();
		status.add("Confirm");
		status.add("Waiting list");
		List<PaymentDetails> paymentList = userPayReposotory.findAll();
		for (PaymentDetails det : paymentList) {
			if (det.getPnrNo() == pnrNo) {
				return status.get(rand.nextInt(status.size()));
			}
		}
		return "Ticket is not booked with PNR Number " + pnrNo;
	}

	@Override
	public TrainDetails getDetailsByTrainNo(int trainNo) {
		return userRepository.findById(trainNo)
				.orElseThrow(() -> new ResourceNotFoundException("Train not found with number : " + trainNo));
	}

	@Override
	public List<TrainDetails> getTrainDetailsByEndPoints(String sourceStation, String destinationStation) {
		List<TrainDetails> detList = userRepository.findAll();
		List<TrainDetails> req = new ArrayList<TrainDetails>();
		for (TrainDetails tr : detList) {
			String stat = tr.getSourceStation();
			String dest = tr.getDestinationStation();
			if (stat.equals(sourceStation) && dest.equals(destinationStation)) {
				req.add(tr);
			}
		}
		return req;
	}

}

package com.RailwayUserManagenet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.RailwayUserManagenet.model.TrainDetails;
import com.RailwayUserManagenet.model.UserSignUp;
import com.RailwayUserManagenet.service.SignUpService;
import com.RailwayUserManagenet.service.UserServiceImpl;

import io.swagger.annotations.ApiOperation;

/**
 * @author Mohammed Shuaib A T
 * Controller For User Management MicroService
 */
@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/user")
public class UserManagementController {
	/** Autowired SignUpService Object **/
	@Autowired
	private SignUpService signUpService;

	/** Autowired UserServiceImpl Object **/
	@Autowired
	private UserServiceImpl userServiceImpl;

	/** This Method Is Used To Add User Details **/
	@PostMapping("/signup")
	@ApiOperation(value = "To Add User Details")
	public String saveUser(@RequestBody UserSignUp userSignUp) {
		try {
			this.signUpService.addUser(userSignUp);
			return "User Added Successfully " + userSignUp;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Operation Failed";
	}

	/** This Method Is Used To Display All Users **/
	@GetMapping("/allusers")
	@ApiOperation(value = "To Get All The User Details")
	public List<UserSignUp> findAllUsers() {
		return signUpService.getuser();
	}

	/** This Method Is Used To Update Users By Id **/
	@PutMapping("/update")
	@ApiOperation(value = "To Update User Details")
	public String updateUser(@RequestBody UserSignUp userSignUp, @RequestParam int id) {
		this.signUpService.updateUser(id, userSignUp);
		return "Updated User with id " + id;
	}

	/** This Method Is Used To Delete Users By Id **/
	@DeleteMapping("/delete")
	@ApiOperation(value = "To Delete User Details")
	public String deleteUser(@RequestParam int id) {
		this.signUpService.deleteUser(id);
		return "Deleted User With id " + id;
	}
	

	/** This Method Is Used To Display All Trains Available For The Users **/
	@GetMapping("/alltrains")
	@ApiOperation(value = "Get all train details")
	public List<TrainDetails> getAllDetails() {
		return userServiceImpl.getAllDetails();
	}

	/** This Method Is Used To See The Ststus Of Train Using PNRNO **/
	@GetMapping("/status")
	@ApiOperation(value = "Get status of your booking by Pnr Number")
	public String getStatus(@RequestParam long pnrNo) {
		return userServiceImpl.pnrStatus(pnrNo);
	}

	/** This Method Is Used To Display Train Details Using TrainNo **/
	@GetMapping("/trainNo")
	@ApiOperation(value = "Get train details by Train Number")
	public TrainDetails getDetailsByTrainNo(@RequestParam Integer trainNo) {
		return userServiceImpl.getDetailsByTrainNo(trainNo);
	}

	/**
	 * This Method Is Used To Display Train Details Using Source And Destination
	 **/
	@GetMapping("/route/{sourceStation}/{destinationStation}")
	@ApiOperation(value = "Get train details by giving start and final locations")
	public List<TrainDetails> getTrainDetailsByStartStation(@PathVariable String sourceStation,
			@PathVariable String destinationStation) {
		return userServiceImpl.getTrainDetailsByEndPoints(sourceStation, destinationStation);
	}

}

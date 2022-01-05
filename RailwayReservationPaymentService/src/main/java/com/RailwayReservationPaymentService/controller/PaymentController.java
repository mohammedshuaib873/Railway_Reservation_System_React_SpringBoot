package com.RailwayReservationPaymentService.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.RailwayReservationPaymentService.model.PaymentDetails;
import com.RailwayReservationPaymentService.service.PaymentServiceImpl;

import io.swagger.annotations.ApiOperation;

/**
 * @author Mohammed Shuaib A T Controller For Mapping All Payment Services
 */
@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/pay")
public class PaymentController {

	@Autowired
	PaymentServiceImpl paymentServiceImpl;

	@GetMapping("/all")
	@ApiOperation(value = "Get all users who completed payment")
	public List<PaymentDetails> getAll() {
		return paymentServiceImpl.getAll();
	}

	@PostMapping("/add")
	@ApiOperation(value = "Inorder to proceed to payment")
	public String addPaymentDetails(@Valid @RequestBody PaymentDetails payment) {
		long pnrNo = payment.getPnrNo();
		paymentServiceImpl.proceedToPay(payment);
		paymentServiceImpl.updateUserPaymentDetails(payment.getPnrNo());
		String sentMsg = "Your payment is successful";
		return sentMsg;
	}

	@RequestMapping(value = "/cancel/{pnrNo}", method = { RequestMethod.GET, RequestMethod.DELETE })
	@ApiOperation(value = "Inorder to cancel your payment")
	public String deletePaymentDetails(@PathVariable long pnrNo) {
		return paymentServiceImpl.deletePayment(pnrNo);
	}

}

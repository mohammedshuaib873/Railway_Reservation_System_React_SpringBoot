package com.RailwayReservationPaymentService.service;

import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RailwayReservationPaymentService.exception.ResourceNotFoundException;
import com.RailwayReservationPaymentService.model.PaymentDetails;
import com.RailwayReservationPaymentService.model.UserDetailsData;
import com.RailwayReservationPaymentService.repository.UserPaymentRepository;
import com.RailwayReservationPaymentService.repository.UserRepository;
import com.google.common.collect.Lists;

import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
import it.ozimov.springboot.mail.service.EmailService;

/**
 * @author 
 * Mohammed Shuaib A T Service Layer For Implementing Payment Microservice
 */
@Service
public class PaymentServiceImpl implements PaymentService {
	int id;

	@Autowired
	public EmailService emailService;

	@Autowired
	UserPaymentRepository userPaymentRepository;

	@Autowired
	UserRepository userRepo;

	@Override
	public List<PaymentDetails> getAll() {
		List<PaymentDetails> payDetails = userPaymentRepository.findAll();
		return payDetails;
	}

	@Override
	public String proceedToPay(PaymentDetails payment) {
		long pnrNo = payment.getPnrNo();
		List<UserDetailsData> det = userRepo.findAll();
		for (UserDetailsData x : det) {
			if (x.getPnrNo() == pnrNo) {
				id = x.getId();
			}
		}
		userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(
				"Cannot proceed the payment request as booking is not done with PNR Number : " + pnrNo));
		userPaymentRepository.save(payment);
		try {
			sendEmail(payment);
		} catch (AddressException e) {
			e.printStackTrace();
		}
		return ("Your payment for PNR Number " + payment.getPnrNo() + " is Successful...!!!");
	}

	@Override
	public String deletePayment(long pnrNo) {
		userPaymentRepository.deleteById(pnrNo);
		return "You payment for " + pnrNo + " will be credited to your account within 7 days..";
	}

	/** To Update Payment Field In User Details After Successful Payment **/
	public void updateUserPaymentDetails(long pnrNo) {
		List<UserDetailsData> details = userRepo.findAll();
		for (UserDetailsData x : details) {
			// System.out.println(x);
			if (x.getPnrNo() == pnrNo) {
				x.setPayment("Successful");
				userRepo.save(x);
			}
		}
	}

	/** For Email Notification After Successful Payment **/
	public void sendEmail(PaymentDetails payment) throws AddressException {
		final Email email = DefaultEmail.builder().from(new InternetAddress("muhammedsuhaib873@gmail.com"))
				.replyTo(new InternetAddress("muhammedsuhaib873@gmail.com"))
				.to(Lists.newArrayList(new InternetAddress("muhammedsuhaib873@gmail.com")))
				.subject("Payment is Successful")
				.body("Your payment for PNR Number " + payment.getPnrNo() + " is Successful...!!!").encoding("UTF-8")
				.build();
		emailService.send(email);
	}

}

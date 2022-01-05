package com.RailwayReservationAdminManagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.RailwayReservationAdminManagement.model.TrainDetails;
import com.RailwayReservationAdminManagement.repository.AdminRepository;
import com.RailwayReservationAdminManagement.service.AdminService;

@RunWith(SpringRunner.class)
@SpringBootTest
class RailwayReservationAdminManagementApplicationTests {

	@Autowired
	private AdminService adminService;
	@MockBean
	private AdminRepository adminRepository;

	@Test
	public void addTrainsTest() {
		TrainDetails trainDetails = new TrainDetails(12640, "BRINDAVAN EXPRESS", "KSRBENGALURU", "MGRCHENNAICTL",
				"21:05", "15:00", "6hr 5mins", 12, 323, 456, 433, 556);
		adminService.addTrainDetails(trainDetails);
		verify(adminRepository, times(1)).save(trainDetails);
	}

	@Test
	public void getAllTrainsTest() {
		when(adminRepository.findAll()).thenReturn(Stream.of(
				new TrainDetails(12640, "BRINDAVAN EXPRESS", "KSRBENGALURU", "MGRCHENNAICTL", "21:05", "15:00",
						"6hr 5mins", 12, 323, 456, 433, 556),
				new TrainDetails(12640, "BRINDAVAN EXPRESS", "KSRBENGALURU", "MGRCHENNAICTL", "21:05", "15:00",
						"6hr 5mins", 12, 344, 322, 544, 33))
				.collect(Collectors.toList()));
		assertEquals(2, adminService.getAllDetails().size());
	}

	/*
	 * @Test public void updateTrainDetailsTest() { int rtrainNo =12650;
	 * TrainDetails trainDetails =new
	 * TrainDetails(12650,"BRINDAVAN EXPRESS","KSRBENGALURU","MGRCHENNAICTL","21:05"
	 * ,"15:00","6hr 5mins",12,323,456,433,556);
	 * adminService.updateTrainDetails(rtrainNo,trainDetails);
	 * verify(adminRepository, times(1)).save(trainDetails); }
	 */

}

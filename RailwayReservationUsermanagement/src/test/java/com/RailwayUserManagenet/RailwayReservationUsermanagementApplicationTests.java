package com.RailwayUserManagenet;

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

import com.RailwayUserManagenet.model.TrainDetails;
import com.RailwayUserManagenet.Repository.UserRepository;
import com.RailwayUserManagenet.Repository.UserSignUpRepository;
import com.RailwayUserManagenet.model.UserSignUp;
import com.RailwayUserManagenet.service.SignUpService;
import com.RailwayUserManagenet.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
class RailwayReservationUsermanagementApplicationTests {

	@Autowired
	private SignUpService signUpService;
	@MockBean
	private UserSignUpRepository userSignUpRepository;

	@Autowired
	private UserService userService;
	@MockBean
	private UserRepository userRepository;

	@Test
	public void addUsersTest() {
		UserSignUp userDetails = new UserSignUp("Shuaib", "Shuaib@gmail.com", 9895675645l, "shuaib123", "54321",
				"54321");
		signUpService.addUser(userDetails);
		verify(userSignUpRepository, times(1)).save(userDetails);
	}

	@Test
	public void deleteUsersTest() {
		long rid = 102;
		signUpService.deleteUser((int) rid);
		verify(userSignUpRepository, times(1)).deleteById((int) rid);
	}

	@Test
	public void updateUsersTest() {
		int id = 102;
		UserSignUp userDetails = new UserSignUp("Shuaib", "Shuaib@gmail.com", 9895675645l, "shuaib123", "54321",
				"54321");
		signUpService.updateUser(id, userDetails);
		verify(userSignUpRepository, times(1)).save(userDetails);
	}

	@Test
	public void getAllTrainsTest() {
		when(userRepository.findAll()).thenReturn(Stream.of(
				new TrainDetails(12640, "BRINDAVAN EXPRESS", "KSRBENGALURU", "MGRCHENNAICTL", "21:05", "15:00",
						"6hr 5mins", 12, 323, 456, 433, 556),
				new TrainDetails(12640, "BRINDAVAN EXPRESS", "KSRBENGALURU", "MGRCHENNAICTL", "21:05", "15:00",
						"6hr 5mins", 12, 344, 322, 544, 33))
				.collect(Collectors.toList()));
		assertEquals(2, userService.getAllDetails().size());
	}

}

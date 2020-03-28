package _9springTesting;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import _9springTesting.dao.TicketDAO;
import _9springTesting.dto.Ticket;
import _9springTesting.service.TicketServiceImpl;

@RunWith(JUnitPlatform.class)
//@ExtendWith(SpringExtension.class) // In junit5
//@ContextConfiguration(locations = "classpath:application-context.xml")
@ContextConfiguration(locations = "/application-context.xml")

//@ContextConfiguration(classes = {MainCLassName.class})

public class TicketServiceImplTest {

	@Mock
	TicketDAO dao;

	@Autowired
	@InjectMocks
	private TicketServiceImpl service;

	// @org.junit.Before
	@org.junit.jupiter.api.BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	// @org.junit.Test
	@org.junit.jupiter.api.Test
	public void buyTicketShouldReturnAValidValue() {
		Mockito.when(dao.createTicket(Mockito.any(Ticket.class))).thenReturn(1);
		int result = service.buyTicket("Sachin", "998678677");
		Assertions.assertEquals(1, result);
	}

}

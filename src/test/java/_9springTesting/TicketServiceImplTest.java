package _9springTesting;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import _9springTesting.dao.TicketDAO;
import _9springTesting.dto.Ticket;
import _9springTesting.service.TicketServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
class TicketServiceImplTest {

	@Mock
	TicketDAO dao;

	@Autowired
	@InjectMocks
	private TicketServiceImpl service;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void buyTicketShouldReturnAValidValue() {
		Mockito.when(dao.createTicket(Mockito.any(Ticket.class))).thenReturn(1);
		int result = service.buyTicket("Sachin", "998678677");
		Assertions.assertEquals(1, result);
	}

}

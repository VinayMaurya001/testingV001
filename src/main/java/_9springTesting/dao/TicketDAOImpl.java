package _9springTesting.dao;

import org.springframework.stereotype.Component;

import _9springTesting.dto.Ticket;

@Component
public class TicketDAOImpl implements TicketDAO {

	@Override
	public int createTicket(Ticket ticket) {
		//db communication
		return 1;
	}

}

package _9springTesting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import _9springTesting.dao.TicketDAO;
import _9springTesting.dto.Ticket;
@Component
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketDAO dao;

	@Override
	public int buyTicket(String passengerName, String phone) {
		Ticket ticket = new Ticket();
		ticket.setPassengerName(passengerName);
		ticket.setPhone(phone);
		return getDao().createTicket(ticket);
	}

	public TicketDAO getDao() {
		return dao;
	}

	public void setDao(TicketDAO dao) {
		this.dao = dao;
	}

}

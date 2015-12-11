package mod2;


import java.util.ArrayList;
import java.util.List;

public class Flights {
    private List<Ticket> tickets = new ArrayList<Ticket>();
    private List<Ticket> ticketList;

    public List<Ticket> getTickets() {
        if (ticketList == null) {
            ticketList = new ArrayList<Ticket>(tickets);
        }
        return tickets;
    }

    public boolean addTickets(Ticket ticket) {
        ticketList = null;
       return tickets.add(ticket);
    }
}

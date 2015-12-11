package mod2;


import java.util.ArrayList;
import java.util.List;

public class Flights {
    private List<Ticket> tickets = new ArrayList<Ticket>();

    public List<Ticket> getTickets() {
        return tickets;
    }

    public boolean addTickets(Ticket ticket) {
       return tickets.add(ticket);
    }
}

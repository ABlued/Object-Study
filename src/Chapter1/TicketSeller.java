package Chapter1;

public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice){
        this.ticketOffice = ticketOffice;
    }
    // 더 이상 TicketSeller에게서 ticketoffice를 접근할 수 없도록 함
    // 따라서 TicketSeller는 ticketOffice에서 티켓을 꺼내거나 판매 요금을 적립하는 일을 스스로 수행해야한다.

    // 이처럼 객체 내부의 세부적인 사항을 감추는 것을 캡슐화라하며
    // 캡슐화의 목적은 변경하기 쉬운 객체를 만드는 것이다.
    // 캡슐화를 통해 객체 내부로의 접근을 제한하면 객체와 객체 사이의 결합도를 낮출 수 있기 때문에 변경하기 용이해진다.
    public void sellTo(Audience audience){
        if(audience.getBag().hasInvitation()){
            Ticket ticket = ticketOffice.getTicket();
            audience.getBag().setTicket(ticket);
        } else {
            Ticket ticket = ticketOffice.getTicket();
            audience.getBag().minusAmount(ticket.getFee());
            ticketOffice.plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }
    }
}

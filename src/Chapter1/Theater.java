package Chapter1;

public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller){
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience){
        // enter 메소드가 하는 기능이 너무 많다.
        // 또한 다른 클래스들의 구조를 아주 깊고 자세히 알고있어야 한다.
        // 1. TicketSeller가 office안에서만 티켓을 받아야하는 것
        // 2. audience가 bag을 갖고 있다는 것
        if(audience.getBag().hasInvitation()){
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().setTicket(ticket);
        } else {
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().minusAmount(ticket.getFee());
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }
        // 이렇게 다른 클래스와의 결합도가 높으면 수정하기 용이하지도 코드를 이해하기도 어렵다.
    }
}

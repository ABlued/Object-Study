package Chapter1;

public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice){
        this.ticketOffice = ticketOffice;
    }
    // 이런 식으로 Audience가 bag을 갖고 있다는 사실을 모르게 한다면
    // Bag의 존재를 내부로 캡슐화할 수 있게 된다.

    public void sellTo(Audience audience){
        ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()));
    }
}

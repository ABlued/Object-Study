package Chapter1;

public class Audience {
    private  Bag bag;

    public Audience(Bag bag){
        this.bag = bag;
    }
    // Bag에 대한 동작을 Audience에게 직접 처리하게 하여 외부에서는
    // 더 이상 Audience가 Bag을 소유하고 있다는 사실을 알 필요 없게하자.
    public Long buy(Ticket ticket){
        if(bag.hasInvitation()){
            bag.setTicket(ticket);
            return 0L;
        } else {
            bag.setTicket(ticket);
            bag.minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }
}

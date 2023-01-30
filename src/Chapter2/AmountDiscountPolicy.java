package Chapter2;

public class AmountDiscountPolicy extends DiscountPolicy{

    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DisCountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}

package Chapter2;

public class PercentDiscountPolicy extends DiscountPolicy{

    private double percent;

    public PercentDiscountPolicy(double percent, DisCountCondition ...conditions){
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}

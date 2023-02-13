package Chapter4;


import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
// 데이터 중심의 설계
public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    private MovieType movieType;
    // discountPolicy 없어지고 할인 정책과 관련된 할인 비율, 할인 금액이 직접 정의되어 있다.
    private Money discountAmount;
    private double discountPercent;

    public Money getFee() {
        return fee;
    }

    public void setFee(Money fee) {
        this.fee = fee;
    }

    public List<DiscountCondition> getDiscountConditions() {
        return Collections.unmodifiableList(discountConditions);
    }

    public void setDiscountConditions(List<DiscountCondition> discountConditions) {
        this.discountConditions = discountConditions;
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }

    public Money getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Money discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Money calculateAmountDiscountedFee(){
        if(movieType != MovieType.AMOUNT_DISCOUNT){
            throw new IllegalArgumentException();
        }
        return fee.minus(discountAmount);
    }
    public Money calculatePercentDiscountedFee(){
        if(movieType != MovieType.AMOUNT_DISCOUNT){
            throw new IllegalArgumentException();
        }
        return fee.minus(fee.times(discountPercent));
    }

    public Money calculatePercentDiscountedFee(){
        if(movieType != MovieType.AMOUNT_DISCOUNT){
            throw new IllegalArgumentException();
        }
        return fee.minus(fee.times(discountPercent));
    } public Money calculateNoneDiscountedFee(){
        if(movieType != MovieType.NONE_DISCOUNT){
            throw new IllegalArgumentException();
        }
        return fee;
    }

    public boolean isDiscountable(LocalDateTime whenScreened, int sequence){
        for(DiscountCondition condition:discountConditions){
            if(condition.getType() == DiscountConditionType.PERIOD){
                if(condition.isDiscountable(whenScreened.getDayOfWeek(), whenScreened.toLocalTime())){
                    return true;
                }
            } else {
                if(condition.isDiscountable((sequence))){
                    return true;
                }
            }
        }
        return false;
    }

}

package Chapter4;

import java.time.Duration;
import java.util.List;
// 데이터 중심의 설계
public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DisCountCondition> disCountConditions;

    private MovieType movieType;
    // discountPolicy는 없어지고 할인 정책과 관련된 할인 비율, 할인 금액이 직접 정의되어 있다.
    private Money discountAmount;
    private double discountPercent;
}

package Chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DefaultDiscountPolicy implements DiscountPolicy {
    private List<DisCountCondition > conditions = new ArrayList<>();

    public DefaultDiscountPolicy(DisCountCondition ...conditions){
        this.conditions = Arrays.asList(conditions);
    }

    // DiscountPolicy는 할인 여부와 요금 계산에 필요한 전체적인 흐름은 정의하지만 실제로
    // 요금을 계산하는 부분은 추상 메서드이니 getDiscountAmount 메서드에게 위임한다.
    public Money calculateDiscountAmount(Screening screening){
        for(DisCountCondition each: conditions){
            if(each.isSatisfiedBy(screening)){
                return getDiscountAmount(screening);
            }
        }
        // 여기서 문제가 있다. 이미 할인 조건이 없으면 할인 요금이 0원이라는 것을 반환하기 때문이다.
        // 할인 요금이 없는 할인 정책의 필요가 없어졌다.
        // 이 문제의 해결방법은 DiscountPolicy를 인터페이스로 바꾸고 NoneDiscountPolicy가 DiscountPolicy의 getDiscountAmount() 메서드가 아닌
        // calculateDiscountAmount 오퍼레이션을 오버라이딩하도록 변경하는 것이다.
        return Money.ZERO;
    }

    // 이처럼 부모 클래스에 기본적인 알고리즘의 흐름을 구현하고 중간에 필요한 처리를 자식 클래스에게 위임하는 디자인 패턴을 TEMPLATE METHOD 패턴이라고 부른다.
    abstract protected Money getDiscountAmount(Screening screening);
}


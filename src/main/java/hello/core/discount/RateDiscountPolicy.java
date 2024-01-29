package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
// @Qualifier("mainDiscountPolicy") // 추가 구분자 부여, 오타 시 컴파일타입 오류 잡을 수가 없음(문자열이므로)
// @Primary // 우선순위 부여
@MainDiscountPolicy // 컴파일타입 오류 잡을 수가 있음 (annotation 직접 만들어서 지정)
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}

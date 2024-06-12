package hello.aop.internalcall;

import hello.aop.internalcall.aop.CallLogAspect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(CallLogAspect.class)
@SpringBootTest
class CallServiceV0Test {

    @Autowired
    CallServiceV0 callServiceV0;

    //이때는 CallLogAspect 어드바이스가 호출되지 않는다.
    //자바 언어에서 메서드 앞에 별도의 참조가 없으면 this 라는 뜻으로 자기 자신의 인스턴스를 가리킨다.
    //결과적으로 자기 자신의 내부 메서드를 호출하는 this.internal() 이 되는데, 여기서 this 는 실제 대상 객체(target)의 인스턴스를 뜻한다.
    //결과적으로 이러한 내부 호출은 프록시를 거치지 않는다. 따라서 어드바이스도 적용할수 없다.
    @Test
    void external() {
        callServiceV0.external();
    }

    //외부에서 호출하는 경우 프록시를 거치기 때문에 internal() 도 CallLogAspect 어드바이스가 적용된 것을 확인할 수 있다.
    @Test
    void internal() {
        callServiceV0.internal();
    }
}
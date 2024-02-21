package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(

        //@Configuration도 @Component가 붙어있어서 자동으로 등록이 되어버리므로 제외
        //AppConfig.java에 @Configuration이 있으므로 AppConfig와 중복될 수 있어서 제외
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    //빈 이름이 중복되면 수동 빈 등록이 우선권을 가진다.
    //그러나 잡기 어려운 버그가 생길 수 있으므로 최근 스프링 부트에서는 수동 빈 등록과 자동 빈 등록이 충돌나면 오류가 발생하도록 기본 값을 바꾸었다.
    //application.properties파일의 세팅값을 spring.main.allow-bean-definition-overriding=false 기본값으로(오버라이딩 false)
    /*
    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    */
}

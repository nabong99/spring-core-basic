package hello.democore;

import hello.democore.discount.DiscountPolicy;
import hello.democore.discount.FixDiscountPolicy;
import hello.democore.discount.RateDiscountPolicy;
import hello.democore.member.MemberRepository;
import hello.democore.member.MemberService;
import hello.democore.member.MemberServiceImpl;
import hello.democore.member.MemoryMemberRepository;
import hello.democore.order.OrderService;
import hello.democore.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    //리펙토링 후
    //역할과 구현 클래스가 한눈에 들어온다
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() { //역할
        return new MemoryMemberRepository(); //구현현
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), discountPolicy ());
    }

    @Bean
    public DiscountPolicy discountPolicy () {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy(); //사용영역이 아닌 구성영역만 변경해주면됨
    }
}

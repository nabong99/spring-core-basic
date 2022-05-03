package hello.democore;

import hello.democore.discount.FixDiscountPolicy;
import hello.democore.member.MemberService;
import hello.democore.member.MemberServiceImpl;
import hello.democore.member.MemoryMemberRepository;
import hello.democore.order.OrderService;
import hello.democore.order.OrderServiceImpl;

public class AppConfig {
    //리펙토링 후
    //역할과 구현 클래스가 한눈에 들어온다
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private MemoryMemberRepository memberRepository() { //역할
        return new MemoryMemberRepository(); //구현현
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), discountPolicy ());
    }

    private FixDiscountPolicy discountPolicy () {
        return new FixDiscountPolicy();
    }
}

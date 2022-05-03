package hello.democore;

import hello.democore.discount.FixDiscountPolicy;
import hello.democore.member.MemberService;
import hello.democore.member.MemberServiceImpl;
import hello.democore.member.MemoryMemberRepository;
import hello.democore.order.OrderService;
import hello.democore.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(),new FixDiscountPolicy());
    }
}

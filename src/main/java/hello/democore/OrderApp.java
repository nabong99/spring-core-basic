package hello.democore;

import hello.democore.member.Grade;
import hello.democore.member.Member;
import hello.democore.member.MemberService;
import hello.democore.member.MemberServiceImpl;
import hello.democore.order.Order;
import hello.democore.order.OrderService;
import hello.democore.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId =1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA",10000);

        System.out.println("order = " + order);

    }
}

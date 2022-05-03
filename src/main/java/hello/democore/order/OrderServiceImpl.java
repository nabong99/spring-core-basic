package hello.democore.order;


import hello.democore.discount.DiscountPolicy;
import hello.democore.discount.FixDiscountPolicy;
import hello.democore.discount.RateDiscountPolicy;
import hello.democore.member.Member;
import hello.democore.member.MemberRepository;
import hello.democore.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId, itemName, itemPrice,discountPrice);
    }
}

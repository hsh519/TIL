package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class OrderServiceImpl implements OrderService {
    private final MemberService memberService = new MemberServiceImpl();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member findMember = memberService.findMember(memberId);
        int discountPrice = discountPolicy.discount(findMember, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}

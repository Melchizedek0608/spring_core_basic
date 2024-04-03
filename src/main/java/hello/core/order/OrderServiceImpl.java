package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor // : 초기화 되지 않은 final 필드나, @NonNull 이 붙은 필드에 대해 생성자를 생성한다.
public class OrderServiceImpl implements OrderService {
    // final 한번생성되면 바뀌지 않는다. 즉 생성자에서만 값을 세팅할수 있다는 의미. 무조건 최초로 한번 초기화 되어야 함.
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
/*
    @RequiredArgsConstructor : 초기화 되지 않은 final 필드나, @NonNull 이 붙은 필드에 대해 생성자를 생성한다.
    ==
 */
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}

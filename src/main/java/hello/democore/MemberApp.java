package hello.democore;

import hello.democore.member.Grade;
import hello.democore.member.Member;
import hello.democore.member.MemberService;
import hello.democore.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        //MemberServiceImpl memberService = new MemberServiceImpl();

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}

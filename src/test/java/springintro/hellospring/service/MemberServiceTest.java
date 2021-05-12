package springintro.hellospring.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springintro.hellospring.domain.Member;
import springintro.hellospring.repository.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){

        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository); // DI 주입
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }


    @Test
    void join() throws  Exception{

        //given
        Member member = new Member();
        member.setName("xonmin");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예약(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when


        memberService.join(member1);

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("already exist member");
//      try {
//          memberService.join(member1); // 중복된 이름이어서 예외로 에러가 떠야 정상작동
//          fail();
//
//      }catch (IllegalStateException e){
//          assertThat(e.getMessage()).isEqualTo("already exist member")
//      }
//

    }
    @Test
    void findMember() {
    }

    @Test
    void findOne() {
    }
}
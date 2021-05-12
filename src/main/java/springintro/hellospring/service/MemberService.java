package springintro.hellospring.service;

import springintro.hellospring.domain.Member;
import springintro.hellospring.repository.MemberRepository;
import springintro.hellospring.repository.MemoryMemberRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {   //test에서도 같은 인스턴스를 사용하게 하기 위해
        this.memberRepository = memberRepository;
    }

    /* 회원가입 */

    public Long join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("already exist member");
                });
    }

    //전체 회원 조회
    public List<Member> findMember(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }


}

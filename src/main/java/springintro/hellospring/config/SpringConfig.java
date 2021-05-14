package springintro.hellospring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springintro.hellospring.domain.Member;
import springintro.hellospring.repository.MemberRepository;
import springintro.hellospring.repository.MemoryMemberRepository;
import springintro.hellospring.service.MemberService;

@Configuration
public class SpringConfig {
//Spring 에 직접 빈 등록하는 방법

//    @Bean
//    public MemberService memberService(){
//        return new MemberService(memberRepository());
//    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

}

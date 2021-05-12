package springintro.hellospring.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import springintro.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository =  new MemoryMemberRepository();


    @AfterEach
    public void afterEach(){    //순서와 상관없이 이전 저장된 테스트들의 결과들을 클리어
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("Xonmin");
        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }



    @Test
    public void findByName(){

        Member member1 = new Member();
        member1.setName("Xonmin1");
        repository.save(member1);


        Member member2 = new Member();
        member2.setName("Xonmin2");
        repository.save(member2);

        Member result = repository.findByName("Xonmin1").get();
        assertThat(result).isEqualTo(member1);
    }


    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("Xonmin1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Xonmin2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);

    }


}
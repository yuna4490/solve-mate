package com.solvemate.solvemate.domain;

import com.solvemate.solvemate.domain.member.Member;
import com.solvemate.solvemate.domain.member.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest // JPA 관련 설정 불러옴
// @Transactional 어노테이션을 포함하고 있습니다.
// 그래서 테스트가 완료되면 자동으로 롤백하기 때문에 직접 선언적 트렌젝션 어노테이션을 달아줄 필요가 없습니다.
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @AfterEach
    public void cleanup() { // 데이터 섞임 방지
        memberRepository.deleteAll();
    }

    @Test
    void saveMember(){
        Member member1 = Member.builder()
                .email("yuna4490@naver.com")
                .nickname("ddongcamel")
                .password("Haechan66!")
                .build();

        Member member2 = Member.builder()
                .email("yuna4490@naver.com")
                .nickname("ddongcamel")
                .password("Haechan66!")
                .build();

        memberRepository.save(member1);
        memberRepository.save(member2);

        List<Member> memberList = memberRepository.findAll();

        Member findMember = memberList.get(0);
        assertThat(findMember.getEmail()).isEqualTo("yuna4490@naver.com");
    }
}

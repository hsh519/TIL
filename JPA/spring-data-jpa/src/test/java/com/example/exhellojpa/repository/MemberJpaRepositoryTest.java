package com.example.exhellojpa.repository;

import com.example.exhellojpa.entity.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberJpaRepositoryTest {

    @Autowired
    MemberJpaRepository repository;

    @Test
    void 저장() {
        // given
        Member member = Member.createMember("userA", 23, null);

        // when
        Long memberId = repository.save(member);

        // then
        Member findMember = repository.find(memberId);

        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        assertThat(findMember).isEqualTo(member);
    }

    @Test
    void CRUD() {
        Member userA = Member.createMember("userA", 23, null);
        Member userB = Member.createMember("userB", 23, null);
        repository.save(userA);
        repository.save(userB);

        // 단건 조회 검증
        Member findUserA = repository.findById(userA.getId()).get();
        Member findUserB = repository.findById(userB.getId()).get();
        assertThat(findUserA).isEqualTo(userA);
        assertThat(findUserB).isEqualTo(userB);

        // 리스트 조회 검증
        List<Member> users = repository.findAll();
        assertThat(users.size()).isEqualTo(2);

        // 카운트 검증
        long count = repository.count();
        assertThat(count).isEqualTo(2);

        // 삭제 검증
        repository.delete(userA);
        repository.delete(userB);

        long afterCount = repository.count();
        assertThat(afterCount).isEqualTo(0);
    }

    @Test
    void findByUsernameAndAgeGreaterThen() {
        Member memberA = Member.createMember("AAA", 10);
        Member memberB = Member.createMember("AAA", 20);
        repository.save(memberA);
        repository.save(memberB);

        List<Member> res = repository.findByUsernameAndAgeGreaterThan("AAA", 15);

        assertThat(res.get(0).getUsername()).isEqualTo("AAA");
        assertThat(res.get(0).getAge()).isEqualTo(20);
        assertThat(res.size()).isEqualTo(1);
    }

    @Test
    void bulkUpdate() {
        repository.save(Member.createMember("member1", 10));
        repository.save(Member.createMember("member2", 10));
        repository.save(Member.createMember("member3", 21));
        repository.save(Member.createMember("member4", 30));
        repository.save(Member.createMember("member5", 40));

        int resultCount = repository.bulkAgePlus(20);

        assertThat(resultCount).isEqualTo(3);
    }

}
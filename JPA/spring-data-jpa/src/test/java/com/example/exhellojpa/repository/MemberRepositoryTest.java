package com.example.exhellojpa.repository;

import com.example.exhellojpa.dto.MemberDto;
import com.example.exhellojpa.entity.Member;
import com.example.exhellojpa.entity.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class MemberRepositoryTest {

    @Autowired
    MemberRepository repository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    EntityManager em;

    @Test
    void 저장() {
        // given
        Member member = Member.createMember("userA", 23, null);

        // when
        Member savedMember = repository.save(member);

        // then
        Member findMember = repository.findById(savedMember.getId()).get();

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
    void testQuery() {
        Member memberA = Member.createMember("AAA", 10);
        Member memberB = Member.createMember("AAA", 20);
        repository.save(memberA);
        repository.save(memberB);

        List<Member> res = repository.findUser("AAA", 10);

        assertThat(res.get(0)).isEqualTo(memberA);
    }

    @Test
    void findUsernameList() {
        Member memberA = Member.createMember("AAA", 10);
        Member memberB = Member.createMember("BBB", 20);
        repository.save(memberA);
        repository.save(memberB);

        List<String> usernameList = repository.findUsernameList();

        for (String username : usernameList) {
            System.out.println("username = " + username);
        }
    }

    @Test
    void findMemberDto() {
        Team teamA = Team.createTeam("teamA");
        teamRepository.save(teamA);

        Member memberA = Member.createMember("AAA", 10, teamA);
        repository.save(memberA);

        List<MemberDto> memberDto = repository.findMemberDto();

        for (MemberDto dto : memberDto) {
            System.out.println("dto.getId() = " + dto.getId());
            System.out.println("dto.getUsername() = " + dto.getUsername());
            System.out.println("dto.getTeamName() = " + dto.getTeamName());
        }
    }

    @Test
    void findByNames() {
        Member memberA = Member.createMember("AAA", 10);
        Member memberB = Member.createMember("BBB", 20);
        repository.save(memberA);
        repository.save(memberB);

        List<Member> res = repository.findByNames(Arrays.asList("AAA", "BBB"));

        for (Member member : res) {
            System.out.println("member = " + member);
        }
    }

    @Test
    void paging() {
        repository.save(Member.createMember("member1", 10));
        repository.save(Member.createMember("member2", 10));
        repository.save(Member.createMember("member3", 10));
        repository.save(Member.createMember("member4", 10));
        repository.save(Member.createMember("member5", 10));

        int age = 10;
        PageRequest pageRequest = PageRequest.of(2, 2, Sort.by(Sort.Direction.DESC, "username"));
        Page<Member> page = repository.findByAge(age, pageRequest);

        List<Member> content = page.getContent();
        long totalElements = page.getTotalElements();

        assertThat(content.size()).isEqualTo(1);
        assertThat(totalElements).isEqualTo(5);
        assertThat(page.getNumber()).isEqualTo(2);
        assertThat(page.getTotalPages()).isEqualTo(3);
        assertThat(page.isFirst()).isFalse();
        assertThat(page.hasNext()).isFalse();
    }

    @Test
    void bulkUpdate() {
        repository.save(Member.createMember("member1", 10));
        repository.save(Member.createMember("member2", 10));
        repository.save(Member.createMember("member3", 21));
        repository.save(Member.createMember("member4", 30));
        repository.save(Member.createMember("member5", 40));

        int resultCount = repository.bulkAgePlus(20);

        // 벌크 연산은 영속성 컨텍스트 모르게 DB 수정
//        em.flush();
//        em.clear();

        Member member5 = repository.findByUsername("member5");
        System.out.println("member5 = " + member5);

        assertThat(resultCount).isEqualTo(3);
    }

    @Test
    void findMemberLazy() {
        Team teamA = Team.createTeam("teamA");
        Team teamB = Team.createTeam("teamB");
        teamRepository.save(teamA);
        teamRepository.save(teamB);

        Member memberA = Member.createMember("AAA", 10, teamA);
        Member memberB = Member.createMember("BBB", 10, teamB);
        repository.save(memberA);
        repository.save(memberB);

        em.flush();
        em.clear();

        List<Member> members = repository.findAll();

        for (Member member : members) {
            System.out.println("member = " + member);
            System.out.println("member.getTeam().getClass() = " + member.getTeam().getClass());
            System.out.println("member.getTeam().getName() = " + member.getTeam().getName());
        }
    }

    @Test
    @Rollback(false)
    void queryHint() {
        Member member = Member.createMember("AAA", 10);
        repository.save(member);
        em.flush();
        em.clear();

        Member findMember = repository.findReadOnlyByUsername(member.getUsername());
        findMember.setUsername("BBB");
    }

    @Test
    @Rollback(false)
    void lock() {
        Member member = Member.createMember("AAA", 10);
        repository.save(member);
        em.flush();
        em.clear();

        List<Member> findMember = repository.findLockByUsername("AAA");
    }
}
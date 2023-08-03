package com.example.exhellojpa.entity;

import com.example.exhellojpa.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class MemberTest {

    @Autowired
    EntityManager em;

    @Autowired
    MemberRepository memberRepository;

    @Test
    void 저장() {
        Team teamA = Team.createTeam("teamA");
        Team teamB = Team.createTeam("teamB");
        em.persist(teamA);
        em.persist(teamB);

        Member member1 = Member.createMember("member1", 10, teamA);
        Member member2 = Member.createMember("member2", 20, teamA);
        Member member3 = Member.createMember("member3", 30, teamB);
        Member member4 = Member.createMember("member4", 40, teamB);
        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);

        em.flush();
        em.clear();

        List<Member> members = em.createQuery("select m from Member m", Member.class)
                .getResultList();

        for (Member member : members) {
            System.out.println("member = " + member);
            System.out.println("member.Team = " + member.getTeam());
        }
    }

    @Test
    @Rollback(value = false)
    void JpaEventBaseEntity() throws InterruptedException {
        // given
        Member member = Member.createMember("member1", 23);
        memberRepository.save(member); //prePersist

        Thread.sleep(3000);
        member.setUsername("member2");

        em.flush(); // preUpdate
        em.clear();

        // when
        Member findMember = memberRepository.findById(member.getId()).get();

        // then
        System.out.println("create = " + findMember.getCreateDate());
        System.out.println("update = " + findMember.getLastModifiedDate());


    }
}
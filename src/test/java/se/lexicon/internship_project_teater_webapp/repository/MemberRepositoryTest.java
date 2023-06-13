package se.lexicon.internship_project_teater_webapp.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.internship_project_teater_webapp.model.entity.Member;

import java.time.LocalDate;
import java.util.List;

@DataJpaTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    Member member1;
    Member member2;


    @BeforeEach
    public void setup() {
        member1 = memberRepository.save(new Member("member", "member1", LocalDate.parse("2020-01-01"), "member1@member.se"));
        member2 = memberRepository.save(new Member("member", "member2", LocalDate.parse("2020-01-01"), "member2@member.se"));

    }

    @Test
    public void test1_findByFirstName() {

        List<Member> members = memberRepository.findAllByFirstName("member");
        Assertions.assertEquals(2, members.size());

    }


    @Test
    public void test1_findByLastName() {

        List<Member> members = memberRepository.findAllByLastName("member1");
        Assertions.assertEquals(1, members.size());

    }

}


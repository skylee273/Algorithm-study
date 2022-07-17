package hello.jdbc.repository;

import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class MemberRepositoryV0Test {

    MemberRepositoryV0 repository = new MemberRepositoryV0();

    @Test
    void crud() throws SQLException {
        Member memberVO = new Member("member5", 10000);
        repository.save(memberVO);

        //findById
        Member findMember = repository.findById(memberVO.getMemberId());
        log.info("findMember = {}", findMember);
        log.info("member == findMember = {}", memberVO == findMember);
        log.info("member equals findMember = {}", memberVO.equals(findMember));
        assertThat(findMember).isEqualTo(memberVO);

        // update : money : 10000 -> 20000
        repository.update(memberVO.getMemberId(), 20000);
        Member updateMember = repository.findById(memberVO.getMemberId());
        assertThat(updateMember.getMoney()).isEqualTo(20000);

        //delete : memberId
        repository.delete(memberVO.getMemberId());
        assertThatThrownBy(() -> repository.findById(memberVO.getMemberId())).isInstanceOf(NoSuchElementException.class);

    }


}
package kr.soft.study;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import kr.soft.study.entity.Member;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class MemberRepository {

    private EntityManager em;

    @Transactional
    public void save(Member member) {
        em.persist(member);
    }
}

package kr.soft.study;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import kr.soft.study.entity.Member;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class MemberRepository {

    private EntityManager em;

    @Transactional
    public void save(Member member) {
        em.persist(member);
    }

    public List<Member> findAll() {
        return em.createQuery("from Member m", Member.class).getResultList();
    }
}

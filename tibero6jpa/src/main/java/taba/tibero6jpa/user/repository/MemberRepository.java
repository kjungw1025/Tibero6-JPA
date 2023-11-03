package taba.tibero6jpa.user.repository;

import org.springframework.stereotype.Repository;
import taba.tibero6jpa.user.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository {
    @PersistenceContext // JPA가 제공하는 표준 어노테이션
    private EntityManager em; // Spring이 Entity manager를 만들어서 주입하게 해줌

    public void save(Member member) {
        em.persist(member);
    }

    public List<Member> findAll() {
        List<Member> result = em.createQuery("select m from Member m", Member.class)
                .getResultList();
        return result;
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}

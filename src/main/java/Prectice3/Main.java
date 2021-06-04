package Prectice3;

import Prectice3.entity.Member;
import Prectice3.entity.MemberType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Member member = new Member();
//            member.setId(1L);
            member.setName("hello");
            member.setMemberType(MemberType.USER);
            em.persist(member);
//
//            //검색
//            String jpql = "select m from Member m where m.name like '%hello%'";
//            List<Member> result = em.createQuery(jpql, Member.class).getResultList();
//
//            //조회
//            Member findMember = em.find(Member.class, 1L);
//
//            //수정
//            member.setName("hello2");
//
//            //삭제
//            em.remove(member);
//
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}

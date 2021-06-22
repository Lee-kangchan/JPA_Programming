package Prectice7;


import Prectice7.entity.Member;
import Prectice7.entity.Team;

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
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member = new Member();
            member.setName("member1");
            member.setTeam(team);
            em.persist(member);
            //역방향(주인이 아닌 방향)만 연관관계 설정
            team.getMembers().add(member);
//            em.persist(member);

            //검색
            String jpql = "select m From Member m where m.name like '%hello%'";
            List<Member> result = em.createQuery(jpql, Member.class).getResultList();
            em.close();

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

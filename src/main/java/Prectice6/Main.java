package Prectice6;


import Prectice6.entity.Member;
import Prectice6.entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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

            em.flush();
            em.clear(); // 영속성 컨텍스트를 완전히 초기화

            Member findMember = em.find(Member.class, member.getId());
            em.detach(findMember); // 준영속이라 영속성 컨텍스트에서 벗어남 그래서 setName을 해도 영속성 컨텍스트에서 스냅샷과 엔티티비교를 하지않아 변경이 안됨
            findMember.setName("chans");

            em.close();
            Team findTeam = findMember.getTeam();
            findTeam.getName();
            System.out.println("findTeam = " + findTeam);

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

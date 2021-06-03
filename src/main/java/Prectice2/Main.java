package Prectice2;

import Prectice2.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction(); //JPA는 트랜잭션 안에서 이루어져야한다.
        tx.begin();

        try{
            Member member = new Member();
            member.setId(1L);
            member.setName("HELLO");

            em.persist(member);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}

package example;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("Student");
		EntityManager em= emf.createEntityManager();
		EntityTransaction transaction= em.getTransaction();
		
	//	Student s= new Student( "Kranti", "Pune", 570075858l);
		transaction.begin();
		//em.persist(s);
		
		Student s=em.find(Student.class, 2);
		
		if(s !=null)
		{
			s.setName("Pooja");
			s.setPhone(12345);
			em.persist(s);
		}
		else
		{
			System.out.println("Student is not present.");
		}
	//	List<Student> students = em.createQuery("select s from Student s",Student.class).getResultList();
		
//		for(Student s2: students)
//		{ 
//			System.out.println(s2);
//		}
		transaction.commit();
		System.out.println("Data Updated!");
		
		
		//System.out.println("Data Inserted");
	}
}

package example;

import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main1 {

	static EntityManagerFactory emf= Persistence.createEntityManagerFactory("Student");
	static EntityManager em= emf.createEntityManager();
	static EntityTransaction transaction= em.getTransaction();
	
	public static void insertData(Student s)
	{
		transaction.begin();
		em.persist(s);
		transaction.commit();
		System.out.println("Data Inserted!");
	}
	
	public static List<Student> readData()
	{
		List<Student> students=em.createQuery("select s from Student s", Student.class).getResultList();
		return students;
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		while (true) {
		
			System.out.println("1. Enter to the Student Database");
			System.out.println("2. Exit");
			int ip1= sc.nextInt();
			
			if(ip1==1)
			{
				System.out.println("1.Insert Data");
				System.out.println("2.Read Data");
				int ip2= sc.nextInt();
				
				switch (ip2) {
				case 1: {
					System.out.println("Enter your Name :- ");
					String name= sc.next();
					
					System.out.println("Enter your address :- ");
					String address= sc.next();
					
					System.out.println("Enter your Phone No :-");
					long phone= sc.nextLong();
					
					Student s= new Student(name, address, phone);
					insertData(s);
					break;
				}
				case 2:
				{
					List<Student> students= readData();
					for(Student s:students)
					{
						System.out.println(students);
					}
					break;
				}
				default:
					System.out.println("Invalid Input!");
				}
			}
			else
			{
				break;
			}
			
		}
	}
}








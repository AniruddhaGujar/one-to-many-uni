package com.jsp.hospital.branch;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Save {
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Aniruddha");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Hospital hospital = new Hospital();
		
		hospital.setName("Appolo");
		hospital.setGstNo("1234abcd");
		
		Branch branch1 = new Branch();
		branch1.setLocation("vashhi");
		branch1.setName("abc");
		
		Branch branch2 = new Branch();
		branch2.setLocation("thane");
		branch2.setName("xyz");
		
		
		List<Branch> branches = new ArrayList<Branch>();
		branches.add(branch1);
		branches.add(branch2);
		
		hospital.setBranches(branches);
		
		
		entityTransaction.begin();
		entityManager.persist(hospital);
		entityManager.persist(branch1);
		entityManager.persist(branch2);
		entityTransaction.commit();
		
	}
}

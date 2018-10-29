package spring_springdata_jpa.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.stereotype.Repository;

import spring_springdata_jpa.domain.Persion;

public class PersionRepositoryImpl implements IPersionDao{

	@Resource
	EntityManagerFactory entityManagerFactory;
	
	
	public EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
	
	
	@Override
	public List<Persion> findPersions(String name) {
		
		System.out.println("11111111");
		return null;
	}

}

package annotation9.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import annotation9.domain.Persion;


@Repository
public interface PersionRepositoryImpl extends JpaRepository<Persion,Long>{

}

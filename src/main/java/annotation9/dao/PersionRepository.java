package annotation9.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import annotation9.domain.Persion;


public interface PersionRepository extends JpaRepository<Persion,Long>{

}

package annotation9.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import annotation9.dao.PersionDao;
import annotation9.dao.PersionRepository;
import annotation9.dao.PersionRepository2;
import annotation9.domain.Persion;

@Service
@Transactional
public class PersionService {
	
	@Resource
	private PersionDao persionDao;
	
	@Resource
	private PersionRepository persionRepository;

	@Resource
	private PersionRepository2 persionRepository2;
	
	
	public void insert() {
		persionDao.insert("herio1");
		persionDao.insert("herio2");
		System.out.println("≤Â»ÎÕÍ≥…");
	}
	
	public void save() {
		for (long i = 0; i < 10; i++) {
			Persion persion = new Persion();
			persion.setName("èàÏn∑f");
			persion.setId(i);
			persionRepository.save(persion);
		}
	}
	
	public void findPersions(String name) {
		List<Persion> list = persionRepository2.findByName(name);
		for (Persion persion : list) {
			System.out.println(persion);
		}
	}
	
	public void findPersionsLike(String name) {
		List<Persion> list = persionRepository2.findByNameLike2(name);
		for (Persion persion : list) {
			System.out.println(persion);
		}
	}
	
	public void countPersions() {
		int count = persionRepository2.countPersions();
		System.out.println(count);
	}
	
	public void updateNameById(Long id,String name) {
		persionRepository2.updateNameById(id, name);
		Persion persion = persionRepository.getOne(id);
		System.out.println(persion);
	}
	
	public void clear() {
		persionDao.clear();
	}
}

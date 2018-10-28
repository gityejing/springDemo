package annotation9.service;

import java.util.Iterator;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import annotation9.dao.PersionDao;
import annotation9.dao.PersionRepository;
import annotation9.domain.Persion;

@Service
@Transactional
public class PersionService {
	
	@Resource
	private PersionDao persionDao;
	
	@Resource
	private PersionRepository persionRepository;
	
	
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
	
	public void clear() {
		persionDao.clear();
	}
}

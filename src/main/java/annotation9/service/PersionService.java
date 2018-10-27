package annotation9.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import annotation9.dao.PersionDao;
import annotation9.domain.Persion;

@Service
@Transactional
public class PersionService {
	
	@Resource
	private PersionDao persionDao;
	
	
	@Transactional(readOnly=false)
	public void insert() {
		persionDao.insert("herio1");
		persionDao.insert("herio2");
		System.out.println("≤Â»ÎÕÍ≥…");
	}
	
	public void save() {
		Persion persion = new Persion();
		persion.setName("èàÏn∑f");
	}
	
	public void clear() {
		persionDao.clear();
	}
}

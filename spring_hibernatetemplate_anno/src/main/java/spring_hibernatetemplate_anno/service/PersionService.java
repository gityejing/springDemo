package spring_hibernatetemplate_anno.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring_hibernatetemplate_anno.dao.PersionDao;
import spring_hibernatetemplate_anno.domain.Persion;



@Service
@Transactional
public class PersionService {
	
	@Resource
	private PersionDao persionDao;
	
	public void insert() {
		persionDao.insert("herio1");
		persionDao.insert("herio2");
		System.out.println("�������");
	}
	
	public void saveTest() {
		for (long i = 1; i <= 100; i++) {
			Persion persion = new Persion();
			persion.setId(i);
			persion.setName("����ӱ"+i);
			persionDao.save(persion);
		}
	}
	
	
	public void clear() {
		persionDao.clear();
	}
}

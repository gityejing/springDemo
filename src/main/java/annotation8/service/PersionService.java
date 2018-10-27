package annotation8.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import annotation7.dao.PersionDao;

@Service
public class PersionService {
	
	@Resource
	private PersionDao persionDao;
	
	
	@Transactional(readOnly=false)
	public void insert() {
		persionDao.insert("herio1");
		persionDao.insert("herio2");
		System.out.println("�������");
	}
	
	public void clear() {
		persionDao.clear();
	}
}

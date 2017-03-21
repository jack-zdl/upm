package com.api.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.api.dao.DictTypeDao;
import com.api.entity.DictTypeEntity;

/**
 * �ֵ�������ҵ������
 * 
 * @author HCK
 *
 */
@Service
public class DictTypeService {

	@Resource
	protected DictTypeDao dictTypeDao;

	@Cacheable("dictTypeCache")
	public List<DictTypeEntity> listDictTypeFromCache() {
		return dictTypeDao.list(null);
	}
	
//	@CacheEvict("dictTypeCache")
//	public void clear() throws APIException {
//		System.out.println("XXXXXXX");
//	}

}

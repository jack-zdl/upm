package com.api.util;

import java.util.List;

import com.api.entity.DictEntity;
import com.api.entity.DictTypeEntity;

/**
 * �ֵ乤����
 * 
 * @author HCK
 *
 */
public class DictUtils {

	/**
	 * �����ֵ������������ֵ����ͱ�����ֵ���������л�ȡ�ֵ����Ͷ���
	 * 
	 * @param dictTypeList
	 * @param dictTypeCode
	 * @param dictCode
	 * @return
	 */
	public DictEntity getDict(List<DictTypeEntity> dictTypeList, String dictTypeCode, String dictCode) {
		if (dictTypeList == null) {
			return null;
		}
		for (DictTypeEntity dictType : dictTypeList) {
			if (dictType.getCode().equals(dictTypeCode)) {
				List<DictEntity> dictList = dictType.getDictList();
				for (DictEntity dict : dictList) {
					return dict;
				}
				return null;
			}
		}
		return null;
	}
}

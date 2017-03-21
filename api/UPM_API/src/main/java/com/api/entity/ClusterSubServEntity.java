package com.api.entity;

import java.io.Serializable;

/**
 * ��Ⱥ�ӷ����������ʵ����
 * 
 * @author HCK
 *
 */
public class ClusterSubServEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ��Ⱥ
	 */
	private ClusterEntity cluster;

	/**
	 * �ӷ������
	 */
	private DefinitionSubServEntity definitionSubServ;

	/**
	 * ��ȡ��Ⱥ
	 *
	 * @return cluster ��Ⱥ
	 */
	public ClusterEntity getCluster() {
		return cluster;
	}

	/**
	 * ���ü�Ⱥ
	 * 
	 * @param cluster
	 *            ��Ⱥ
	 */
	public void setCluster(ClusterEntity cluster) {
		this.cluster = cluster;
	}

	/**
	 * ��ȡ�ӷ������
	 *
	 * @return definitionSubServ �ӷ������
	 */
	public DefinitionSubServEntity getDefinitionSubServ() {
		return definitionSubServ;
	}

	/**
	 * �����ӷ������
	 * 
	 * @param definitionSubServ
	 *            �ӷ������
	 */
	public void setDefinitionSubServ(DefinitionSubServEntity definitionSubServ) {
		this.definitionSubServ = definitionSubServ;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClusterSubServEntity [cluster=" + cluster + ", definitionSubServ=" + definitionSubServ + "]";
	}

}

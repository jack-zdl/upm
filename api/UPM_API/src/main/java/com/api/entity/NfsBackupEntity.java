package com.api.entity;

import java.io.Serializable;

/**
 * ���ݴ洢ʵ����
 * 
 * @author HCK
 *
 */
public class NfsBackupEntity extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ���ݴ洢����
	 */
	private String id;

	/**
	 * ���ݴ洢����
	 */
	private String name;

	/**
	 * nfs��ַ
	 */
	private String nfsIp;

	/**
	 * nfsԴĿ¼
	 */
	private String nfsDir;

	/**
	 * nfs����Ŀ¼
	 */
	private String nfsMountDir;

	/**
	 * nfs���ز���
	 */
	private String nfsMountOpts;

	/**
	 * �Ƿ����
	 */
	private boolean enabled;

	/**
	 * ����վ��
	 */
	private SiteEntity site;

	/**
	 * ��ȡ���ݴ洢����
	 *
	 * @return id ���ݴ洢����
	 */
	public String getId() {
		return id;
	}

	/**
	 * ���ñ��ݴ洢����
	 * 
	 * @param id
	 *            ���ݴ洢����
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * ��ȡ���ݴ洢����
	 *
	 * @return name ���ݴ洢����
	 */
	public String getName() {
		return name;
	}

	/**
	 * ���ñ��ݴ洢����
	 * 
	 * @param name
	 *            ���ݴ洢����
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ��ȡnfs��ַ
	 *
	 * @return nfsIp nfs��ַ
	 */
	public String getNfsIp() {
		return nfsIp;
	}

	/**
	 * ����nfs��ַ
	 * 
	 * @param nfsIp
	 *            nfs��ַ
	 */
	public void setNfsIp(String nfsIp) {
		this.nfsIp = nfsIp;
	}

	/**
	 * ��ȡnfsԴĿ¼
	 *
	 * @return nfsDir nfsԴĿ¼
	 */
	public String getNfsDir() {
		return nfsDir;
	}

	/**
	 * ����nfsԴĿ¼
	 * 
	 * @param nfsDir
	 *            nfsԴĿ¼
	 */
	public void setNfsDir(String nfsDir) {
		this.nfsDir = nfsDir;
	}

	/**
	 * ��ȡnfs����Ŀ¼
	 *
	 * @return nfsMountDir nfs����Ŀ¼
	 */
	public String getNfsMountDir() {
		return nfsMountDir;
	}

	/**
	 * ����nfs����Ŀ¼
	 * 
	 * @param nfsMountDir
	 *            nfs����Ŀ¼
	 */
	public void setNfsMountDir(String nfsMountDir) {
		this.nfsMountDir = nfsMountDir;
	}

	/**
	 * ��ȡnfs���ز���
	 *
	 * @return nfsMountOpts nfs���ز���
	 */
	public String getNfsMountOpts() {
		return nfsMountOpts;
	}

	/**
	 * ����nfs���ز���
	 * 
	 * @param nfsMountOpts
	 *            nfs���ز���
	 */
	public void setNfsMountOpts(String nfsMountOpts) {
		this.nfsMountOpts = nfsMountOpts;
	}

	/**
	 * ��ȡ���ݴ洢�Ƿ����
	 *
	 * @return enabled ���ݴ洢�Ƿ����
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * ���ñ��ݴ洢�Ƿ����
	 * 
	 * @param enabled
	 *            ���ݴ洢�Ƿ����
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * ��ȡ����վ��
	 *
	 * @return site ����վ�����
	 */
	public SiteEntity getSite() {
		return site;
	}

	/**
	 * ��������վ��
	 * 
	 * @param site
	 *            ����վ�����
	 */
	public void setSite(SiteEntity site) {
		this.site = site;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NfsBackupEntity [id=" + id + ", name=" + name + ", nfsIp=" + nfsIp + ", nfsDir=" + nfsDir
				+ ", nfsMountDir=" + nfsMountDir + ", nfsMountOpts=" + nfsMountOpts + ", enabled=" + enabled + ", site="
				+ site + "]";
	}

}

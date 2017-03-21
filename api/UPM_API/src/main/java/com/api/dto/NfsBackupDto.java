package com.api.dto;

import java.io.Serializable;

/**
 * ���ݴ洢���ݴ������
 * 
 * @author HCK
 *
 */
public class NfsBackupDto extends BaseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	 * ������
	 */
	private String totalSpace;

	/**
	 * ��������
	 */
	private String freeSpace;

	/**
	 * �Ƿ����
	 */
	private Boolean enabled;

	/**
	 * �Ƿ����(������ʾ)
	 */
	private String enabledText;

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
	 * ��ȡ������
	 *
	 * @return totalSpace ������
	 */
	public String getTotalSpace() {
		return totalSpace;
	}

	/**
	 * ����������
	 * 
	 * @param totalSpace
	 *            ������
	 */
	public void setTotalSpace(String totalSpace) {
		this.totalSpace = totalSpace;
	}

	/**
	 * ��ȡ��������
	 *
	 * @return freeSpace ��������
	 */
	public String getFreeSpace() {
		return freeSpace;
	}

	/**
	 * ���ÿ�������
	 * 
	 * @param freeSpace
	 *            ��������
	 */
	public void setFreeSpace(String freeSpace) {
		this.freeSpace = freeSpace;
	}

	/**
	 * ��ȡenabled
	 *
	 * @return enabled enabled
	 */
	public Boolean getEnabled() {
		return enabled;
	}

	/**
	 * ����enabled
	 *
	 * @param enabled
	 *            enabled
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * ��ȡenabledText
	 *
	 * @return enabledText enabledText
	 */
	public String getEnabledText() {
		return enabledText;
	}

	/**
	 * ����enabledText
	 *
	 * @param enabledText
	 *            enabledText
	 */
	public void setEnabledText(String enabledText) {
		this.enabledText = enabledText;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NfsBackupDto [name=" + name + ", nfsIp=" + nfsIp + ", nfsDir=" + nfsDir + ", nfsMountDir=" + nfsMountDir
				+ ", nfsMountOpts=" + nfsMountOpts + ", totalSpace=" + totalSpace + ", freeSpace=" + freeSpace
				+ ", enabled=" + enabled + ", enabledText=" + enabledText + "]";
	}

}

package com.casmall.dts.manage.biz.domain;

import com.casmall.common.BaseObject;

/**
 * ��������
 * @author OBERAK
 */
public class TsAuthMgtDTO extends BaseObject {
    private static final long serialVersionUID = 1L;
    /** �Ϸù�ȣ */
    private long auth_seq;
    /** ���� key */
    private String auth_key;
    /** ������ȣ */
    private String auth_num;
    /** �ŷ�ó�� */
    private String cst_nm;
    /** �ŷ�ó ��ȭ��ȣ */
    private String cst_tel;
    /** ��� */
    private String nt;
    /** �˻��� */
    private String search;
    
	public long getAuth_seq() {
    	return auth_seq;
    }
	public void setAuth_seq(long auth_seq) {
    	this.auth_seq = auth_seq;
    }
	public String getAuth_key() {
    	return auth_key;
    }
	public void setAuth_key(String auth_key) {
    	this.auth_key = auth_key;
    }
	public String getAuth_num() {
    	return auth_num;
    }
	public void setAuth_num(String auth_num) {
    	this.auth_num = auth_num;
    }
	public String getCst_nm() {
    	return cst_nm;
    }
	public void setCst_nm(String cst_nm) {
    	this.cst_nm = cst_nm;
    }
	public String getCst_tel() {
    	return cst_tel;
    }
	public void setCst_tel(String cst_tel) {
    	this.cst_tel = cst_tel;
    }
	public String getNt() {
    	return nt;
    }
	public void setNt(String nt) {
    	this.nt = nt;
    }
	public String getSearch() {
    	return search;
    }
	public void setSearch(String search) {
    	this.search = search;
    }
}

package com.casmall.dts.manage.biz.dao;

import java.util.ArrayList;

import com.casmall.dts.manage.biz.domain.TsAuthMgtDTO;

/**
 * �������� DAO
 * @author OBERAK
 */
public interface AuthMgtDAO {
	/**
	 * �������� ��ȸ
	 * @return
	 */
	public ArrayList<TsAuthMgtDTO> selectTsAuthMgt(TsAuthMgtDTO dto);
	
	/**
	 * �����Ϸù�ȣ ä��
	 * @return
	 */
	public long selectTsAuthMgtKey();
	
	/**
	 * �������� Insert
	 * @param dto
	 * @return
	 */
	public int insertTsAuthMgt(TsAuthMgtDTO dto);
	
	/**
	 * �������� Update
	 * @param dto
	 * @return
	 */
	public int updateTsAuthMgt(TsAuthMgtDTO dto);
}

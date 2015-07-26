package com.casmall.dts.manage.biz.mgr;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import com.casmall.common.CryptoUtil;
import com.casmall.common.db.DBManager;
import com.casmall.dts.biz.mgr.TsMstManager;
import com.casmall.dts.common.DTSConstants;
import com.casmall.dts.manage.biz.dao.AuthMgtDAO;
import com.casmall.dts.manage.biz.domain.TsAuthMgtDTO;

public class TsAuthManager {
	protected static Log logger = LogFactory.getLog(TsMstManager.class);
	
	private DBManager dbm = DBManager.getInstance();
	
	/**
	 * �������� ��ȸ
	 * @param car
	 * @return
	 * @throws Exception 
	 */
	public ArrayList<TsAuthMgtDTO> selectTsAuthMgt(TsAuthMgtDTO dto) throws Exception{
		SqlSession session = dbm.openSession();
		AuthMgtDAO dao = session.getMapper(AuthMgtDAO.class);
		try{
			ArrayList<TsAuthMgtDTO> list = dao.selectTsAuthMgt(dto);
			for(TsAuthMgtDTO au : list){
				au.setAuth_num(CryptoUtil.decrypt3DES(au.getAuth_num()));
			}
			return list;
		}finally{
			session.close();
		} // try
	}
	
	/**
	 * �����Ϸù�ȣ ä��
	 * @return
	 */
	public long selectTsAuthMgtKey(){
		SqlSession session = dbm.openSession();
		AuthMgtDAO dao = session.getMapper(AuthMgtDAO.class);
		try{
			return dao.selectTsAuthMgtKey();
		}finally{
			session.close();
		} // try
	}
	
	/**
	 * �������� Insert
	 * @param dto
	 * @return
	 * @throws IOException 
	 */
	public int insertTsAuthMgt(TsAuthMgtDTO dto) throws IOException{
		SqlSession session = dbm.openSession();
		AuthMgtDAO dao = session.getMapper(AuthMgtDAO.class);
		try{
			dto.setAuth_num(CryptoUtil.encrypt3DES(dto.getAuth_num()));
			int chk = dao.insertTsAuthMgt(dto);
			if(chk == 0){
				throw new IOException("�������� ��� �Ǽ� ����");
			}
			session.commit();
			return chk;
		}catch(Exception e){
			throw new IOException(e);
		}finally{
			session.close();
		} // try
	}
	
	/**
	 * �������� Update
	 * @param dto
	 * @return
	 * @throws IOException 
	 */
	public int updateTsAuthMgt(TsAuthMgtDTO dto) throws IOException{
		SqlSession session = dbm.openSession();
		AuthMgtDAO dao = session.getMapper(AuthMgtDAO.class);
		try{
			dto.setAuth_num(CryptoUtil.encrypt3DES(dto.getAuth_num()));
			int chk = dao.updateTsAuthMgt(dto);
			if(chk == 0){
				throw new IOException("�������� ���� �Ǽ� ����");
			}
			session.commit();
			return chk;
		}catch(Exception e){
			throw new IOException(e);
		}finally{
			session.close();
		} // try
	}
	
	/**
	 *  �������� ����
	 * @param dto
	 * @return
	 * @throws IOException 
	 */
	public int deleteTsAuthMgt(TsAuthMgtDTO dto) throws IOException{
		SqlSession session = dbm.openSession();
		AuthMgtDAO dao = session.getMapper(AuthMgtDAO.class);
		try{
			dto.setAuth_num(CryptoUtil.encrypt3DES(dto.getAuth_num()));
			dto.setDel_yn(DTSConstants.FLAG_Y);
			int chk = dao.updateTsAuthMgt(dto);
			if(chk == 0){
				throw new IOException("�������� ���� �Ǽ� ����");
			}
			session.commit();
			return chk;
		}catch(Exception e){
			throw new IOException(e);
		}finally{
			session.close();
		} // try
	}
}// class

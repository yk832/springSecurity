package com.common.security.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.common.security.dto.CustomUserDetails;

@Repository("userAuthDAO")
public class UserAuthDAO {
	
	@Inject
	private SqlSession sql;
	private static String namespace = "com.board.mappers.userMapper";
	
	public CustomUserDetails getUserById(String username) {
		// TODO Auto-generated method stub
		return sql.selectOne(namespace + ".selectUserById",username);
	}

}

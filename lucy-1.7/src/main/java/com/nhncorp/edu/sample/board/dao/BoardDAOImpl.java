package com.nhncorp.edu.sample.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.nhncorp.edu.sample.board.model.BoardInfo;

@Repository
public class BoardDAOImpl implements BoardDAO {
	private static final String NAMESPACE = "board.";
	
	@Autowired
	private SqlMapClientTemplate template;
	
	@Override
	public int getBoardCount() throws Exception {
		return (Integer) template.queryForObject(NAMESPACE + "getBoardCount");
	}

	@Override
	public int getBoardCount(String userId) throws Exception {
		return (Integer) template.queryForObject(NAMESPACE + "getBoardCountByUserId", userId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BoardInfo> getBoardList(int from, int to) throws Exception {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("from", from);
		params.put("to", to);
		return template.queryForList(NAMESPACE + "getBoardList", params);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BoardInfo> getBoardList(String userId, int from, int to) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("from", from);
		params.put("to", to);
		return template.queryForList(NAMESPACE + "getBoardListByUserId", params);
	}

	@Override
	public boolean registerBoardInfo(BoardInfo boardInfo) throws Exception {
		template.insert(NAMESPACE + "registerBoardInfo", boardInfo);
		return true;
	}

	@Override
	public BoardInfo getBoardInfo(String seq) throws Exception {
		return (BoardInfo) template.queryForObject(NAMESPACE + "getBoardInfo", Integer.parseInt(seq));
	}

	@Override
	public boolean updateBoardInfo(BoardInfo boardInfo) throws Exception {
		template.update(NAMESPACE + "updateBoardInfo", boardInfo);
		return true;
	}

	@Override
	public boolean deleteBoardInfo(String seq) throws Exception {
		template.delete(NAMESPACE + "deleteBoardInfo", Integer.parseInt(seq));
		return true;
	}

}

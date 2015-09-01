package com.nhncorp.edu.sample.board.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhncorp.edu.sample.board.dao.BoardDAO;
import com.nhncorp.edu.sample.board.model.BoardInfo;

@Service
public class BoardBoImpl implements BoardBO {
	
	@Autowired
	private BoardDAO dao;

	@Override
	public List<BoardInfo> getBoardList(int from, int to) throws Exception {
		return dao.getBoardList(from, to);
	}
	
	@Override
	public List<BoardInfo> getBoardList(String userId, int from, int to) throws Exception {
		return dao.getBoardList(userId, from, to);
	}

	@Override
	public boolean registerBoardInfo(BoardInfo boardInfo) throws Exception {
		dao.registerBoardInfo(boardInfo);
		return true;
	}

	@Override
	public BoardInfo getBoardInfo(String seq) throws Exception {
		return dao.getBoardInfo(seq);
	}

	@Override
	public boolean updateBoardInfo(BoardInfo boardInfo) throws Exception {
		return dao.updateBoardInfo(boardInfo);
	}

	@Override
	public boolean deleteBoardInfo(String seq) throws Exception {
		return dao.deleteBoardInfo(seq);
	}

	@Override
	public int getBoardCount() throws Exception {
		return dao.getBoardCount();
	}

	@Override
	public int getBoardCount(String userId) throws Exception {
		return dao.getBoardCount(userId);
	}

}

package com.nhncorp.edu.sample.board.bo;

import java.util.List;

import com.nhncorp.edu.sample.board.model.BoardInfo;

public interface BoardBO {
	public int getBoardCount() throws Exception;
	
	public int getBoardCount(String userId) throws Exception;
	
	public List<BoardInfo> getBoardList(int from, int to) throws Exception;
	
	public List<BoardInfo> getBoardList(String userId, int from, int to) throws Exception;

	public boolean registerBoardInfo(BoardInfo boardInfo) throws Exception;

	public BoardInfo getBoardInfo(String seq) throws Exception;

	public boolean updateBoardInfo(BoardInfo boardInfo) throws Exception;

	public boolean deleteBoardInfo(String seq) throws Exception;
}

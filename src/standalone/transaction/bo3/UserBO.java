package transaction.bo3;

import java.util.List;

import transaction.model.BoardUser;

public interface UserBO {
	public List<BoardUser> getBoardUserList(int st, int ed) throws Exception;

	public BoardUser getBoardUserById(String id) throws Exception;

	public boolean addBoardUser(BoardUser user) throws Exception;

	public boolean removeBoardUser(BoardUser user) throws Exception;

	public boolean removeBoardUserById(String id) throws Exception;

	public boolean updateBoardUser(BoardUser user) throws Exception;
	
	public int getUserCountById(String id) throws Exception;
}

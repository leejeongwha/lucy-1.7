package orm.jdo.dao4;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jdo.JdoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import orm.jdo.model.BoardUser;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private JdoTemplate jdoTemplate;

	@Override
	@Transactional(readOnly=true)
	public List<BoardUser> getBoardUserList(int st, int ed) throws Exception {
		List<BoardUser> list = new ArrayList<BoardUser>();
		list.addAll(jdoTemplate.find(BoardUser.class));
		return list;
	}

	@Override
	@Transactional(readOnly=true)
	public BoardUser getBoardUserById(String id) throws Exception {
		return jdoTemplate.getObjectById(BoardUser.class, id);
	}

	@Override
	@Transactional
	public boolean addBoardUser(BoardUser user) throws Exception {
		jdoTemplate.makePersistent(user);
		throw new RuntimeException();
	}

	@Override
	@Transactional
	public boolean removeBoardUser(BoardUser user) throws Exception {
		BoardUser entity = jdoTemplate.getObjectById(BoardUser.class, user.getId());
		jdoTemplate.deletePersistent(entity);
		return true;
	}

	@Override
	@Transactional
	public boolean removeBoardUserById(String id) throws Exception {
		jdoTemplate.deletePersistent(jdoTemplate.getObjectById(BoardUser.class, id));
		return true;
	}

	@Override
	@Transactional
	public boolean updateBoardUser(BoardUser user) throws Exception {
		BoardUser entity = jdoTemplate.getObjectById(BoardUser.class, user.getId());
		entity.setPasswd(user.getPasswd());
		entity.setUserName(user.getUserName());
		entity.setAge(user.getAge());
		entity.setRole(user.getRole());
		return true;
	}

	@Override
	@Transactional(readOnly=true)
	public int getUserCountById(String id) throws Exception {
		return jdoTemplate.find(BoardUser.class, "id == '" + id + "'").size();
	}

}

package orm.jdo.dao1;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jdo.support.JdoDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import orm.jdo.model.BoardUser;

@Repository
public class UserDAOImpl extends JdoDaoSupport implements UserDAO {
	@Autowired
	public UserDAOImpl(PersistenceManagerFactory persistenceManagerFactory) {
		this.setPersistenceManagerFactory(persistenceManagerFactory);
	}

	@Override
	@Transactional(readOnly=true)
	public List<BoardUser> getBoardUserList(int st, int ed) throws Exception {
		List<BoardUser> list = new ArrayList<BoardUser>();
		list.addAll(getJdoTemplate().find(BoardUser.class));
		return list;
	}

	@Override
	@Transactional(readOnly=true)
	public BoardUser getBoardUserById(String id) throws Exception {
		return getJdoTemplate().getObjectById(BoardUser.class, id);
	}

	@Override
	@Transactional
	public boolean addBoardUser(BoardUser user) throws Exception {
		getJdoTemplate().makePersistent(user);
		return true;
	}

	@Override
	@Transactional
	public boolean removeBoardUser(BoardUser user) throws Exception {
		BoardUser entity = getJdoTemplate().getObjectById(BoardUser.class, user.getId());
		getJdoTemplate().deletePersistent(entity);
		return true;
	}

	@Override
	@Transactional
	public boolean removeBoardUserById(String id) throws Exception {
		getJdoTemplate().deletePersistent(getJdoTemplate().getObjectById(BoardUser.class, id));
		return true;
	}

	@Override
	@Transactional
	public boolean updateBoardUser(BoardUser user) throws Exception {
		BoardUser entity = getJdoTemplate().getObjectById(BoardUser.class, user.getId());
		entity.setPasswd(user.getPasswd());
		entity.setUserName(user.getUserName());
		entity.setAge(user.getAge());
		entity.setRole(user.getRole());
		return true;
	}

	@Override
	@Transactional(readOnly=true)
	public int getUserCountById(String id) throws Exception {
		return getJdoTemplate().find(BoardUser.class, "id == '" + id + "'").size();
	}

}

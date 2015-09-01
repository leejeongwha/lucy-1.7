package orm.jdo.dao3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import orm.jdo.model.BoardUser;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private PersistenceManagerFactory persistenceManagerFactory;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<BoardUser> getBoardUserList(int st, int ed) throws Exception {
		List<BoardUser> list = new ArrayList<BoardUser>();
		Query query = persistenceManagerFactory.getPersistenceManager().newQuery(BoardUser.class);
		
		list.addAll((Collection<BoardUser>) query.execute());
		return list;
	}

	@Override
	@Transactional(readOnly=true)
	public BoardUser getBoardUserById(String id) throws Exception {
		return persistenceManagerFactory.getPersistenceManager().getObjectById(BoardUser.class, id);
	}

	@Override
	@Transactional
	public boolean addBoardUser(BoardUser user) throws Exception {
		persistenceManagerFactory.getPersistenceManager().makePersistent(user);
		return true;
	}

	@Override
	@Transactional
	public boolean removeBoardUser(BoardUser user) throws Exception {
		PersistenceManager persistenceManager = persistenceManagerFactory.getPersistenceManager();
		BoardUser entity = persistenceManager.getObjectById(BoardUser.class, user.getId());
		persistenceManager.deletePersistent(entity);
		return true;
	}

	@Override
	@Transactional
	public boolean removeBoardUserById(String id) throws Exception {
		PersistenceManager persistenceManager = persistenceManagerFactory.getPersistenceManager();
		BoardUser entity = persistenceManager.getObjectById(BoardUser.class, id);
		persistenceManager.deletePersistent(entity);
		return true;
	}

	@Override
	@Transactional
	public boolean updateBoardUser(BoardUser user) throws Exception {
		PersistenceManager persistenceManager = persistenceManagerFactory.getPersistenceManager();
		
		BoardUser entity = persistenceManager.getObjectById(BoardUser.class, user.getId());
		entity.setPasswd(user.getPasswd());
		entity.setUserName(user.getUserName());
		entity.setAge(user.getAge());
		entity.setRole(user.getRole());
		
		persistenceManager.makePersistent(entity);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public int getUserCountById(String id) throws Exception {
		Query query = persistenceManagerFactory.getPersistenceManager().newQuery(BoardUser.class, "id == '" + id + "'");
		return ((Collection<BoardUser>) query.execute()).size();
	}

}

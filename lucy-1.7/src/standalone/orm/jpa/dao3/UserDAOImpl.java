package orm.jpa.dao3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import orm.jpa.model.BoardUser;

@Repository
public class UserDAOImpl implements UserDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(readOnly=true)
	@SuppressWarnings("unchecked")
	public List<BoardUser> getBoardUserList(int st, int ed) throws Exception {
		Query query = entityManager.createQuery("FROM board_user");
		return query.getResultList();
	}

	@Override
	@Transactional(readOnly=true)
	public BoardUser getBoardUserById(String id) throws Exception {
		return entityManager.find(BoardUser.class, id);
	}

	@Override
	@Transactional
	public boolean addBoardUser(BoardUser user) throws Exception {
		entityManager.persist(user);
		return true;
	}

	@Override
	@Transactional
	public boolean removeBoardUser(BoardUser user) throws Exception {
		BoardUser entity = entityManager.find(BoardUser.class, user.getId());
		entityManager.remove(entity);
		return true;
	}

	@Override
	@Transactional
	public boolean removeBoardUserById(String id) throws Exception {
		BoardUser entity = entityManager.find(BoardUser.class, id);
		entityManager.remove(entity);
		return true;
	}

	@Override
	@Transactional
	public boolean updateBoardUser(BoardUser user) throws Exception {
		BoardUser entity = entityManager.find(BoardUser.class, user.getId());
		entity.setPasswd(user.getPasswd());
		entity.setUserName(user.getUserName());
		entity.setAge(user.getAge());
		entity.setRole(user.getRole());
		entityManager.persist(entity);
		return true;
	}

	@Override
	@Transactional(readOnly=true)
	public int getUserCountById(String id) throws Exception {
		Query query = entityManager.createQuery("FROM board_user WHERE id = '" + id + "'");
		return query.getResultList().size();
	}
}

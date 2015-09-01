package orm.jpa;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import orm.jpa.bo3.UserBO;
import orm.jpa.model.BoardUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/orm/jpa/applicationContext3.xml")
public class JpaCase3 {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserBO bo;
	
	@Test
	public void testGetById() throws Exception {
		BoardUser boardUser = bo.getBoardUserById("admin");
		
		logger.info(boardUser.getId() + "\t" +  boardUser.getPasswd() + "\t" + boardUser.getUserName() + "\t" +  + boardUser.getAge() + "\t" + boardUser.getRole());
	}
	
	@Test
	public void testAdd() throws Exception {	
		BoardUser newUser = new BoardUser();
		newUser.setId("id");
		newUser.setPasswd("passwd");
		newUser.setUserName("이름");
		newUser.setAge(30);
		newUser.setRole("ADMIN");
		
		logger.info("" + bo.addBoardUser(newUser));
		logger.info("" + bo.getUserCountById(newUser.getId()));
		
		List<BoardUser> list = bo.getBoardUserList(0, 10);
		
		for (BoardUser userElem : list) {
			logger.info(userElem.getId() + "\t" +  userElem.getPasswd() + "\t" + userElem.getUserName() + "\t" +  + userElem.getAge() + "\t" + userElem.getRole());
		}
	}
		
	@Test
	public void testUpdate() throws Exception {	
		BoardUser boardUser = bo.getBoardUserById("id");
		boardUser.setUserName("새이름");
		
		bo.updateBoardUser(boardUser);
		
		List<BoardUser> list = bo.getBoardUserList(0, 10);
		
		for (BoardUser userElem : list) {
			logger.info(userElem.getId() + "\t" +  userElem.getPasswd() + "\t" + userElem.getUserName() + "\t" +  + userElem.getAge() + "\t" + userElem.getRole());
		}
	}
		
	@Test
	public void testDelete() throws Exception {
		BoardUser newUser = new BoardUser();
		newUser.setId("id");
		bo.removeBoardUser(newUser);
		bo.removeBoardUserById("admin");
		
		List<BoardUser> list = bo.getBoardUserList(0, 10);
		
		for (BoardUser userElem : list) {
			logger.info(userElem.getId() + "\t" +  userElem.getPasswd() + "\t" + userElem.getUserName() + "\t" +  + userElem.getAge() + "\t" + userElem.getRole());
		}
	}
}
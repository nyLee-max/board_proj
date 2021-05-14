package board_proj.dao.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import board_proj.JdbcUtil;
import board_proj.dto.BoardDTO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BoardDaoImplTest {
	private static Connection con = JdbcUtil.getConnection();
	private static BoardDaoImpl dao = BoardDaoImpl.getInstance();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao.setCon(con);
	}


	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test01NextBoardNum() {
		System.out.println("testNextBoardNum");
		int res = dao.nextBoardNum();
		Assert.assertNotEquals(0, res);
		System.out.printf("next Number >> "+ res);
	}
	@Test
	public void testBoardDaoImpl() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetInstance() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCon() {
		fail("Not yet implemented");
	}

	@Test
	public void test02SelectListCount() {
		System.out.println("testSelectListCount");
		int res = dao.selectListCount();
		
		Assert.assertNotEquals(-1, res);
		System.out.printf("Listcount >> "+ res);

	}

	@Test
	public void test03SelectArticleList() {
		System.out.println("testSelectArticleList");
		int page = 1;
		int limit = 10;
		ArrayList<BoardDTO> list = dao.selectArticleList(page, limit);
		Assert.assertNotNull(list);
		
		list.stream().forEach(System.out::println);
		dao.selectArticleList(2, 10).stream().forEach(System.out::println);
		
		
		
	}

	@Test
	public void test05SelectArticle() {
		System.out.println("testSelectArticle");
		BoardDTO board = dao.selectArticle(1);
		Assert.assertNotNull(board);
		System.out.println(board);
	}

	@Test
	public void test04InsertArticle() {
		System.out.println("testInsertArticle");
		BoardDTO newBoard = new BoardDTO(
				"김상건",
				"1234",
				"5시 퇴근가능할까?",
				"불가능 함",
				"test.txt"
			);
		int res = dao.insertArticle(newBoard);
		Assert.assertEquals(1, res);
		
		
	}

	@Test
	public void test10InisertReplyArticle() {
		System.out.println("test10InisertReplyArticle");
		BoardDTO replyArticle = new BoardDTO("유한솔", "1111", "앙데4", "절대로4", "");
		
		replyArticle.setBoard_re_ref(28);
		int res = dao.inisertReplyArticle(replyArticle);
		Assert.assertEquals(1, res);
		System.out.println("res >>"+res);

		
	}

	@Test
	public void test08UpdateArticle() {
		System.out.println("test08UpdateArticle");
		int board_num = 30;
		BoardDTO article = dao.selectArticle(board_num);
		int res = dao.updateArticle(article);
		Assert.assertEquals(1, res);
		
		System.out.println("res >>"+res);
	}

	@Test
	public void test09DeleteArticle() {
		System.out.println("testDeleteArticle");
		int board_num = dao.nextBoardNum()-1;
		int res = dao.deleteArticle(board_num);
		Assert.assertEquals(1, res);
		System.out.println("res >>"+res);
	}

	@Test
	public void testUpdateReadCount() {
		System.out.println("testUpdateReadCount");
		int res = dao.updateReadCount(24);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectArticle(24));
	}

	@Test
	public void test07IsArticleBoardWriter() {
		System.out.println("test07IsArticleBoardWriter");
		int board_num = 22;
		boolean res = dao.isArticleBoardWriter(board_num, "bb");
		Assert.assertEquals(true, res);
		System.out.println("res >>"+res);
	}

}

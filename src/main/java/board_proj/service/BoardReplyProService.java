package board_proj.service;

import java.sql.Connection;

import board_proj.dao.impl.BoardDaoImpl;
import board_proj.ds.JndiDs;
import board_proj.dto.BoardDTO;

public class BoardReplyProService {
	   private static BoardDaoImpl dao = BoardDaoImpl.getInstance();
	   private Connection con = JndiDs.getConnection();
	   
	   public BoardReplyProService() {
		   dao.setCon(con);
	   }
	   
	   public boolean replyArticle(BoardDTO article) {
		   return dao.inisertReplyArticle(article) == 1 ? true : false;
	   }
}


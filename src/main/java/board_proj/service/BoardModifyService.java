package board_proj.service;

import java.sql.Connection;

import board_proj.dao.impl.BoardDaoImpl;
import board_proj.ds.JndiDs;
import board_proj.dto.BoardDTO;

public class BoardModifyService {
	   private static BoardDaoImpl dao = BoardDaoImpl.getInstance();
	   private Connection con = JndiDs.getConnection();
	   
	   public BoardModifyService() {
		   dao.setCon(con);
	   }
	   
	   public BoardDTO getArticle(int board_num) {
		
		   return dao.selectArticle(board_num);
	   }
}


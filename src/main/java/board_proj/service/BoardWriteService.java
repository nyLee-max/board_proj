package board_proj.service;

import java.sql.Connection;
import java.util.ArrayList;

import board_proj.dao.impl.BoardDaoImpl;
import board_proj.ds.JndiDs;
import board_proj.dto.BoardDTO;

public class BoardWriteService {
	private BoardDaoImpl  dao =  BoardDaoImpl.getInstance();
	private Connection con = JndiDs.getConnection();
	
	public BoardWriteService() {
		dao.setCon(con);
	}
    public boolean registerArticle(BoardDTO boardDTO) {
        return dao.insertArticle(boardDTO) == 1? true : false;
     }
    
    public int getListCount() {
    	return dao.selectListCount();
    }
    
    public ArrayList<BoardDTO> getArticleList(int page, int limit){
    	return dao.selectArticleList(page, limit);
    }
}

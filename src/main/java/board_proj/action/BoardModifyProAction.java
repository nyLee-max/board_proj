package board_proj.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board_proj.dto.ActionForward;
import board_proj.dto.BoardDTO;
import board_proj.service.BoardModifyProService;

public class BoardModifyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String pass = request.getParameter("board_pass");
		int page = Integer.parseInt(request.getParameter("page"));
		BoardModifyProService service = new BoardModifyProService();
		
		ActionForward forward = new ActionForward();
		
		boolean isArticleWriter = service.isArticleWriter(board_num, pass);
		if(!isArticleWriter) {
			sendMessage(response,"수정할 권한이 없습니다.");
			return forward;
		}
		BoardDTO article = new BoardDTO();
		
		String board_subject = request.getParameter("board_subject");
		String board_content = request.getParameter("board_content");
		
		article.setBoard_num(board_num);
		article.setBoard_subject(board_subject);
		article.setBoard_content(board_content);
		boolean isModifySuccess = service.modifyArticle(article);
		if(!isModifySuccess) {
			sendMessage(response,"수정 실패");
			return forward;
		}
		
		forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("boardDetail.do?board_num="+board_num+"&page="+page);
//		forward.setPath("boardDetail.do?board_num=40&page=1);
		
		System.out.println(forward.toString());
		return forward;
	}

	private void sendMessage(HttpServletResponse response, String msg) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('"+msg+"')");
		out.println("history.back()");
		out.println("</script>");
		out.close();
		
	}

}

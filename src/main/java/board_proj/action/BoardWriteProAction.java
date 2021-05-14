package board_proj.action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board_proj.dto.ActionForward;
import board_proj.dto.BoardDTO;
import board_proj.service.BoardWriteService;

public class BoardWriteProAction implements Action {

	@Override
	   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	      
	      String realFolder = "";
	      String saveFolder = "/boardUpload";
	      int fileSize = 5 * 1024 * 1024; // 5M
	      
	      ServletContext context = request.getServletContext();
	      realFolder = context.getRealPath(saveFolder);
	      
	      
	      
	      MultipartRequest multi = new MultipartRequest(
	            request, 
	            realFolder, 
	            fileSize, 
	            "utf-8", 
	            new DefaultFileRenamePolicy());
	      BoardDTO boardDTO = new BoardDTO();
	      boardDTO.setBoard_name(multi.getParameter("board_name"));
	      boardDTO.setBoard_pass(multi.getParameter("board_pass"));
	      boardDTO.setBoard_subject(multi.getParameter("board_subject"));
	      boardDTO.setBoard_content(multi.getParameter("board_content"));
	      boardDTO.setBoard_file(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
	      
	      System.out.println("realFolder >> " + realFolder);
	      System.out.println("boardDto >> " + boardDTO);
	      
	      // service필요
	      BoardWriteService service = new BoardWriteService();
	      boolean result = service.registerArticle(boardDTO);
	      
	      ActionForward forward = null;
	      if(result) {
	         forward = new ActionForward();
	         forward.setRedirect(true);
	         forward.setPath("boardList.do");
	      } else {
	         PrintWriter out = response.getWriter();
	         out.println("<script>");
	         out.println("alert('등록실패')");
	         out.println("history.back()");
	         out.println("</script>");
	      }
	      
	      return forward;
	   }
	}



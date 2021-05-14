package board_proj.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board_proj.action.Action;
import board_proj.action.BoardDeleteProAction;
import board_proj.action.BoardDetailAction;
import board_proj.action.BoardListAction;
import board_proj.action.BoardModifyFormAction;
import board_proj.action.BoardModifyProAction;
import board_proj.action.BoardReplyFormAction;
import board_proj.action.BoardReplyProAction;
import board_proj.action.BoardWriteFormAction;
import board_proj.action.BoardWriteProAction;
import board_proj.action.FileDownloadAction;
import board_proj.dto.ActionForward;
import board_proj.service.BoardDetailService;

@WebServlet(urlPatterns = {"*.do"},
			loadOnStartup = 1,
			initParams = {@WebInitParam(
					name="configFile", 
					value="/WEB-INF/commandAction.properties")
			}
		)
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Action> actionMap = new HashMap<>();

	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() - config "+config.getInitParameter("configFile"));
		String configFile = config.getInitParameter("configFile");
		try(InputStream is = config.getServletContext().getResourceAsStream(configFile)){
			Properties props = new Properties();
			props.load(is);
			
			System.out.println("props "+ props);
			for(Entry<Object, Object> entry: props.entrySet()) {
//				System.out.println(entry.getKey() + " : "+ entry.getValue());
				Class<?> cls = Class.forName((String)entry.getValue());
				Action action = (Action) cls.newInstance();
				actionMap.put((String)entry.getKey(), action);
			}
			
//			for(Entry<String, Action> entry : actionMap.entrySet()) {
//				System.out.println(entry.getKey() + " : "+ entry.getValue());
//
//			}
		} catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public BoardFrontController() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String requestURI= request.getRequestURI();
//		String contextPath = request.getContextPath();
		String command = request.getServletPath();

//		String command = requestURI.substring(contextPath.length());
//		System.out.println(requestURI + " >> "+contextPath + " >> "+ command);
		System.out.println(command);

		ActionForward forward = null;
		Action action = null;
		
		action = actionMap.get(command);
		try {
			forward = action.execute(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
/*
		if (command.equals("/boardWriterForm.do")) {
			action = new BoardWriteFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (command.equals("/boardWriterPro.do")) {
			action = new BoardWriteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardList.do")) {
			action = new BoardListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardDetail.do")) {
			action = new BoardDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardReplyForm.do")) {
			action = new BoardReplyFormAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardDeleteForm.do")) {
			String nowPage = request.getParameter("page");
			request.setAttribute("page", nowPage);

			int board_num = Integer.parseInt(request.getParameter("board_num"));
			request.setAttribute("board_num", board_num);

			forward = new ActionForward();
			forward.setPath("/board/qna_board_delete.jsp");
		} else if (command.equals("/boardDeletePro.do")) {
			// board_num = 26, board_pass= bb
			action = new BoardDeleteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/fileDown.do")) {
			action = new FileDownloadAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/boardModifyForm.do")) {
			String page = request.getParameter("page");
			request.setAttribute("page", page);

			action = new BoardModifyFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardModifyPro.do")) {

			action = new BoardModifyProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardReplyForm.do")) {
			action = new BoardReplyFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/boardReplyPro.do")) {
			action = new BoardReplyProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
*/		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				request.getRequestDispatcher(forward.getPath()).forward(request, response);

			}
		}
	}

}

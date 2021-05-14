package board_proj.dto;

public class ActionForward {
	private String path;
	private boolean Redirect;
	
	public ActionForward() {

	}
	public ActionForward(String path, boolean redirect) {
		super();
		this.path = path;
		this.Redirect = redirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return Redirect;
	}
	public void setRedirect(boolean redirect) {
		this.Redirect = redirect;
	}
	
	
}

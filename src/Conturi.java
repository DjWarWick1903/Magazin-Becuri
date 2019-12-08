import java.io.Serializable;

public class Conturi implements Serializable{
	
	private String username,password;
	private static final long serialVersionUID = 1L;
	
	public Conturi(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getPass() {
		return password;
	}
	
	public String getUser() {
		return username;
	}
}
package domain;

public class User {
	private String username;
	private int id;
	private String password;
	private String email;
	private String type;
	private String authority;
	
	public String getName() {
		return username;
	}

	public void setName(String name) {
		this.username = name;
	}
	
	public String getemail(){
		return email;
	}
	
	public void setemail(String email){
		this.email=email;
	}
	
	public String gettype(){
		return type;
	}
	
	public void settype(String type){
		this.type=type;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getAuthority(){
		return authority;
	}
	public void setAuthority(String authority){
		this.authority = authority;
	}
}

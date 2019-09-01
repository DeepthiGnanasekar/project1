package Model;

public class UserDetails {
	
	   private String name;
       private long mob_no;
       private String setPassword;
       
       @Override
   	public String toString() {
   		          return "UserDetails [name=" + name + ", mob_no=" + mob_no + ", setPassword=" + setPassword+ "]";
       }
       
           public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobilenumber() {
		        return mob_no;
	}
	public void getMobilenumber(long mob_no) {
		this.mob_no = mob_no;
	}
	public String getSetPassword() {
		return setPassword;
	}
	public void setSetPassword(String setPassword) {
		this.setPassword = setPassword;
	}
		
}

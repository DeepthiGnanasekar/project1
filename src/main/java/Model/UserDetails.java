package Model;

public class UserDetails {
	   private int id;
	   private String name;
       private long mob_no;
       private String setPassword;
       
       
       @Override
   	public String toString() {
   		          return "UserDetails [id=" + id + ",name=" + name + ", mob_no=" + mob_no + ", setPassword=" + setPassword+ "]";
       }
       public int getID() {
   		return id;
   	}

   	public void setID(int id) {
   		this.id = id;
   	}
           public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobile_number() {
		        return mob_no;
	}
	public void setMobile_number(long mob_no) {
		this.mob_no = mob_no;
	}
	public String getSet_Password() {
		return setPassword;
	}
	public void setSet_Password(String setPassword) {
		this.setPassword = setPassword;
	}
	
}
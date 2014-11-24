package application.models;

import application.models.roles.IRole;



public class BaseUser extends User {

	
	public BaseUser() {
		// TODO Auto-generated constructor stub
	}
		
	public BaseUser(String username, IRole role) {
		super(username, role);
	}

	@Override
	public String getRoleName() {
		if(role == null) {
			return "";
		}
		return this.role.toString();
	}
	
	public String create(Job job) {
		String out = "";
		if(role != null) {
			out += role.create(job);
		}
		return out;
	}
	
	public String update(Job job) {
		String out = "";
		if(role != null) {
			out += role.update(job);
		}
		return out;
	}
	
	public String view(Job job){
		String out = "";
		if(role != null) {
			out += role.view(job);
		}
		return out;
	}
	
	public String delete(Job job){
		String out = "";
		if(role != null) {
			out += role.delete(job);
		}
		return out;
	}
	
	public String start(Job job) {
		String out = "";
		if(role != null) {
			out += role.start(job);
		}
		return out;
	}
	
	public String stop(Job job){
		String out = "";
		if(role != null) {
			out += role.stop(job);
		}
		return out;
	}
}

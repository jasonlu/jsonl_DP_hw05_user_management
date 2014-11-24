package application.models.roles;

import application.models.Job;

public class DeveloperRole implements IRole {

	public DeveloperRole() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String create(Job job) {
		// TODO Auto-generated method stub
		return "I can create, trust me, I'm a developer";
	}

	@Override
	public String update(Job job) {
		// TODO Auto-generated method stub
		return "I can update, trust me, I'm a developer";

	}

	@Override
	public String delete(Job job) {
		// TODO Auto-generated method stub
		return "";

	}

	@Override
	public String view(Job job) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String start(Job job) {
		// TODO Auto-generated method stub
		return "";

	}

	@Override
	public String stop(Job job) {
		// TODO Auto-generated method stub
		return "";

	}

	public String toString() {
		return "Developer";
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 4;
	}

}

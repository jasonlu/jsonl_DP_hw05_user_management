package application.models.roles;

import application.models.Job;

public class AdministratorRole implements IRole {

	public AdministratorRole() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String create(Job job) {
		// TODO Auto-generated method stub
		return "I can create, a job just created";
	}

	@Override
	public String update(Job job) {
		// TODO Auto-generated method stub
		return "I can update, a job just updated";
	}

	@Override
	public String delete(Job job) {
		// TODO Auto-generated method stub
		return "I can delete, a job just deleted";

	}

	@Override
	public String view(Job job) {
		// TODO Auto-generated method stub
		return "I can see";

	}

	@Override
	public String start(Job job) {
		// TODO Auto-generated method stub
		return "I can start a job, a job just stated";

	}

	@Override
	public String stop(Job job) {
		// TODO Auto-generated method stub
		return "I can stop a job, a job just stop";
	}
	
	public String toString() {
		return "Administrator";
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 1;
	}

}

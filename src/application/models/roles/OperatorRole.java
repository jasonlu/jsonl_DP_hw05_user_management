package application.models.roles;

import application.models.Job;

public class OperatorRole implements IRole {

	public OperatorRole() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String create(Job job) {
		// TODO Auto-generated method stub
		return "";

	}

	@Override
	public String update(Job job) {
		// TODO Auto-generated method stub
		return "";
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
		return "I am a smooth operator, a job just started";
	}

	@Override
	public String stop(Job job) {
		// TODO Auto-generated method stub
		return "Oops, a job just stoped";
	}
	
	public String toString() {
		return "Operator";
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 2;
	}

}

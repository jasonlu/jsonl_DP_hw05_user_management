package application.models.roles;

import application.models.Job;

public class MonitorRole implements IRole {

	public MonitorRole() {
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
		return "I am a Monitor, I see every thing";
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
		return "Monitor";
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 3;
	}
}

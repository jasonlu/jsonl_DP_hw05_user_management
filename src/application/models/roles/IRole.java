package application.models.roles;

import application.models.Job;

public interface IRole {
	String create(Job job);
	String update(Job job);
	String delete(Job job);
	String view(Job job);
	String start(Job job);
	String stop(Job job);
	int getId();
	String toString();
}

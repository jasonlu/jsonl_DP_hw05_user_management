package application.models;

import java.util.UUID;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleLongProperty;
import application.models.roles.IRole;


public abstract class User {
	
	protected  SimpleLongProperty id;
	protected  SimpleStringProperty username;
	protected  SimpleStringProperty uuid;
	protected  IRole role;
	
	public abstract String getRoleName();
	
	
	public void setId(long id) {
		this.id.set(id);
	}
	
	
	public long getId() {
		return id.get();
	}

	public String getUuid() {
		return uuid.get();
	}
	
	public String getUsername() {
		return username.get();
	}

	public void setUsername(String username) {
		this.username.set(username);
	}
	
	public void setRole(IRole role){
		this.role = role;
	}
	
	public IRole getRole() {
		return role;
	}

	public User() {
		id = new SimpleLongProperty(-1);
		username = new SimpleStringProperty("");
		uuid = new SimpleStringProperty("");
	}
	
	
	public User(String username, IRole role) {
		this();
		this.uuid.set(UUID.randomUUID().toString());
		this.username.set(username);
		this.role = role;
	}
	
	
	@Override
	public String toString() {
		return "id:" + id.get() + " username:" + username.get() + " role:" + role;
	}
	
	
	public abstract String create(Job job) ;
	public abstract String update(Job job);
	public abstract String view(Job job);
	public abstract String delete(Job job);
	public abstract String start(Job job);
	public abstract String stop(Job job);



}

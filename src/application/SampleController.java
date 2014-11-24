package application;

import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.models.BaseUser;
import application.models.Job;
import application.models.User;
import application.models.roles.AdministratorRole;
import application.models.roles.DeveloperRole;
import application.models.roles.IRole;
import application.models.roles.MonitorRole;
import application.models.roles.OperatorRole;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SampleController {

	@FXML private TextArea tareaOutput;
	@FXML private ComboBox<IRole> cboxRole;
	@FXML private TextField tfUsername;
	@FXML private Button btnNewUser;
	@FXML private Button btnSave;
	@FXML private Button btnCreate;
	@FXML private Button btnUpdate;
	@FXML private Button btnView;
	@FXML private Button btnDelete;
	@FXML private Button btnStart;
	@FXML private Button btnStop;
	
	@FXML private TableView<User> tbUserTable;
	@FXML private AnchorPane vDetileView;
	
	private ObservableList<User> tableData;
	private ArrayList<User> users;
    private User currentUser;
    private Log log;
	
    
    @FXML protected void btnCreateClicked(ActionEvent event) {
    	log.put(currentUser.create(new Job()));
    	loadLog();
    }
    @FXML protected void btnUpdateClicked(ActionEvent event) {
    	log.put(currentUser.update(new Job()));
    	loadLog();
    }
    @FXML protected void btnDeleteClicked(ActionEvent event) {
    	log.put(currentUser.delete(new Job()));
    	loadLog();
    }
    @FXML protected void btnViewClicked(ActionEvent event) {
    	log.put(currentUser.view(new Job()));
    	loadLog();
    }
    @FXML protected void btnStartClicked(ActionEvent event) {
    	log.put(currentUser.start(new Job()));
    	loadLog();
    }
    @FXML protected void btnStopClicked(ActionEvent event) {
    	log.put(currentUser.stop(new Job()));
    	loadLog();
    }
    
    @FXML protected void btnNewUserClicked(ActionEvent event) {
    	currentUser = null;
    	tfUsername.setText("");
    }
    @FXML protected void cboxSelectionChanged(ActionEvent event) {
    	//System.out.println("cboxSelectionChanged");
    	if(currentUser == null) {
    		return;
    	}
    	IRole r = cboxRole.getSelectionModel().getSelectedItem();
    	
    	currentUser.setRole(r);
    	loadUsers();
    }
    
    @FXML protected void btnSaveClicked(ActionEvent event) {
    	loadUsers();
		initButtons();
    }
    @FXML void initialize() {
    	users = new ArrayList<User>();
		users.add(new BaseUser("Chuck Bartowski", new AdministratorRole()));
		users.add(new BaseUser("John Casey", new OperatorRole()));
		users.add(new BaseUser("Sarah Walker", new MonitorRole()));
		users.add(new BaseUser("General Diane Beckman", new MonitorRole()));
		users.add(new BaseUser("Morgan Grimes", new DeveloperRole()));
    	log = Log.sharedInstance();
		loadUsers();
		initButtons();
		cboxRole.getItems().clear();
		//ArrayList<Role> roles = Role.all();
		ArrayList<IRole> roles = new ArrayList<IRole>();
		roles.add(new AdministratorRole());
		roles.add(new OperatorRole());
		roles.add(new MonitorRole());
		roles.add(new DeveloperRole());
		
		cboxRole.getItems().addAll(roles);
		btnSave.setDisable(false);
    }

    private void loadLog() {
    	tareaOutput.setText(log.get());
    }
    
    private void initButtons() {
    	btnNewUser.setVisible(false);
    	btnSave.setVisible(false);
    	if(currentUser == null) {
	    	btnSave.setDisable(true);
	    	btnCreate.setDisable(true);
	    	btnUpdate.setDisable(true);
	    	btnView.setDisable(true);
	    	btnDelete.setDisable(true);
	    	btnStart.setDisable(true);
	    	btnStop.setDisable(true);
    	} else {
        	btnSave.setDisable(false);
        	btnCreate.setDisable(false);
        	btnUpdate.setDisable(false);
        	btnView.setDisable(false);
        	btnDelete.setDisable(false);
        	btnStart.setDisable(false);
        	btnStop.setDisable(false);
    	}
    }
    
    private void loadUsers() {
    	tbUserTable.getColumns().clear();
    	TableColumn idCol = new TableColumn("id");
    	idCol.setMaxWidth(30);
		idCol.setCellValueFactory(new PropertyValueFactory<User, String>("uuid"));
 
        TableColumn usernameCol = new TableColumn("User name");
        usernameCol.setMinWidth(30);
        usernameCol.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
 
        TableColumn roleCol = new TableColumn("Role");
        roleCol.setMinWidth(20);
        roleCol.setCellValueFactory(new PropertyValueFactory<User, Integer>("roleName"));
        
        
		tableData = FXCollections.observableArrayList();
		tableData.addAll(users);
		tbUserTable.setItems(tableData);
		tbUserTable.getColumns().addAll(idCol, usernameCol, roleCol);
		
		 //Add change listener
		tbUserTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<Object>() {
				@Override
				public void changed(ObservableValue<?> arg0, Object arg1, Object arg2) {
					User u = tbUserTable.getSelectionModel().selectedItemProperty().get();
					if(u == null) {
						return;
					}
					
					currentUser = u;
					tfUsername.setText(u.getUsername());
					IRole r = u.getRole();
					Object[] roles = cboxRole.getItems().toArray();
					int i = 0;
					for(Object o : roles) {
						if(o.getClass().equals(r.getClass())) {
							cboxRole.getSelectionModel().select(i);
							break;
						}
						i++;
					}
					initButtons();
				}
			}
        );
    }
    
    
	public SampleController() {
		// Not a real initlizer
	}

}

package todo.web;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProperty;
import org.directwebremoting.annotations.RemoteProxy;
import org.directwebremoting.annotations.ScriptScope;

@DataTransferObject
@RemoteProxy(scope=ScriptScope.APPLICATION)
public class Address implements Serializable{

	@RemoteProperty
	 private int id;
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}

	@RemoteProperty
	private String name;
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	@RemoteProperty
	private String address;
	public String getAddres() {return address;}
	public void getAddress(String address) {this.address = address;}

	@
}






public class Address {

}

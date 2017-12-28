package org.main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users_table")
public class Newuser {
	@Id
	@Column(name="User_name")
	String new_username;
	@Column(name="User_password")
	String new_password;
	public String getNew_username() {
		return new_username;
	}
	public void setNew_username(String new_username) {
		this.new_username = new_username;
	}
	public String getNew_password() {
		return new_password;
	}
	public void setNew_password(String new_password) {
		this.new_password = new_password;
	}
	public Newuser() {
		super();
	}
}

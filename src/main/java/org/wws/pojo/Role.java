package org.wws.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="user_roles")
public class Role {

	@Id
    @Column(name = "user_role_id", unique = true, nullable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

//    @NotNull
//    @Column(name="roleType", unique=true, nullable=false, length=50)
//    private String roleType;
    
//    @ManyToMany(fetch=FetchType.EAGER)
//    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
//    @JoinTable(name="user_roles",
//            joinColumns = {@JoinColumn(name="role_id", referencedColumnName="role_id")},
//            inverseJoinColumns = {@JoinColumn(name="UserID", referencedColumnName="UserID")}
//    )
//    private Set<User> users = new HashSet();

	
    @Column(name="authority", nullable=false, length=50)
	private String authority;
	
	
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="user_id", nullable = false)
    private User user;
    
    
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	

//	public String getRoleType() {
//		return roleType;
//	}
//
//	public void setRoleType(String roleType) {
//		this.roleType = roleType;
//	}

//	public Set<User> getUsers() {
//		return users;
//	}
//
//	public void setUsers(Set<User> users) {
//		this.users = users;
//	}
    
	
    
}

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import org.hibernate.search.annotations.Field;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Entity
@Table(name="user", uniqueConstraints=@UniqueConstraint(columnNames={"UserName"}))
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="UserID", unique=true, nullable=false)
	private int id;
	
	@Field
	@Column(name="username", unique=true, nullable=false, length=50)
	@NotEmpty
	@Size(min=2, max=30)
	private String username;
	
	@Column(name="password", nullable=false)
	@NotEmpty
	private String password;
	
	@Column(name="AboutMe1")
	private String aboutme;
	
	@Column(name="Gender")
	private String gender;
	
	
	@Column(name="country")
	private String country;
	
	@Column(name="State")
	private String state;
	
	@Column(name="City")
	private String city;
	
	@Column(name="enabled", nullable=false)
    private boolean enabled;
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Role> roles = new HashSet<Role>();
	
	@Column(name="url")
    private String url;

    @Transient
    private CommonsMultipartFile image;

	
	
	
//	@ManyToMany(fetch=FetchType.EAGER)
//    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
//    @JoinTable(name="user_roles",
//            joinColumns = {@JoinColumn(name="UserID", referencedColumnName="UserID")},
//            inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName="role_id")}
//    )
//    private Set<Role> roles = new HashSet<Role>();
//	
//	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
//	@JoinColumn(name="fk_country",nullable=false)
//	private Country countryid;
//	
//	@OneToMany(mappedBy="user", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
//	private Set<Contact> contacts = new HashSet<Contact>();
//	
//	@OneToMany(mappedBy="user", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
//	private List<Message> messages = new ArrayList<Message>();
	

	public User() {
		
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}

	
	
	
	public String getAboutme() {
		return aboutme;
	}

	public void setAboutme(String aboutme) {
		this.aboutme = aboutme;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public CommonsMultipartFile getImage() {
		return image;
	}

	public void setImage(CommonsMultipartFile image) {
		this.image = image;
	}

	
	
	

//	public Set<Role> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(Set<Role> roles) {
//		this.roles = roles;
//	}
	
	
	
	
//
//	public Country getCountryid() {
//		return countryid;
//	}
//
//	public void setCountryid(Country countryid) {
//		this.countryid = countryid;
//	}
//
//	public Set<Contact> getContacts() {
//		return contacts;
//	}
//
//	public void setContacts(Set<Contact> contacts) {
//		this.contacts = contacts;
//	}
//
//	public List<Message> getMessages() {
//		return messages;
//	}
//
//	public void setMessages(List<Message> messages) {
//		this.messages = messages;
//	}
//	
	
	
	
	
}

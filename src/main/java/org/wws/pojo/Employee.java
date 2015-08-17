package org.wws.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by weiweisu on 3/20/14.
 */

@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "employee_id", unique=true, nullable=false)
    private Integer id;

	@NotNull
	@NotEmpty
    @Column(name = "first_name", nullable=false, length=50)
    private String firstName;

	@NotNull
	@NotEmpty
    @Column(name = "last_name")
    private String lastName;

	@NotNull @Min(10) @Max(200000)
    @Column(name = "salary")
    private int salary;

    @Column(name = "useraccount")
    private String useraccount;

    public Employee() {}

    public Employee(String firstName, String lastName, int salary) {
        this.firstName=firstName;
        this.lastName = lastName;
        this.salary=salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }
    public void setFirstName( String first_name ) {
        this.firstName = first_name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName( String last_name ) {
        this.lastName = last_name;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary( int salary ) {
        this.salary = salary;
    }

	public String getUseraccount() {
		return useraccount;
	}

	public void setUseraccount(String useraccount) {
		this.useraccount = useraccount;
	}
    
    
}

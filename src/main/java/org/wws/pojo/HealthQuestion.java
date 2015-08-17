package org.wws.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "HealthQuestion")
public class HealthQuestion {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "hquestion_id", unique=true, nullable=false)
	private Integer id;
	
	
	@NotEmpty
	@Size(min=1, max=50)
	@Column(name="title", nullable=false, length=100)
	private String title;
	
	@Column(name="fromuser", nullable=false, length=50)
	private String fromuser;
	
	@Column(name="question", nullable=false)
	@NotEmpty
	private String question;
	
	@Column(name="answer")
	private String answer;
	
	@Column(name="answeredbyuser")
	private String answeredbyuser;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getFromuser() {
		return fromuser;
	}

	public void setFromuser(String fromuser) {
		this.fromuser = fromuser;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnsweredbyuser() {
		return answeredbyuser;
	}

	public void setAnsweredbyuser(String answeredbyuser) {
		this.answeredbyuser = answeredbyuser;
	}
	
	
	
	
}

package ca.sheridancollege.beans;

import java.io.Serializable;
import java.time.LocalDate;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@NamedQuery(name="Feedback.byDate", query="from Feedback where date>=:date")
public class Feedback implements Serializable {
	private static final long serialVersionUID = 1L;

	private LocalDate date;

	@Id
	@GeneratedValue
	private int id;
	private String department;
	private String text;
	

	public Feedback(String department,String text)
	{
			this.department = department;
			this.text = text;
	}


	public Feedback(LocalDate date, String department, String text) {
		this.date = date;
		this.department = department;
		this.text = text;
	};
	
}

package domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private String firstname;

	private String lastname;

	private String email;

}
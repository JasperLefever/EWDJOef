package domain;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;

@Entity
@NamedQueries({
        @NamedQuery(name = "Guest.findByNameStartingWith2", query = "SELECT g FROM Guest g WHERE g.name LIKE CONCAT(:username,'%')"),
})
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(exclude = "id")
@ToString(exclude = "id")
public class Guest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String firstname;

	public Guest(String name, String firstname) {
		this.name = name;
		this.firstname = firstname;
	}

}
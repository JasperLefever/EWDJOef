package domain;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Contact implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
    private int version;

    @NotBlank(message = "{validation.firstname.NotBlank.message}")
    @Size(min = 3, max = 60, message = "{validation.Size.message}")
    private String firstname;

    @NotBlank(message = "{validation.lastname.NotBlank.message}")
    @Size(min = 3, max = 60, message = "{validation.Size.message}")
    private String lastname;

    private String description;
    
	private LocalDate birthDate;
}

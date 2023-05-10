package domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import utils.LocalDateTimeDeserializer;
import utils.LocalDateTimeSerializer;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = "createdDateTime")
@ToString
//@JsonPropertyOrder({"employee_id", "name", "createdDateTime"})
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("employee_id")
    private int id;
	
	private String name;
    
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createdDateTime;

    
	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
		this.createdDateTime = LocalDateTime.now();
	}
    
}
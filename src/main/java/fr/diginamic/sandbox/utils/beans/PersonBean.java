package fr.diginamic.sandbox.utils.beans;

import java.util.List;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonBean {

	private Integer id;

	private Integer age;

	@Size(max = 50)
	private String firstname;

	@Size(max = 50)
	private String lastname;

	private List<Integer> animalIds;
}

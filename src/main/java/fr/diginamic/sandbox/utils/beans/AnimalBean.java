package fr.diginamic.sandbox.utils.beans;

import java.util.List;

import javax.validation.constraints.Size;

import fr.diginamic.sandbox.utils.enums.Sex;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnimalBean {

	private Integer id;

	@Size(max = 50)
	private String color;

	@Size(max = 50)
	private String name;

	private Sex sex;

	private Integer specieId;

	private List<Integer> personIds;
}

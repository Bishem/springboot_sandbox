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
public class SpecieBean {

	private Integer id;

	@Size(max = 50)
	private String commonName;

	@Size(max = 200)
	private String latinName;

	private List<Integer> animalIds;
}

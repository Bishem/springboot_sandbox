package fr.diginamic.sandbox.utils.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.diginamic.sandbox.utils.enums.Sex;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Length(max = 50)
	private String color;

	@Length(max = 50)
	private String name;

	@Enumerated(EnumType.STRING)
	private Sex sex;

	@Valid
	@ManyToOne
	private Specie specie;

	@Valid
	@ManyToMany
	@JsonIgnore
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JoinTable(name = "person_animal")
	private List<Person> persons;
}

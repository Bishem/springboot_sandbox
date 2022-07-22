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
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.diginamic.sandbox.utils.enums.Sex;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Builder
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NonNull
	@Size(max = 50)
	@Length(max = 50)
	private String color;

	@NonNull
	@Size(max = 50)
	@Length(max = 50)
	private String name;

	@NonNull
	@Enumerated(EnumType.STRING)
	private Sex sex;

	@Valid
	@NonNull
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

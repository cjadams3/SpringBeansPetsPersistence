package dmacc.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="petinfo")
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="name")
	private String name;
	@Column(name="animal")
	private String animal;
	@Column(name="color")
	private String color;
	@Column(name="age")
	private int age;
	@Column(name="owner")
	private String ownerName;
	
	public Pet() {
		super();
	}
	
	public Pet(long id, String name, String animal, String color, int age, String ownerName) {
		super();
		this.id = id;
		this.name = name;
		this.animal = animal;
		this.color = color;
		this.age = age;
		this.ownerName = ownerName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	@Override
	public String toString() {
		return "Pet [id = " + id + " name = " + name + " animal = " + animal + " color = " + color + " age = " + age + " Owner Name = " + ownerName + "]";
	}
}

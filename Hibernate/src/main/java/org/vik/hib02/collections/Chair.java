package org.vik.hib02.collections;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Chair {

	public Chair() {
		super();
	}

	public Chair(int chairId, String name, String material, String carpentar) {
		super();
		this.chairId = chairId;
		this.name = name;
		this.material = material;
		this.carpentar = carpentar;
	}

	@Column(name = "CHAIR_ID")
	private int chairId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "MATERIAL")
	private String material;

	@Column(name = "CARPENTER_NAME")
	private String carpentar;

	public int getChairId() {
		return chairId;
	}

	public void setChairId(int chairId) {
		this.chairId = chairId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getCarpentar() {
		return carpentar;
	}

	public void setCarpentar(String carpentar) {
		this.carpentar = carpentar;
	}

	public static Chair getChair() {
		Random random = new Random();
		int randomNum = random.nextInt(99999);
		return new Chair(randomNum, "bookName" + randomNum, "Simple Material..", "Carpenter " + randomNum);
	}

}

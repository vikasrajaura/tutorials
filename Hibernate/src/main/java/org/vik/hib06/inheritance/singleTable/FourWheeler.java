package org.vik.hib06.inheritance.singleTable;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="FOUR_WHEELER06")
@Table(name="FOUR_WHEELER06")
@DiscriminatorValue("Car")
public class FourWheeler extends Vehicle {
	
	@Column(name="STEERING_WHEEL")
	private String steeringWheel;

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}

	public FourWheeler() {
		super();
	}

	public FourWheeler(String steeringWheel) {
		super();
		this.steeringWheel = steeringWheel;
	}

	public static FourWheeler getFourWheeler() {
		Random random = new Random();
		int randomNum = random.nextInt(99999);
		return new FourWheeler("sTEERING HANDLE .." + randomNum);
	}

}

package org.vik.hib06.inheritance.singleTable;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "TWO_WHEELER06")
@Table(name = "TWO_WHEELER06")
@DiscriminatorValue("Bike")
public class TwoWheeler extends Vehicle {

	@Column(name = "STEERING_HANDLE")
	private String steeringHandle;

	public String getSteeringHandle() {
		return steeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}

	public TwoWheeler() {
		super();
	}

	public TwoWheeler(String steeringHandle) {
		super();
		this.steeringHandle = steeringHandle;
	}

	public static TwoWheeler getTwoWheeler() {
		Random random = new Random();
		int randomNum = random.nextInt(99999);
		return new TwoWheeler("sTEERING HANDLE .." + randomNum);
	}

}

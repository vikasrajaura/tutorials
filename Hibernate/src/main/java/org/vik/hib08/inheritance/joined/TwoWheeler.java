package org.vik.hib08.inheritance.joined;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "TWO_WHEELER08")
@Table(name = "TWO_WHEELER08")
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

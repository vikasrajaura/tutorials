package org.vik.hib04.OneToMany;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity(name = "PLOT")
@Table(name = "PLOT")
public class Plot {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PLOT_ID")
	private int plotId;

	@Column(name = "DES")
	private String des;

	@ManyToOne()
	@NotFound(action=NotFoundAction.IGNORE) // if any plot does not have its owner then just ignore
	@JoinTable(name="PERSON_PLOT", joinColumns=@JoinColumn(name="PERSON_ID"), inverseJoinColumns=@JoinColumn(name="PLOT_ID"))
	private Person owner;

	public Plot() {
		super();
	}

	public Plot(String des) {
		super();
		this.des = des;
	}

	public int getPlotId() {
		return plotId;
	}

	public void setPlotId(int plotId) {
		this.plotId = plotId;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	public static Plot getPlot() {
		Random random = new Random();
		int randomNum = random.nextInt(99999);
		return new Plot("plot desc.." + randomNum);
	}


}

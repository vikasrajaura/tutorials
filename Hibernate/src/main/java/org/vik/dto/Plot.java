package org.vik.dto;

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
import org.hibernate.boot.registry.selector.spi.StrategyCreator;

@Entity
@Table(name = "PLOT")
public class Plot {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PLOT_ID")
	private int plotId;

	@Column(name = "DES")
	private String des;

	@ManyToOne
	@NotFound(action=NotFoundAction.IGNORE) // if any plot does not have its owner then just ignore
	@JoinTable(name="STUDENT_PLOT", joinColumns=@JoinColumn(name="STUDENT_ID"), inverseJoinColumns=@JoinColumn(name="PLOT_ID"))
	private StudentDetails owner;

	public int getPlotId() {
		return plotId;
	}

	public String getDes() {
		return des;
	}

	public StudentDetails getOwner() {
		return owner;
	}

	public void setPlotId(int plotId) {
		this.plotId = plotId;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public void setOwner(StudentDetails owner) {
		this.owner = owner;
	}

}

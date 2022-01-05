package com.RailwayReservationBookingService.model;

public class Passengers {

	private int adults;
	private int children;

	public Passengers() {
		super();
	}

	public Passengers(int adults, int children) {
		super();
		this.adults = adults;
		this.children = children;
	}

	public int getAdults() {
		return adults;
	}

	public void setAdults(int adults) {
		this.adults = adults;
	}

	public int getChildren() {
		return children;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "Passengers [adults=" + adults + ", children=" + children + "]";
	}

}

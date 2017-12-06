package com.sqli.test.elevators;

public class Elevator {
	private String id;
	private int currentFloor;
	private boolean isMoving;
	private String state;
	
	
	public boolean isMoving() {
		return isMoving;
	}
	public void setMoving(boolean isMoving) {
		this.isMoving = isMoving;
	}
	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}

	
	public int getCurrentFloor() {
		return currentFloor;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Elevator [id=" + id + ", currentFloor=" + currentFloor + ", isMoving=" + isMoving + ", state=" + state
				+ "]";
	}
	public String getState() {
		return state;
	}
	public Elevator(String id, int currentFloor) {
		super();
		this.id = id;
		this.currentFloor = currentFloor;
		this.state = "RESTING";
		this.isMoving = false;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}

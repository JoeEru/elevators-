package com.sqli.test.elevators;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Building {
	
	private int numberOfFloors;
	private List<Elevator> elevators = new ArrayList<>();
	
	
	

    public int getNumberOfFloors() {
		return numberOfFloors;
	}

	public void setNumberOfFloors(int numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
	}

	public List<Elevator> getElevators() {
		return elevators;
	}

	public void setElevators(List<Elevator> elevators) {
		this.elevators = elevators;
	}

	/**
     * @param numberOfFloors: the number of floors in the building
     * @param elevators: an array of descriptions of the elevators of the building. 
     *                   A description has the following format "[elevator_id]:[elevator_current_floor]".
     */
    public Building(int numberOfFloors, String... elevators) {
        //throw new UnsupportedOperationException("Still to be implemented");
    	setNumberOfFloors(numberOfFloors);
    	for(String elevator : elevators) {
    		String[] itemsOfElevator = elevator.split(":");
    		this.elevators.add(new Elevator(itemsOfElevator[0], Integer.parseInt(itemsOfElevator[1])));
    	}
    }

    /**
     * Request an elevator at floor zero.
     * @return the id of the elevator that should serve the request.
     */
    public String requestElevator() {
        //throw new UnsupportedOperationException("Still to be implemented");
    	
    	//we stream our list of elevators to apply many operations on the list such as filter to get elevators going up and resting and not stopping then apply the max function to get the elevator with higher currentFloor and return his id
    	
    	String idOfRequesedElevator = elevators.stream()  
                .filter(elevator -> {
                	if(elevator.getState().equals("UP")) {
                		if(elevator.isMoving()) {
                			return true;
                		}
                	}else if(elevator.getState().equals("RESTING")) {
                		return true;
                	}
                	return false;
                })
                .max((elevator1,elevator2) -> Integer.compare(elevator1.getCurrentFloor(),elevator2.getCurrentFloor()))
                .get()
    			.getId();
   	 

    	

	    	
	   	 
	   	 
	
	   	
	   	
	   	
	   	
	   	
	   	return idOfRequesedElevator;
    }

    /**
     * Request an elevator at floor indicate by the {@code floor} param.
     * @param floor : the floor where the request is made.
     * @return the id of the elevator that should serve the request.
     */
    public String requestElevator(int floor) {
    	String idOfRequesedElevator = elevators.stream()
    	    	.max((elevator1,elevator2) -> Integer.compare(elevator1.getCurrentFloor()- floor,elevator2.getCurrentFloor() -floor))
    	    	.get().getId();
    	    	return idOfRequesedElevator;
    }

    /**
     * Request the elevator with the id {@code elevatorId} to stop at the floor indicated by the {@code floor} param.
     * @param elevatorId : the id of the elevator to whom give the order.
     * @param floor : the floor at which the elevator should stop
     */
    public void stopAt(String elevatorId, int floor) {
    	elevators.stream()
    	.filter(elevator -> elevator.getId().equals(elevatorId))
    	.forEach(elevator -> {
    		elevator.setCurrentFloor(floor);
    		elevator.setMoving(false);
    	});
    }

    /**
     * Move the elevator with the id {@code elevatorId} in the direction indicated by the {@code direction} param.
     * @param elevatorId : the id of the elevator to move.
     * @param direction : the direction to go. Can be "UP" or "DOWN".
     */
    public void move(String elevatorId, String direction) {
        //throw new UnsupportedOperationException("Still to be implemented");
    	elevators.stream()
    	.filter(elevator -> elevator.getId().equals(elevatorId))
    	.forEach(elevator ->{
    		elevator.setState(direction);
    		elevator.setMoving(true);
    	});
    }

}

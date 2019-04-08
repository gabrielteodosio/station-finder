package br.com.data.entities;

import java.util.Stack;

public class User {
	private Stack<Station> path;
	private State initialState;
	private State desiredState;
	private State currentState;

	public User(State initialState, State finalState) {
		this.initialState = initialState;
		this.currentState = this.initialState;
		this.desiredState = finalState;

		this.path = new Stack<Station>();
		this.path.push(this.currentState.getStation());
	}

	public Stack<Station> getPath() {
		return path;
	}

	public void printPath() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < path.size(); i++) {
			if (i == path.size() - 1) {
				sb.append('[').append(path.get(i).getName()).append("]");
			} else {
				sb.append('[').append(path.get(i).getName()).append("] -> ");
			}
		}

		System.out.println(sb.toString());
	}

	public State getDesiredState() {
		return desiredState;
	}

	public State getInitialState() {
		return initialState;
	}

	public State getCurrentState() {
		return currentState;
	}
	
	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}
}

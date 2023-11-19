package org.pneditor.petrinet.adapters.group1;

import org.pneditor.petrinet.AbstractTransition;
import org.pneditor.petrinet.models.group1.Transition;

public class TransitionAdapter extends AbstractTransition {
	
	private Transition transition;

	public TransitionAdapter(String label) {
		super(label);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isPlace() {
		return false;
	}

	public Transition getTransition() {
		return transition;
	}

	public void setTransition(Transition transition) {
		this.transition = transition;
	}

}

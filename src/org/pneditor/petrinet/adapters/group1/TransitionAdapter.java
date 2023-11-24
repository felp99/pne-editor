package org.pneditor.petrinet.adapters.group1;

import java.util.ArrayList;

import org.pneditor.petrinet.AbstractTransition;
import org.pneditor.petrinet.models.group1.Arc;
import org.pneditor.petrinet.models.group1.NoExistingObjectException;
import org.pneditor.petrinet.models.group1.Transition;

public class TransitionAdapter extends AbstractTransition {
	
    private final Transition transition;
	
	public TransitionAdapter(String label) throws NoExistingObjectException {
		super(label);
        this.transition = new Transition(new ArrayList<>(), new ArrayList<>());
	}
	
	@Override
	public boolean isPlace() {
		return false;
	}
	
	public boolean isEnabled() {
		return this.transition.fireable();
	}
	
	public void fire() throws NoExistingObjectException {
		this.transition.fire();
	}

	public Transition getTransition() {
		return this.transition;
	}

}

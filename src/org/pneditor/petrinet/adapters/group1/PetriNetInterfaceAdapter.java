package org.pneditor.petrinet.adapters.group1;

import java.util.ArrayList;
import java.util.List;

import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.AbstractPlace;
import org.pneditor.petrinet.AbstractTransition;
import org.pneditor.petrinet.PetriNetInterface;
import org.pneditor.petrinet.ResetArcMultiplicityException;
import org.pneditor.petrinet.UnimplementedCaseException;
import org.pneditor.petrinet.adapters.fourane.ArcAdapter;
import org.pneditor.petrinet.adapters.fourane.PlaceAdapter;
import org.pneditor.petrinet.adapters.fourane.TransitionAdapter;
import org.pneditor.petrinet.models.group1.ExistingObjectException;
import org.pneditor.petrinet.models.group1.NoExistingObjectException;
import org.pneditor.petrinet.models.group1.PetriNetwork;
import org.pneditor.petrinet.models.group1.Place;

public class PetriNetInterfaceAdapter extends PetriNetInterface {
	
    private final ArrayList<ArcAdapter> arcs = new ArrayList<ArcAdapter>();
    private final ArrayList<PlaceAdapter> places = new ArrayList<PlaceAdapter>();
    private final ArrayList<TransitionAdapter> transitions = new ArrayList<TransitionAdapter>();
    
	@Override
	public AbstractPlace addPlace() {
		PlaceAdapter place = new PlaceAdapter(null);
		places.add(place);
		return place;
	}

	@Override
	public AbstractTransition addTransition() {
		TransitionAdapter transition;
		try {
			transition = new TransitionAdapter(null);
			transitions.add(transition);
			return transition;
		} catch (NoExistingObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public AbstractArc addRegularArc(AbstractNode source, AbstractNode destination) throws UnimplementedCaseException {
		ArcAdapter arc;
		try {
			arc = new ArcAdapter(ArcType.Regular, source, destination);
			arcs.add(arc);
			return arc;
		} catch (ExistingObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public AbstractArc addInhibitoryArc(AbstractPlace place, AbstractTransition transition)
			throws UnimplementedCaseException {
		ArcAdapter arc;
		try {
			arc = new ArcAdapter(ArcType.Inhibitory, place, transition);
			arcs.add(arc);
			return arc;
		} catch (ExistingObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public AbstractArc addResetArc(AbstractPlace place, AbstractTransition transition)
			throws UnimplementedCaseException {
		ArcAdapter arc;
		try {
			arc = new ArcAdapter(ArcType.Reset, place, transition);
			arcs.add(arc);
			return arc;
		} catch (ExistingObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void removePlace(AbstractPlace place) {
		places.remove(place);
		
	}

	@Override
	public void removeTransition(AbstractTransition transition) {
		transitions.remove(transition);
	}

	@Override
	public void removeArc(AbstractArc arc) {
		arcs.remove(arc);
	}

	@Override
	public boolean isEnabled(AbstractTransition transition) throws ResetArcMultiplicityException {
        for (TransitionAdapter t : transitions) {
            if (t.equals(transition)) {
            	return t.isEnabled();
            } else {
            	return false;
            }
        }
		return false;
	}

	@Override
	public void fire(AbstractTransition transition) throws ResetArcMultiplicityException {
        for (TransitionAdapter t : transitions) {
            if (t.equals(transition)) {
            	try {
					t.fire();
				} catch (NoExistingObjectException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            } else {
            	System.out.println("Transition not implemented");
            }
        }		
	}
	
}

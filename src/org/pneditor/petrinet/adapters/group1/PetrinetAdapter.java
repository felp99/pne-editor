package org.pneditor.petrinet.adapters.group1;

import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.AbstractPlace;
import org.pneditor.petrinet.AbstractTransition;
import org.pneditor.petrinet.PetriNetInterface;
import org.pneditor.petrinet.ResetArcMultiplicityException;
import org.pneditor.petrinet.UnimplementedCaseException;
import org.pneditor.petrinet.models.group1.PetriNetwork;
import org.pneditor.petrinet.models.group1.Place;

public class PetrinetAdapter extends PetriNetInterface {
	
	private PetriNetwork petrinet;

	@Override
	public AbstractPlace addPlace() {
		
		Place place = new Place();
		petrinet.addPlace(place);
		
		PlaceAdapter placeAdapter = new PlaceAdapter(null, place);
		return placeAdapter.convertPlace(place);
	}

	@Override
	public AbstractTransition addTransition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractArc addRegularArc(AbstractNode source, AbstractNode destination) throws UnimplementedCaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractArc addInhibitoryArc(AbstractPlace place, AbstractTransition transition)
			throws UnimplementedCaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractArc addResetArc(AbstractPlace place, AbstractTransition transition)
			throws UnimplementedCaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removePlace(AbstractPlace place) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTransition(AbstractTransition transition) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeArc(AbstractArc arc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEnabled(AbstractTransition transition) throws ResetArcMultiplicityException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void fire(AbstractTransition transition) throws ResetArcMultiplicityException {
		// TODO Auto-generated method stub
		
	}

}

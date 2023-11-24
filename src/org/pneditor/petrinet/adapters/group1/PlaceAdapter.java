package org.pneditor.petrinet.adapters.group1;

import org.pneditor.petrinet.AbstractPlace;
import org.pneditor.petrinet.models.group1.Place;

public class PlaceAdapter extends AbstractPlace {
	
	private Place place;

	public PlaceAdapter(String label) {		
		super(label);
        this.place = new Place();
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}
	
	public void addToken() {
		place.setNbTokens(place.getNbTokens()+1);
	}

	public void removeToken() {
		place.setNbTokens(place.getNbTokens()-1);
	}

	public int getTokens() {
		return place.getNbTokens();
	}

	public void setTokens(int tokens) {
		place.setNbTokens(tokens);
	}
	
	@Override
	public boolean isPlace() {
		return true;
	}
}

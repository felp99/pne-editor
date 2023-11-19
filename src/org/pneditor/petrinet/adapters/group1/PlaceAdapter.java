package org.pneditor.petrinet.adapters.group1;

import org.pneditor.petrinet.AbstractPlace;
import org.pneditor.petrinet.models.group1.Place;

public class PlaceAdapter extends AbstractPlace {
	
	private Place place;

	public PlaceAdapter(String label, Place place) {
		super(label);
		// TODO Auto-generated constructor stub
	}
	
	public AbstractPlace convertPlace(Place place) {
		
		AbstractPlace aPlace = new AbstractPlace(place.getId()) {
			
			@Override
			public void setTokens(int tokens) {
				place.setNbTokens(tokens);			
			}
			
			@Override
			public void removeToken() {
				int i = place.getNbTokens();
				place.setNbTokens(i-1);			
			}
			
			@Override
			public int getTokens() {
				return place.getNbTokens();
			}
			
			@Override
			public void addToken() {
				int i = place.getNbTokens();
				place.setNbTokens(i+1);			}
		};
		
		return aPlace;

	}

	@Override
	public void addToken() {
		int i = place.getNbTokens();
		place.setNbTokens(i+1);
		
	}

	@Override
	public void removeToken() {
		int i = place.getNbTokens();
		place.setNbTokens(i-1);
	}

	@Override
	public int getTokens() {
		return place.getNbTokens();
	}

	@Override
	public void setTokens(int tokens) {
		place.setNbTokens(tokens);
		
	}

}

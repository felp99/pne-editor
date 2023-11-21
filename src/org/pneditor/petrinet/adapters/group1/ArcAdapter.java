
package org.pneditor.petrinet.adapters.group1;

import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.ResetArcMultiplicityException;
import org.pneditor.petrinet.models.group1.Arc;
import org.pneditor.petrinet.models.group1.NegativeTokenInsertedException;
import org.pneditor.petrinet.models.group1.NoExistingObjectException;

/**
 * 
 */
public class ArcAdapter extends AbstractArc {

	private Arc arc;
	
	@Override
	public AbstractNode getSource() {
		AbstractNode start = null;
		try {
			start = (AbstractNode) arc.getStart();
		} catch (NoExistingObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return start;
	}

	@Override
	public AbstractNode getDestination() {
		AbstractNode end = null;
		try {
			end = (AbstractNode) arc.getEnd();
		} catch (NoExistingObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return end;
	}

	@Override
	public boolean isReset() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRegular() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInhibitory() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getMultiplicity() throws ResetArcMultiplicityException {		
		return arc.getWeight();
	}

	@Override
	public void setMultiplicity(int multiplicity) throws ResetArcMultiplicityException {
		try {
			arc.setWeight(multiplicity);
		} catch (NegativeTokenInsertedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Arc getArc() {
		return arc;
	}

	public void setArc(Arc arc) {
		this.arc = arc;
	}
		
}

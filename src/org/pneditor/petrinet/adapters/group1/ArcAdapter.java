
package org.pneditor.petrinet.adapters.group1;

import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.ResetArcMultiplicityException;
import org.pneditor.petrinet.adapters.fourane.ArcAdapter;
import org.pneditor.petrinet.adapters.fourane.ArcType;
import org.pneditor.petrinet.adapters.fourane.PlaceAdapter;
import org.pneditor.petrinet.adapters.fourane.TransitionAdapter;
import org.pneditor.petrinet.models.fourane.ArcVideur;
import org.pneditor.petrinet.models.fourane.ArcZero;
import org.pneditor.petrinet.models.group1.Arc;
import org.pneditor.petrinet.models.group1.DrainerArc;
import org.pneditor.petrinet.models.group1.ExistingObjectException;
import org.pneditor.petrinet.models.group1.NegativeTokenInsertedException;
import org.pneditor.petrinet.models.group1.NoExistingObjectException;
import org.pneditor.petrinet.models.group1.Place;
import org.pneditor.petrinet.models.group1.Transition;
import org.pneditor.petrinet.models.group1.ZeroArc;

public class ArcAdapter extends AbstractArc {


    private Arc arc;
	private PlaceAdapter startPlace;
	private PlaceAdapter endPlace;
	
	private TransitionAdapter startTransition;
	private TransitionAdapter endTransition;
	
    private final ArcType arcType;
    
    public ArcAdapter(ArcType type, AbstractNode start, AbstractNode end) throws ExistingObjectException {
        switch (type) {
            case Regular: {
            	this.arc = new Arc();
            	this.arc.setStart(start);
            	this.arc.setEnd(end);
            	
            	this.setStart(start);
            	this.setEnd(end);
            };
            case Reset: {
            	this.arc = new DrainerArc();
            	this.arc.setStart(start);
            	this.arc.setEnd(end);
            	
            	this.setStart(start);
            	this.setEnd(end);
            	};
            	
            case Inhibitory: {
            	this.arc = new ZeroArc();
            	this.arc.setStart(start);
            	this.arc.setEnd(end);
            	
            	this.setStart(start);
            	this.setEnd(end);
            	};
        }
        this.arcType= type;
    }
    
	public void setStart(Object start) throws ExistingObjectException {
		
		if (this.startPlace != null || this.startTransition != null) {
			throw new ExistingObjectException();
			
		} else if (start.getClass() == PlaceAdapter.class) {
			this.startPlace = (PlaceAdapter) start;
			
		} else if (start.getClass() == TransitionAdapter.class) {
			this.startTransition = (TransitionAdapter) start;
		}
	};
	
	public void setEnd(Object end) throws ExistingObjectException {
		if (this.endPlace != null || this.endTransition != null) {
			throw new ExistingObjectException();

		} else if (end.getClass() == PlaceAdapter.class) {
			this.endPlace = (PlaceAdapter) end;
			
		} else if (end.getClass() == TransitionAdapter.class) {
			this.endTransition = (TransitionAdapter) end;
		}
	};
	
	public Object getStart() throws NoExistingObjectException {
		
		if (this.startTransition == null && this.startPlace == null) {
			throw new NoExistingObjectException();
		};
		
		if (this.startPlace != null) {
			return this.startPlace;
		} else {
			return this.startTransition;
		}
	}

	public Object getEnd() throws NoExistingObjectException {
		
		if (this.endTransition == null && this.endPlace == null) {
			throw new NoExistingObjectException();
		};
		
		if (this.endPlace != null) {
			return this.endPlace;
		} else {
			return this.endTransition;
		}
	}

    public Arc getArc() {
        return arc;
    }

    @Override
    public AbstractNode getSource() {
    	try {
			return (AbstractNode) this.getStart();
		} catch (NoExistingObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }

    @Override
    public AbstractNode getDestination() {
    	try {
			return (AbstractNode) this.getEnd();
		} catch (NoExistingObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }

    @Override
    public boolean equals(Object o){
        ArcAdapter arc = (ArcAdapter) o;
        if (this.getSource() == arc.getSource() && this.getDestination() == arc.getDestination()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isReset() {
        return arcType == ArcType.Reset;
    }

    @Override
    public boolean isRegular() {
        return arcType == ArcType.Regular;
    }

    @Override
    public boolean isInhibitory() {
        return arcType == ArcType.Inhibitory;
    }

    @Override
    public int getMultiplicity() throws ResetArcMultiplicityException {
        return arc.getWeight();
    }

    @Override
    public void setMultiplicity(int multiplicity) {
        try {
			arc.setWeight(multiplicity);
		} catch (NegativeTokenInsertedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
		
}

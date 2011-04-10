package org.cbarrett.scotchservices;

import org.cbarrett.scotchservices.domain.Malt;
import org.cbarrett.scotchservices.domain.RefDistilleryStatus;
import org.cbarrett.scotchservices.domain.RefRegion;
import org.cbarrett.scotchservices.domain.RefStyle;

import java.util.List;

public interface ScotchService {
	/*
	public List getOwners();
	public List getIndependentBottlers();
	public List getDistilleries();
	*/
	public Malt getMaltByName(String name);
	public List<Malt> getMalts();
	public List<Malt> getMaltsByDistillery(String distillery);
	
	public List<RefDistilleryStatus> getDistilleryStatus();
	public List<RefRegion> getRegion();
	public List<RefStyle> getStyle();
	/*
	public List getBottlings();
	
	public List getTastingNotes();
	public List getPurchaseRecords();
	
	public List getRegions();
	public List getStyles();
	*/
}

/**
 * 
 */
package org.cbarrett.scotchservices;

import java.util.ArrayList;
import java.util.List;

import org.cbarrett.scotchservices.db.ref.RefDistilleryStatusDAO;
import org.cbarrett.scotchservices.db.ref.RefRegionDAO;
import org.cbarrett.scotchservices.db.ref.RefStyleDAO;
import org.cbarrett.scotchservices.domain.Malt;
import org.cbarrett.scotchservices.domain.RefDistilleryStatus;
import org.cbarrett.scotchservices.domain.RefRegion;
import org.cbarrett.scotchservices.domain.RefStyle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cbarrett
 *
 */
@Service
public class ScotchServiceImpl implements ScotchService {

	@Autowired
	private RefDistilleryStatusDAO refDistlleryStatusDAO;
	@Autowired
	private RefRegionDAO refRegionDAO;
	@Autowired
	private RefStyleDAO refStyleDAO;
	
	private static ArrayList<Malt> malts = new ArrayList<Malt>();
	
	static {
		malts.add(new Malt("ardbeg"));
		malts.add(new Malt("auchriosk"));
	}
	
	/* (non-Javadoc)
	 * @see org.cbarrett.scotchservices.ScotchService#getMaltByName(java.lang.String)
	 */
	@Override
	public Malt getMaltByName(String name) {
		return malts.get(malts.indexOf(new Malt(name)));
	}

	/* (non-Javadoc)
	 * @see org.cbarrett.scotchservices.ScotchService#getMalts()
	 */
	@Override
	public List<Malt> getMalts() {
		return malts;
	}

	/* (non-Javadoc)
	 * @see org.cbarrett.scotchservices.ScotchService#getMaltsByDistillery(java.lang.String)
	 */
	@Override
	public List<Malt> getMaltsByDistillery(String distillery) {
		return malts;
	}

	/* (non-Javadoc)
	 * @see org.cbarrett.scotchservices.ScotchService#getDistilleryStatus()
	 */
	@Override
	public List<RefDistilleryStatus> getDistilleryStatus() {
		// fetch statii
		List<RefDistilleryStatus> statii = refDistlleryStatusDAO.selectAll();
		return statii;
	}

	/* (non-Javadoc)
	 * @see org.cbarrett.scotchservices.ScotchService#getRegion()
	 */
	@Override
	public List<RefRegion> getRegion() {
		List<RefRegion> region = refRegionDAO.selectAll();
		return region;
	}

	/* (non-Javadoc)
	 * @see org.cbarrett.scotchservices.ScotchService#getStyle()
	 */
	@Override
	public List<RefStyle> getStyle() {
		List<RefStyle> style= refStyleDAO.selectAll();
		return style;
	}
}

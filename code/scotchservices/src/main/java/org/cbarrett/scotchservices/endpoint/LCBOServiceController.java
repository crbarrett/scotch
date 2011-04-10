package org.cbarrett.scotchservices.endpoint;

import org.cbarrett.scotchservices.LCBOService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/lcbo")
public class LCBOServiceController {

	@Autowired
	LCBOService lcboService;

	@RequestMapping(value = "/resetdataset.*", method = RequestMethod.GET)
	public ModelAndView resetDatasetInfo() {
		String result = lcboService.getStartingDataset();
		ModelAndView mav = new ModelAndView("reset",
				"reset", result);
		return mav;
	}
}

/**
 *  Copyright 2011 Chris Barrett
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.cbarrett.scotchservices.endpoint;

import java.util.List;

import org.cbarrett.scotchservices.domain.Malt;
import org.cbarrett.scotchservices.domain.RefDistilleryStatus;
import org.cbarrett.scotchservices.domain.RefRegion;
import org.cbarrett.scotchservices.domain.RefStyle;
import org.cbarrett.scotchservices.ScotchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/scotch")
public class ScotchServiceController {

	@Autowired
	ScotchService scotchService;

	@RequestMapping(value = "/malts/{name}", method = RequestMethod.GET)
	public ModelAndView getMaltByName(@PathVariable("name") String name) {
		Malt malt = scotchService.getMaltByName(name);
		ModelAndView mav = new ModelAndView("malt",
				Malt.class.getName(), malt);
		return mav;
	}

	@RequestMapping(value = "/malts", method = RequestMethod.GET)
	public ModelAndView getMalts() {
		List<Malt> malts = scotchService.getMalts();
		ModelAndView mav = new ModelAndView("malt",
				Malt.class.getName(), malts);
		return mav;
	}

	@RequestMapping(value = "/{distillery}/malts", method = RequestMethod.GET)
	public ModelAndView getMaltsByDistillery(
			@PathVariable("distillery") String distillery) {
		List<Malt> malts = scotchService.getMaltsByDistillery(distillery);
		ModelAndView mav = new ModelAndView("malt",
				Malt.class.getName(), malts);
		return mav;
	}
	
	
	@RequestMapping(value = "/refdistillerystatus", method = RequestMethod.GET)
	public ModelAndView getDistilleryStatus() {
		List<RefDistilleryStatus> statii = scotchService.getDistilleryStatus();
		ModelAndView mav = new ModelAndView("status", RefDistilleryStatus.class.getName(), statii);
		return mav;
	}	
	@RequestMapping(value = "/refregion", method = RequestMethod.GET)
	public ModelAndView getRegion() {
		List<RefRegion> region = scotchService.getRegion();
		ModelAndView mav = new ModelAndView("region", RefRegion.class.getName(), region);
		return mav;
	}	
	@RequestMapping(value = "/refstyle", method = RequestMethod.GET)
	public ModelAndView getStyle() {
		List<RefStyle> style= scotchService.getStyle();
		ModelAndView mav = new ModelAndView("style", RefStyle.class.getName(), style);
		return mav;
	}	
}

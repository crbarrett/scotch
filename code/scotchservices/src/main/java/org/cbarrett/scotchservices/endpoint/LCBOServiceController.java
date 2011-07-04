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

import org.cbarrett.scotchservices.LCBOService;
import org.cbarrett.scotchservices.lcbo.domain.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/lcbo")
public class LCBOServiceController {

	@Autowired
	LCBOService lcboService;

	@RequestMapping(value = "/resetdataset", method = RequestMethod.GET)
	public ModelAndView resetDatasetInfo() {
		String result = lcboService.resetDatasets();
		ModelAndView mav = new ModelAndView("reset",
				"reset", result);
		return mav;
	}

	@RequestMapping(value = "/newproducts", method = RequestMethod.GET)
	public ModelAndView getNewProducts() {
		List<Product> result = lcboService.getNewProductList();
		ModelAndView mav = new ModelAndView("newproducts",
				"newProducts", result);
		return mav;
	}
	
	@RequestMapping(value = "/missingdatasets", method = RequestMethod.GET)
	public ModelAndView getMissingDatasets() {
		String result = lcboService.getMissingDatasets();
		ModelAndView mav = new ModelAndView("missingDatasets",
				"missingDatasets", result);
		return mav;
	}
	
	@RequestMapping(value = "/product/{cspc}", method = RequestMethod.GET)
	public ModelAndView getProduct(@PathVariable String cspc) {
		Product result = lcboService.getProductDetails(cspc);
		ModelAndView mav = new ModelAndView("product",
				"product", result);
		return mav;
	}

}

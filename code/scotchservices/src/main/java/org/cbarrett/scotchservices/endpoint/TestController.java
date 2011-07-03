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

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/web")
public class TestController {

    static private List<String> contentList = new ArrayList<String>();
    
    static {
    	contentList.add("content1");
    	contentList.add("content2");
    	contentList.add("content3");
    }

    @RequestMapping(value="/test", method=RequestMethod.GET)
    public ModelAndView getContent() throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("test");
        mav.addObject("sampleContentList", TestController.contentList);
        
        return mav;
    }
}

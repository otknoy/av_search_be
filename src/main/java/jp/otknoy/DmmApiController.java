package jp.otknoy;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;


import jp.otknoy.dmm.Response;
import jp.otknoy.dmm.SearchApi;

@RestController
@RequestMapping("/search")
public class DmmApiController {

    @Autowired
    private SearchApi searchApi;

    @RequestMapping(method=RequestMethod.GET)
    public Response search(@RequestParam Map<String, String> queryParameters) {
	Response response = searchApi.search(queryParameters.get("query"));

	return response;
    }
}

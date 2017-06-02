package jp.otknoy;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;

import jp.otknoy.dmm.ItemSearchApiService;
import jp.otknoy.dmm.api.items.Response;

@RestController
public class DmmApiController {

    @Autowired
    private ItemSearchApiService itemSearchApiService;

    @CrossOrigin()
    @RequestMapping("/api/search")
    public Response dmmSearch(@RequestParam(defaultValue="") String query) {
	Response response = itemSearchApiService.search(query);

	return response;
    }
}

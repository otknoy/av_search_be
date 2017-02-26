package jp.otknoy;

import java.util.List;

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

    @RequestMapping("/dmm/search")
    public Response dmmSearch(@RequestParam(defaultValue="") String query) {
	Response response = itemSearchApiService.search(query);

	return response;
    }

    @RequestMapping("/search")
    public List<Item> search(@RequestParam(defaultValue="") String query) {
	Response response = itemSearchApiService.search(query);
	List<Item> items = Item.create(response);

	return items;
    }
}

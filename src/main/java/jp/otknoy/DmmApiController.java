package jp.otknoy;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.otknoy.dmm.Item;
import jp.otknoy.dmm.Response;

@RestController
@RequestMapping("/search")
public class DmmApiController {

    @RequestMapping(method=RequestMethod.GET)
    public Response search(@RequestParam Map<String, String> queryParameters) {
	// ArrayList<Item> items = new ArrayList<>();
	// items.add(new Item("hoge1", 1000));
	// items.add(new Item("hoge2", 2000));

	// return new Response(200, "success", items);
	return null;
    }
}

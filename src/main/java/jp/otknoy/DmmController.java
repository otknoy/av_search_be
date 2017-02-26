package jp.otknoy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;

import jp.otknoy.dmm.ItemSearchApiService;
import jp.otknoy.dmm.api.items.Response;

@Controller
@EnableAutoConfiguration()
@ComponentScan
public class DmmController {

    @Autowired
    private ItemSearchApiService itemSearchApiService;

    @RequestMapping("/")
    public String index(Model model, @RequestParam(defaultValue="") String query) {
	Response response = itemSearchApiService.search(query);

	Item item = Item.create(response.getResult().getItems().get(0));
	 List<Item> items = Item.create(response);

	 model.addAttribute("items", items);

	return "index";
    }
}

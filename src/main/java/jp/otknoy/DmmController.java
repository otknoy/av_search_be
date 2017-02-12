package jp.otknoy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;

import jp.otknoy.dmm.Response;
import jp.otknoy.dmm.Item;
import jp.otknoy.dmm.ItemSearchApiService;

@Controller
@EnableAutoConfiguration()
@ComponentScan
public class DmmController {

    @Autowired
    private ItemSearchApiService itemSearchApiService;

    @RequestMapping("/")
    public String index(Model model, @RequestParam(defaultValue="") String query) {
	Response response = itemSearchApiService.search(query);

	model.addAttribute("items", response.result.items);

	return "index";
    }
}

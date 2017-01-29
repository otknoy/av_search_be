package jp.otknoy;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;

import jp.otknoy.dmm.Response;
import jp.otknoy.dmm.Item;
import jp.otknoy.dmm.SearchApi;

@Controller
@EnableAutoConfiguration()
public class DmmController {

    @Autowired
    private SearchApi searchApi;

    @RequestMapping("/")
    public String index(Model model, @RequestParam(defaultValue="") String query) {
	Response response = searchApi.search(query);

	model.addAttribute("items", response.result.items);

	return "index";
    }
}

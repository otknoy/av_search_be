package jp.otknoy.av.search;

import jp.otknoy.av.search.dmm.DmmSearchService;
import jp.otknoy.av.search.dmm.item.Item;
import jp.otknoy.av.search.dmm.item.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final DmmSearchService dmmSearchService;

    @RequestMapping("/")
    public String index() {
        return "It works.";
    }

    @CrossOrigin
    @RequestMapping("/search")
    public List<Item> search(@RequestParam String p) {
        Response response = dmmSearchService.search(p);

        System.out.println(p);

        return response.getResult().getItems();
    }


}

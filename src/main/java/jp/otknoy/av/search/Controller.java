package jp.otknoy.av.search;

import jp.otknoy.av.search.dmm.DmmSearchService;
import jp.otknoy.av.search.dmm.item.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

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
        System.out.println(p);

        Response response = dmmSearchService.search(p);
        List<Item> items = convertResponse(response);

        return items;
    }

    private List<Item> convertResponse(Response response) {
        return response.getResult().getItems().stream()
                .map(i -> Item.builder()
                        .title(i.getTitle())
                        .url(i.getAffiliateURL())
                        .imageUrl(i.getImageURL().getLarge())
                        .date(i.getDate())
                        .build())
                .collect(Collectors.toList());
    }
}

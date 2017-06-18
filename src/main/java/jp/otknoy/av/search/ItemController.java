package jp.otknoy.av.search;

import jp.otknoy.av.dmm.DmmSearchService;
import jp.otknoy.av.dmm.item.Response;
import jp.otknoy.av.dmm.item.Genre;
import jp.otknoy.av.dmm.item.Maker;
import jp.otknoy.av.dmm.item.Series;
import jp.otknoy.av.dmm.item.Actress;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ItemController {
    private final DmmSearchService dmmSearchService;

    @RequestMapping("/")
    public String index() {
        return "It works.";
    }

    @CrossOrigin
    @RequestMapping("/search")
    public List<Item> search(@Validated Request request) {
        long start = System.currentTimeMillis();

        log.info(request.toString());

        Response response = dmmSearchService.search(
                request.getKeyword(),
                request.getHits(),
                request.getOffset(),
                request.getSort());
        List<Item> items = convertResponse(response);

        long elapsed = System.currentTimeMillis() - start;
        log.info("response time: {} ms", elapsed);

        return items;
    }

    private List<Item> convertResponse(Response response) {
        return response.getResult().getItems().stream()
                .map(i -> {
                    Iterator<Actress> iterator = i.getIteminfo().getActress().iterator();
                    List<jp.otknoy.av.search.Actress> actress = new ArrayList<>();
                    while (iterator.hasNext()) {
                        Actress a = iterator.next();

                        String id = a.getId();
                        String name = a.getName();

                        a = iterator.next();
                        if (!a.getId().equals(id + "_ruby")) {
                            continue;
                        }

                        String yomigana = a.getName();

                        actress.add(jp.otknoy.av.search.Actress.builder()
                                .name(name)
                                .yomigana(yomigana)
                                .build());

                        iterator.next();
                    }

                    return Item.builder()
                            .title(i.getTitle())
                            .url(i.getAffiliateURL())
                            .imageUrl(i.getImageURL().getLarge())
                            .date(i.getDate())
                            .genre(i.getIteminfo().getGenre().stream()
                                    .map(Genre::getName)
                                    .collect(Collectors.toList()))
                            .maker(i.getIteminfo().getMaker().stream()
                                    .map(Maker::getName)
                                    .collect(Collectors.toList()))
                            .series(i.getIteminfo().getSeries().stream()
                                    .map(Series::getName)
                                    .collect(Collectors.toList()))
                            .actress(actress)
                            .build();
                })
                .collect(Collectors.toList());
    }
}
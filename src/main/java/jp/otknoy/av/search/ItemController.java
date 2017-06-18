package jp.otknoy.av.search;

import jp.otknoy.av.dmm.DmmSearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ItemController {
    private final DmmSearchService dmmSearchService;
    private final ItemMapper itemMapper;

    @RequestMapping("/")
    public String index() {
        return "It works.";
    }

    @CrossOrigin
    @RequestMapping("/search")
    public Response search(@Validated Request request) {
        long start = System.currentTimeMillis();

        log.info(request.toString());

        List<Item> items = itemMapper.map(
                (dmmSearchService.search(
                        request.getKeyword(),
                        request.getHits(),
                        request.getOffset(),
                        request.getSort()))
                        .getResult().getItems());

        long elapsed = System.currentTimeMillis() - start;
        log.info("response time: {} ms", elapsed);

        return Response.builder()
                .request(request)
                .items(items)
                .build();
    }
}
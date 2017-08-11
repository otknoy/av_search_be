package jp.otknoy.av.search;

import jp.otknoy.av.dmm.DmmSearchService;
import jp.otknoy.av.search.response.Item;
import jp.otknoy.av.search.response.Response;
import jp.otknoy.av.search.response.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ItemController {
    private final DmmSearchService dmmSearchService;
    private final ItemMapper itemMapper;

    @GetMapping("/")
    public String index() {
        return "It works.";
    }

    @CrossOrigin
    @GetMapping("/search")
    public Response search(@Validated Request request) {
        long start = System.currentTimeMillis();

        log.info(request.toString());

        jp.otknoy.av.dmm.item.Response dmmResponse = dmmSearchService.search(
                request.getKeyword(),
                request.getHits(),
                request.getOffset(),
                request.getSort());

        List<Item> items = itemMapper.map(dmmResponse.getResult().getItems());

        long elapsed = System.currentTimeMillis() - start;
        log.info("response time: {} ms", elapsed);

        return Response.builder()
                .request(request)
                .result(Result.builder()
                        .resultCount(dmmResponse.getResultCount())
                        .totalCount(dmmResponse.getTotalCount())
                        .firstPosition(dmmResponse.getFirstPosition())
                        .items(items)
                        .build())
                .build();
    }
}
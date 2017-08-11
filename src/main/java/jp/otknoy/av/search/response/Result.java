package jp.otknoy.av.search.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Result {
    private int resultCount;
    private int totalCount;
    private int firstPosition;

    private List<Item> items;
}

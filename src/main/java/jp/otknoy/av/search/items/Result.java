package jp.otknoy.av.search.items;

import java.util.List;
import lombok.Data;

@Data
public class Result {
    private int status;
    private int resultCount;
    private int totalCount;
    private int firstPosition;

    private List<Item> items;
}

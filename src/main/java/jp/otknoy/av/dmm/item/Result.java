package jp.otknoy.av.dmm.item;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
public class Result implements Serializable {
    private int status;
    private int resultCount;
    private int totalCount;
    private int firstPosition;

    private List<Item> items;
}

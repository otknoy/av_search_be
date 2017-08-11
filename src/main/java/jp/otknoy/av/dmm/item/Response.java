package jp.otknoy.av.dmm.item;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Response implements Serializable {
    private int resultCount;
    private int totalCount;
    private int firstPosition;
    private Result result;
}

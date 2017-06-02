package jp.otknoy;

import lombok.Data;

@Data
public class SearchRequest {
    private String keyword;
    private int hits;
    private int offset;
    private String sort;
}

package jp.otknoy.av.search;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Response {
    private Request request;
    private List<Item> items;
}

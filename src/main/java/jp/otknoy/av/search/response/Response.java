package jp.otknoy.av.search.response;

import jp.otknoy.av.search.Request;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    private Request request;
    private Result result;
}

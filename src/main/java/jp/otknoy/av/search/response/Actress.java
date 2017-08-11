package jp.otknoy.av.search.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Actress {
    private String name;
    private String yomigana;
}

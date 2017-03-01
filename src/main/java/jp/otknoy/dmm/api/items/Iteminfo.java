package jp.otknoy.dmm.api.items;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Iteminfo {
    private List<Genre> genre;
    private List<Series> series;
    private List<Maker> maker     = new ArrayList<>();
    private List<Actress> actress = new ArrayList<>();
}

package jp.otknoy.av.dmm.item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Iteminfo implements Serializable {
    private List<Genre> genre     = new ArrayList<>();
    private List<Series> series   = new ArrayList<>();
    private List<Maker> maker     = new ArrayList<>();
    private List<Actress> actress = new ArrayList<>();
}

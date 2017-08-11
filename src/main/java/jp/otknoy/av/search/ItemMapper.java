package jp.otknoy.av.search;

import jp.otknoy.av.dmm.item.Genre;
import jp.otknoy.av.dmm.item.Maker;
import jp.otknoy.av.dmm.item.Series;
import jp.otknoy.av.search.response.Actress;
import jp.otknoy.av.search.response.Item;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemMapper {

    public Item map(jp.otknoy.av.dmm.item.Item item) {
        Iterator<jp.otknoy.av.dmm.item.Actress> iterator = item.getIteminfo().getActress().iterator();
        List<Actress> actress = new ArrayList<>();
        while (iterator.hasNext()) {
            jp.otknoy.av.dmm.item.Actress a = iterator.next();

            String id = a.getId();
            String name = a.getName();

            a = iterator.next();
            if (!a.getId().equals(id + "_ruby")) {
                continue;
            }

            String yomigana = a.getName();

            actress.add(Actress.builder()
                    .name(name)
                    .yomigana(yomigana)
                    .build());

            iterator.next();
        }

        return Item.builder()
                .title(item.getTitle())
                .url(item.getAffiliateURL())
                .imageUrl(item.getImageURL().getLarge())
                .date(item.getDate())
                .genre(item.getIteminfo().getGenre().stream()
                        .map(Genre::getName)
                        .collect(Collectors.toList()))
                .maker(item.getIteminfo().getMaker().stream()
                        .map(Maker::getName)
                        .collect(Collectors.toList()))
                .series(item.getIteminfo().getSeries().stream()
                        .map(Series::getName)
                        .collect(Collectors.toList()))
                .actress(actress)
                .build();
    }

    public List<Item> map(List<jp.otknoy.av.dmm.item.Item> items) {
        return items.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}

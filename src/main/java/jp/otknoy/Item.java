package jp.otknoy;

import java.util.List;
import lombok.Data;
import java.util.stream.Collectors;

@Data
public class Item {
    private String title;
    private String imageUrl;
    private List<String> actress;
    private List<String> genre;

    public static Item create(jp.otknoy.dmm.api.itemlist.Item item) {
	Item i = new Item();
	i.setTitle(item.getTitle());
	i.setImageUrl(item.getImageURL().getList());

	jp.otknoy.dmm.api.itemlist.Iteminfo iteminfo
	    = item.getIteminfo();
	List<jp.otknoy.dmm.api.itemlist.Genre> genres
	    = iteminfo.getGenre();
	List<jp.otknoy.dmm.api.itemlist.Actress> actresses
	    = iteminfo.getActress();

	i.setGenre(genres.stream()
		   .map(a -> a.getName())
		   .collect(Collectors.toList()));

	i.setActress(actresses.stream()
		     .filter(e -> {
			     return actresses.indexOf(e) % 3 == 0;
			 })
		     .map(a -> a.getName())
		     .collect(Collectors.toList()));

	return i;
    }

    public static List<Item> create(jp.otknoy.dmm.Response response) {
	return response.getResult().getItems()
	    .stream()
	    .map(i -> Item.create(i))
	    .collect(Collectors.toList());
    }
}

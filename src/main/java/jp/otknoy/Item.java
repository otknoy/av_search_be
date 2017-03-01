package jp.otknoy;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import java.util.stream.Collectors;

@Data
public class Item {

    private String title;
    private String url;
    private String imageUrl;
    private List<String> actress = new ArrayList<>();
    private List<String> genre   = new ArrayList<>();

    public static Item create(jp.otknoy.dmm.api.items.Item item) {
	Item i = new Item();
	i.setTitle(item.getTitle());
	i.setUrl(item.getAffiliateURL());
	i.setImageUrl(item.getImageURL().getSmall());

	jp.otknoy.dmm.api.items.Iteminfo iteminfo
	    = item.getIteminfo();
	List<jp.otknoy.dmm.api.items.Genre> genres
	    = iteminfo.getGenre();
	List<jp.otknoy.dmm.api.items.Actress> actresses
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

    public static List<Item> create(jp.otknoy.dmm.api.items.Response response) {
	return response.getResult().getItems()
	    .stream()
	    .map(Item::create)
	    .collect(Collectors.toList());
    }
}

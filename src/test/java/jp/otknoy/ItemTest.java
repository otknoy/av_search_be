package jp.otknoy;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import jp.otknoy.Item;

public class ItemTest {

    private List<jp.otknoy.dmm.api.items.Item> items;

    @Before
    public void setUp() {
	List<jp.otknoy.dmm.api.items.Item> items
	    = new ArrayList<>();

	jp.otknoy.dmm.api.items.Item item1
	    = new jp.otknoy.dmm.api.items.Item();
	item1.setTitle("aaa title");
	item1.setAffiliateURL("http://affiliate.url.test");

	jp.otknoy.dmm.api.items.ImageUrl imageUrl
	    = new jp.otknoy.dmm.api.items.ImageUrl();
	imageUrl.setList("http://hogehoge.com/list.jpg");
	item1.setImageURL(imageUrl);

	jp.otknoy.dmm.api.items.Iteminfo iteminfo
	    = new jp.otknoy.dmm.api.items.Iteminfo();

	jp.otknoy.dmm.api.items.Genre genre
	    = new jp.otknoy.dmm.api.items.Genre();
	genre.setName("genre1");
	genre.setId(1);
	iteminfo.setGenre(Arrays.asList(genre));

	jp.otknoy.dmm.api.items.Actress actress
	    = new jp.otknoy.dmm.api.items.Actress();
	actress.setName("actress1");
	actress.setId("11");
	iteminfo.setActress(Arrays.asList(actress));

	item1.setIteminfo(iteminfo);

	items.add(item1);

	this.items = items;
    }

    @Test
    public void testCreateItem() {
	jp.otknoy.dmm.api.items.Item dmmItem
	    = this.items.get(0);
	Item item = Item.create(dmmItem);

	assertEquals("aaa title", dmmItem.getTitle());
	assertEquals("http://affiliate.url.test", item.getUrl());
	assertEquals("http://hogehoge.com/list.jpg", item.getImageUrl());
	assertEquals("genre1", item.getGenre().get(0));
    	assertEquals("actress1", item.getActress().get(0));
    }
}

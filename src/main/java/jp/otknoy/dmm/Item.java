package jp.otknoy.dmm;

import java.util.List;

public class Item {
    public String title;
    public Integer price;
    public String affiliateURL;
    public ImageUrl imageURL;
    public Prices prices;
    public String date;
    public Iteminfo iteminfo;
}

class ImageUrl {
    public String list;
    public String small;
    public String large;
}

class Prices {
    public String price;
    public Deliveries deliveries;

    public static class Deliveries {
	public List<Delivery> delivery;

	public static class Delivery {
	    public String type;
	    public int price;
	}
    }
}

class Iteminfo {
    public List<Genre> genre;
    public List<Series> series;
    public List<Maker> maker;
    public List<Actress> actress;

    public static class Genre {
	public String name;
	public int id;
    }

    public static class Series {
	public String name;
	public int id;
    }

    public static class Maker {
	public String name;
	public int id;
    }

    public static class Actress {
	public String name;
	public String id;
    }
}

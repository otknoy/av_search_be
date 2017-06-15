package jp.otknoy.av.search.dmm.item;

import java.util.List;
import lombok.Data;

@Data
public class Prices {
    private String price;
    private Deliveries deliveries;

    static class Deliveries {
	public List<Delivery> delivery;

	public static class Delivery {
	    public String type;
	    public int price;
	}
    }
}

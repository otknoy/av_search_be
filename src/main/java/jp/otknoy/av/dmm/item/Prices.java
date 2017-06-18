package jp.otknoy.av.dmm.item;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
public class Prices implements Serializable{
    private String price;
    private Deliveries deliveries;

    static class Deliveries implements Serializable {
		public List<Delivery> delivery;

		public static class Delivery implements Serializable {
			public String type;
			public int price;
		}
	}
}
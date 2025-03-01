package login;

public class StockVo {

	private String name;
	private String goodNo;
	private String loc;
	private String stocks;
	private String storeNo;
	private int unitPrice;
	
	public StockVo(String name, String stocks) {
		this.name = name;
		this.stocks = stocks;
	}
	
	public StockVo(String goodNo, String name, String stocks, int unitPrice, String loc) {
		this.goodNo = goodNo;
		this.name = name;
		this.stocks = stocks;
		this.unitPrice = unitPrice;
		this.loc = loc;
	}
	
	
	
	public String getName() {
		return name;
	}
	public String getGoodNo() {
		return goodNo;
	}
	public String getLoc() {
		return loc;
	}
	public String getStocks() {
		return stocks;
	}
	public String getStoreNo() {
		return storeNo;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	
	
}

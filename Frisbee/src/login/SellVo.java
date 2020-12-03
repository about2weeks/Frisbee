package login;

public class SellVo {
	
	private String storeNo;
	private String goodsNo;
	private String sellTime;
	private String goodsName;
	private int qtty;
	private long unitPrice;
	
	public SellVo(String storeNo, String goodsNo, String sellTime, String goodsName, int qtty, long unitPrice) {
		this.storeNo = storeNo;
		this.goodsNo = goodsNo;
		this.sellTime = sellTime;
		this.goodsName = goodsName;
		this.qtty = qtty;
		this.unitPrice = unitPrice;
	}
	
	
	public String getStoreNo() {
		return storeNo;
	}
	public String getGoodsNo() {
		return goodsNo;
	}
	public String getSellTime() {
		return sellTime;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public int getQtty() {
		return qtty;
	}
	public long getUnitPrice() {
		return unitPrice;
	}
	
	
	
}

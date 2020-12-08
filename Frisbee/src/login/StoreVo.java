package login;

public class StoreVo {

	private String storeName;
	private String storeNo;
	private String loc;
	
	public StoreVo(String storeName, String loc) {
		this.storeName = storeName;
		this.loc = loc;
	}
	
	
	public String getStoreName() {
		return storeName;
	}
	public String getStoreNo() {
		return storeNo;
	}
	public String getLoc() {
		return loc;
	}
	
	
	
}

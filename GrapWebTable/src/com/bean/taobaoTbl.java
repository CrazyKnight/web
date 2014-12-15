package com.bean;

public class taobaoTbl {
    private String Multi;//标记字段
	private String numItem; // 订单号
	private String shops; // 店铺名
	private String baobeiNames; // 宝贝名称
	private String Specs; // 货物信息
	private String prices; // 价格信息
	private String qutys; // 购买数量
	
	public String getMulti() {
        return Multi;
    }

    public void setMulti(String multi) {
        Multi = multi;
    }

    public String getNumItem() {
		return numItem;
	}

	public void setNumItem(String numItem) {
		this.numItem = numItem;
	}

	public String getShops() {
		return shops;
	}

	public void setShops(String shops) {
		this.shops = shops;
	}

	public String getBaobeiNames() {
		return baobeiNames;
	}

	public void setBaobeiNames(String baobeiNames) {
		this.baobeiNames = baobeiNames;
	}

	public String getSpecs() {
		return Specs;
	}

	public void setSpecs(String specs) {
		Specs = specs;
	}

	public String getPrices() {
		return prices;
	}

	public void setPrices(String prices) {
		this.prices = prices;
	}

	public String getQutys() {
		return qutys;
	}

	public void setQutys(String qutys) {
		this.qutys = qutys;
	}
	public void set(String s,String v) {
	    if(s.equals("Multi")) {
	        this.setMulti(v);
	    }else if (s.equals("numItem")) {
            this.setNumItem(v);
        } else if (s.equals("shops")) {
            this.setShops(v);
        } else if (s.equals("baobeiNames")) {
            this.setBaobeiNames(v);
        } else if (s.equals("Specs")) {
            this.setSpecs(v);
        } else if (s.equals("prices")) {
            this.setPrices(v);
        } else if (s.equals("qutys")) {
            this.setQutys(v);
        }
        return;
    }
	
}

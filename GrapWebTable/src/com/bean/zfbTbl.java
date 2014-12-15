package com.bean;

public class zfbTbl {
	private String csmBNos;
	private String times;
	private String infos;
	private String incomes;
	private String outlays;
	private String balances;
	private String froms;

	public String getCsmBNos() {
		return csmBNos;
	}

	public void setCsmBNos(String csmBNos) {
		this.csmBNos = csmBNos;
	}

	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	public String getInfos() {
		return infos;
	}

	public void setInfos(String infos) {
		this.infos = infos;
	}

	public String getIncomes() {
		return incomes;
	}

	public void setIncomes(String incomes) {
		this.incomes = incomes;
	}

	public String getOutlays() {
		return outlays;
	}

	public void setOutlays(String outlays) {
		this.outlays = outlays;
	}

	public String getBalances() {
		return balances;
	}

	public void setBalances(String balances) {
		this.balances = balances;
	}

	public String getFroms() {
		return froms;
	}

	public void setFroms(String froms) {
		this.froms = froms;
	}
	
	public void set(String s,String v) {
        if (s.equals("csmBNos")) {
            this.setCsmBNos(v);
        } else if (s.equals("times")) {
            this.setTimes(v);
        } else if (s.equals("infos")) {
            this.setInfos(v);
        } else if (s.equals("incomes")) {
            this.setIncomes(v);
        } else if (s.equals("outlays")) {
            this.setOutlays(v);
        } else if (s.equals("balances")) {
            this.setBalances(v);
        } else if (s.equals("froms")) {
            this.setFroms(v);
        }
        return;
    }
}

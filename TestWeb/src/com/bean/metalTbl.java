package com.bean;

public class metalTbl {
	private String Metal;
	private String MelPoint_C;
	private String MelPoint_F;

	public String getMetal() {
		return Metal;
	}

	public void setMetal(String metal) {
		Metal = metal;
	}

	public String getMelPoint_C() {
		return MelPoint_C;
	}

	public void setMelPoint_C(String melPoint_C) {
		MelPoint_C = melPoint_C;
	}

	public String getMelPoint_F() {
		return MelPoint_F;
	}

	public void setMelPoint_F(String melPoint_F) {
		MelPoint_F = melPoint_F;
	}

	public void set(String s,String v) {
        if (s.equals("Metal")) {
            this.setMetal(v);
        } else if (s.equals("MelPoint_C")) {
            this.setMelPoint_C(v);
        } else if (s.equals("MelPoint_F")) {
            this.setMelPoint_F(v);
        }
        return;
    }
}

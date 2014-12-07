package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bean.*;



public class MyOperation {
    public void addgrade(gradeTbl L, String database, String user,
            String password, String tblName, boolean isFirst) {
        MyConnection util = new MyConnection();
        Connection conn = util.getConnection(database, user, password);
        String sql = "insert into " + tblName + " values(?,?,?,?,?,?,?,?,?,?)";
        try {
            if (isFirst) {
                conn.prepareStatement("delete from table1").executeUpdate();
            }
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, L.getTerm());
            pstmt.setString(2, L.getLessonNum());
            pstmt.setString(3, L.getLessonName());
            pstmt.setString(4, L.getTecherName());
            pstmt.setString(5, L.getKind());
            pstmt.setString(6, L.getGrade());
            pstmt.setString(7, L.getTime());
            pstmt.setString(8, L.getMyPoint());
            pstmt.setString(9, L.getGradeKind());
            pstmt.setString(10, L.getRemark());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.close(conn);
        }

    }
	public void addbaobei(taobaoTbl T,String database,String user,String password,String tblName ){
		MyConnection util = new MyConnection();
		Connection conn = util.getConnection(database, user, password);
		String sql = "insert into "+tblName+" values(?,?,?,?,?,?)";
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, T.getNumItem());
			pstmt.setString(2, T.getShops());
			pstmt.setString(3, T.getBaobeiNames());
			pstmt.setString(4, T.getSpecs());
			pstmt.setString(5, T.getPrices());
			pstmt.setString(6, T.getQutys());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.close(conn);
		}
	}
	
	public void addzfb(zfbTbl T,String database,String user,String password,String tblName){
		MyConnection util = new MyConnection();
		Connection conn = util.getConnection(database, user, password);
		String sql = "insert into "+tblName+" values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, T.getCsmBNos());
			pstmt.setString(2, T.getTimes());
			pstmt.setString(3, T.getInfos());
			pstmt.setString(4, T.getIncomes());
			pstmt.setString(5, T.getOutlays());
			pstmt.setString(6, T.getBalances());
			pstmt.setString(7, T.getFroms());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.close(conn);
		}
	}
	
	public void addphoneRecord(phoneRecordTbl T, String database, String user,
            String password, String tblName, boolean isFirst) {
        MyConnection util = new MyConnection();
        Connection conn = util.getConnection(database, user, password);
        String sql = "insert into " + tblName + " values(?,?,?,?,?,?,?,?)";
        try {
            if (isFirst) {
                conn.prepareStatement("delete from table4").executeUpdate();
                return;
            }
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, T.getNum());
            pstmt.setString(2, T.getFrom_phone());
            pstmt.setString(3, T.getCity_code());
            pstmt.setString(4, T.getTo_phone());
            // pstmt.setString(5, T.getSt_time());
            pstmt.setString(5, T.getTime_length());
            pstmt.setString(6, T.getPrice());
            pstmt.setString(7, T.getWay());
            pstmt.setString(8, T.getExtend_price());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.close(conn);
        }
    }
	
	
	public void adddouban(doubanTbl T,String database,String user,String password,String tblName){
		MyConnection util = new MyConnection();
		Connection conn = util.getConnection(database, user, password);
		String sql = "insert into "+tblName+" values(?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, T.getTopic());
			pstmt.setString(2, T.getAuthor());
			pstmt.setString(3, T.getResponse());
			pstmt.setString(4, T.getLast_re());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.close(conn);
		}
	}
	
	public void addmetal(metalTbl T, String database, String user,
            String password, String tblName, boolean isFirst) {
        MyConnection util = new MyConnection();
        Connection conn = util.getConnection(database, user, password);
        String sql = "insert into " + tblName + " values(?,?,?)";
        try {
            if (isFirst) {
                conn.prepareStatement("delete from table6").executeUpdate();
            }
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, T.getMetal());
            pstmt.setString(2, T.getMelPoint_C());
            pstmt.setString(3, T.getMelPoint_F());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.close(conn);
        }
    }
	
	
	public void addsong(singTbl T,String database,String user,String password,String tblName){
		MyConnection util = new MyConnection();
		Connection conn = util.getConnection(database, user, password);
		String sql = "insert into "+tblName+" values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, T.getCur_week());
			pstmt.setString(2, T.getLast_week());
			pstmt.setString(3, T.getNum_week());
			pstmt.setString(4, T.getAlbum());
			pstmt.setString(5, T.getSong());
			pstmt.setString(6, T.getSinger());
			pstmt.setString(7, T.getCompany());
			pstmt.setString(8, T.getTop_his());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.close(conn);
		}
	}
	
	 public void addgaokao(gaokaoTbl T, String database, String user,
	            String password, String tblName, boolean isFirst) {
	        MyConnection util = new MyConnection();
	        Connection conn = util.getConnection(database, user, password);
	        String sql = "insert into " + tblName + " values(?,?)";
	        try {
	            if (isFirst) {
	                conn.prepareStatement("delete from table8").executeUpdate();
	            }
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, T.getGrade());
	            pstmt.setString(2, T.getStuNum());
	            pstmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            util.close(conn);
	        }
	    }
	public void addmovie(movieTbl T,String database,String user,String password,String tblName){
		MyConnection util = new MyConnection();
		Connection conn = util.getConnection(database, user, password);
		String sql = "insert into "+tblName+" values(?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, T.getName());
			pstmt.setString(2, T.getActor());
			pstmt.setString(3, T.getPlace());
			pstmt.setString(4, T.getType());
			pstmt.setString(5, T.getGrade());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.close(conn);
		}
	}
	
	public void addBT(btTbl T, String database, String user, String password,
            String tblName, boolean isFirst) {
        MyConnection util = new MyConnection();
        Connection conn = util.getConnection(database, user, password);
        String sql = "insert into " + tblName + " values(?,?,?,?,?)";
        try {
            if (isFirst) {
                conn.prepareStatement("delete from table8").executeUpdate();
            }
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, T.getTitle());
            pstmt.setString(2, T.getDay());
            pstmt.setString(3, T.getActor());
            pstmt.setString(4, T.getType());
            pstmt.setString(5, T.getScan_num());

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.close(conn);
        }
    }
}

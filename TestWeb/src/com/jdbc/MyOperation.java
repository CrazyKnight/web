package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.*;

public class MyOperation {
	public boolean exit_user(String username,String password){
		
		List<String> temp = new ArrayList<String>();
		 MyConnection util = new MyConnection();
	     Connection conn = util.getConnection();
	     String sql = "select *from users where name = ? and password =?";
	     try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				temp.add(rs.getString("name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	     if(temp.isEmpty()){
				return false;
			}else{
				return true;
			}			
	}
public boolean exit_username(String username){
		
		List<String> temp = new ArrayList<String>();
		 MyConnection util = new MyConnection();
	     Connection conn = util.getConnection();
	     String sql = "select * from users where name = ?";
	     try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				temp.add(rs.getString("name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	     if(temp.isEmpty()){
				return false;
			}else{
				return true;
			}			
	}
	public void addUser(String username,String password){
		MyConnection util = new MyConnection();
	     Connection conn = util.getConnection();
	     String sql = "insert into users values(?,?)";
	     try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,username);
			pstmt.setString(2,password);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
    public void addgrade(gradeTbl L, String database, String user,
            String password, String tblName, boolean isFirst) {
        MyConnection util = new MyConnection();
        Connection conn = util.getConnection();
        String sql = "insert into " + tblName + " values(?,?,?,?,?,?,?,?,?,?)";
        try {
            if (isFirst) {
                Statement stmt = conn.createStatement();
                stmt.execute("drop table if exists table1");
                stmt.execute("create table table1("+
                                "term varchar(50),"+
                                "lessonNum varchar(50),"+
                                "lessonName varchar(50),"+
                                "techerName varchar(50),"+
                                "kind varchar(50),"+
                                "grade varchar(50),"+
                                "time varchar(50),"+
                                "myPoint varchar(50),"+
                                "gradeKind varchar(50),"+
                                "remark varchar(50));");
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

    public void addbaobei(taobaoTbl T, String database, String user,
            String password, String tblName) {
        MyConnection util = new MyConnection();
        //Connection conn = util.getConnection(database, user, password);
        Connection conn = util.getConnection();
        String sql = "insert into " + tblName + " values(?,?,?,?,?,?,?)";
        try {

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, T.getMulti());
            pstmt.setString(2, T.getNumItem());
            pstmt.setString(3, T.getShops());
            pstmt.setString(4, T.getBaobeiNames());
            pstmt.setString(5, T.getSpecs());
            pstmt.setString(6, T.getPrices());
            pstmt.setString(7, T.getQutys());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.close(conn);
        }
    }

    public void addzfb(zfbTbl T, String database, String user, String password,
            String tblName) {
        MyConnection util = new MyConnection();
      //Connection conn = util.getConnection(database, user, password);
        Connection conn = util.getConnection();
        String sql = "insert into " + tblName + " values(?,?,?,?,?,?,?)";
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
        //Connection conn = util.getConnection(database, user, password);
        Connection conn = util.getConnection();
        String sql = "insert into " + tblName + " values(?,?,?,?,?,?,?,?)";
        try {
            if (isFirst) {
                Statement stmt = conn.createStatement();
                stmt.execute("drop table if exists table4");
                stmt.execute("create table table4("+
                        "num varchar(20),"+
                        "from_phone varchar(20),"+
                        "city_code varchar(20),"+
                        "to_phone varchar(20),"+
                        "time_length varchar(20),"+
                        "price varchar(20),"+
                        "way varchar(20),"+
                        "extend_price varchar(20));");
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

    public void adddouban(doubanTbl T, String database, String user,
            String password, String tblName) {
        MyConnection util = new MyConnection();
      //Connection conn = util.getConnection(database, user, password);
        Connection conn = util.getConnection();
        String sql = "insert into " + tblName + " values(?,?,?,?)";
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
        //Connection conn = util.getConnection(database, user, password);
        Connection conn = util.getConnection();
        String sql = "insert into " + tblName + " values(?,?,?)";
        try {
            if (isFirst) {
                Statement stmt = conn.createStatement();
                stmt.execute("drop table if exists table6");
                stmt.execute("create table table6("+
                        "Metal varchar(20),"+
                        "MelPoint_C varchar(20),"+
                        "MelPoint_F varchar(20));");
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

    public void addsong(singTbl T, String database, String user,
            String password, String tblName) {
        MyConnection util = new MyConnection();
      //Connection conn = util.getConnection(database, user, password);
        Connection conn = util.getConnection();
        String sql = "insert into " + tblName + " values(?,?,?,?,?,?,?,?)";
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
        //Connection conn = util.getConnection(database, user, password);
        Connection conn = util.getConnection();
        String sql = "insert into " + tblName + " values(?,?)";
        try {
            if (isFirst) {
                Statement stmt = conn.createStatement();
                stmt.execute("drop table if exists table8");
                stmt.execute("create table table8("+
                        "grade varchar(20),"+
                        "stuNum varchar(20));");
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

    public void addmovie(movieTbl T, String database, String user,
            String password, String tblName) {
        MyConnection util = new MyConnection();
      //Connection conn = util.getConnection(database, user, password);
        Connection conn = util.getConnection();
        String sql = "insert into " + tblName + " values(?,?,?,?,?)";
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
        //Connection conn = util.getConnection(database, user, password);
        Connection conn = util.getConnection();
        String sql = "insert into " + tblName + " values(?,?,?,?,?)";
        try {
            if (isFirst) {
                Statement stmt = conn.createStatement();
                stmt.execute("drop table if exists table10");
                stmt.execute("create table table10("+
                        "title varchar(100),"+
                        "day varchar(20),"+
                        "actor varchar(50),"+
                        "type varchar(50),"+
                        "scan_num varchar(20));");
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

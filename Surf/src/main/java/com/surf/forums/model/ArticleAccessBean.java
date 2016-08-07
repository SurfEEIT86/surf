package com.surf.forums.model;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;






public class ArticleAccessBean implements Serializable {

	
	@Autowired
	ForumService forumService;
	private static final long serialVersionUID = 1L;
	private DataSource ds = null; // 查詢單筆商品會用到此代號
	private int pageNo = 0;
	private int recordsPerPage = 10; // 每頁5筆
	private int totalPages = -1;

	public ArticleAccessBean() throws ServletException, IOException,
			NamingException {
		Context ctx = new InitialContext();
		ds = (DataSource) ctx.lookup("java:comp/env/jdbc/xxx");
	}
	
	
	public List<Integer> getPageArticle(Integer forumno) throws SQLException {
		
		forumService=new ForumService();
		if(forumService!=null){
			System.out.println("forumService is here");
		}else{
			System.out.println("forumService not found");
		}
		PreparedStatement pStmt = null;
		Connection connection = null;
		ResultSet rs = null;
		List<Integer> coll = new ArrayList<Integer>();
		try {
			String queryPageString = 
			"select * from (select ROW_NUMBER() over (order by datetime desc)"+
			" as RowNum , b.articleno , b.title, b.memberno,b.forumno,"+
			"b.datetime,b.context from articles b where b.forumno=?) as newtable where RowNum>=? and RowNum<=?";
			connection = ds.getConnection();
			pStmt = connection.prepareStatement(queryPageString);
			int startRecordNo = (pageNo - 1) * recordsPerPage + 1;
			int endRecordNo = (pageNo) * recordsPerPage;
			// PreparedStatement物件內所有的問號都要有值，否則執行pStmt.executeQuery()
			// 或pStmt.executeUpdate()時程式一定會掛掉。
			pStmt.setInt(1, forumno);
			pStmt.setInt(2, startRecordNo);
			pStmt.setInt(3, endRecordNo);
			System.out.println("forumno "+forumno);
			System.out.println("startRecordNo "+startRecordNo);
			System.out.println("endRecordNo "+endRecordNo);
			rs = pStmt.executeQuery();
			// 如果ResultSet內含有未讀取的紀錄
			while (rs.next()) {
				Integer articleNo = rs.getInt(2);
				coll.add(articleNo);
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pStmt != null) {
				pStmt.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
		return coll;
	}
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	
	
	
	
	
	
	/*計算每個版區的頁數*/
	public int getForumArticlesTotalPages(int no) throws SQLException {
		// 計算總共有幾頁
		if (totalPages == -1) {
			// 注意下一列的double型態轉換
			totalPages = (int) (Math.ceil(getForumArticlesCounts(no)
					/ (double) recordsPerPage));
		}
		return totalPages;
	}
	/*每個版區的總筆數 參數為版區編號*/
	public int getForumArticlesCounts(int no) throws SQLException {
		String sql = "SELECT count(*) FROM articles where forumno=?";
		PreparedStatement pStmt = null;
		Connection connection = null;
		ResultSet rs = null;
		int result = 0;
		try {
			connection = ds.getConnection();
			pStmt = connection.prepareStatement(sql);
			pStmt.setInt(1,no);
			rs = pStmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt(1);
			}
		} finally {
			if (rs != null) {
				try {
				   rs.close();
				} catch(SQLException e){
					e.printStackTrace();
				}
			}
			if (pStmt != null) {
				try {
					pStmt.close();
				} catch(SQLException e){
				   e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	/*取的會員發表文章的分頁數*/
	public int getMemberArticlesTotalPages(int no) throws SQLException {
		// 計算總共有幾頁
		if (totalPages == -1) {
			// 注意下一列的double型態轉換
			totalPages = (int) (Math.ceil(getMemberArticlesCounts(no)
					/ (double) recordsPerPage));
		}
		return totalPages;
	}
	/*取的會員發表文章的總筆數*/
	public int getMemberArticlesCounts(int no) throws SQLException {
		String sql = "SELECT count(*) FROM articles where memberno=?";
		PreparedStatement pStmt = null;
		Connection connection = null;
		ResultSet rs = null;
		int result = 0;
		try {
			connection = ds.getConnection();
			pStmt = connection.prepareStatement(sql);
			pStmt.setInt(1,no);
			rs = pStmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt(1);
			}
		} finally {
			if (rs != null) {
				try {
				   rs.close();
				} catch(SQLException e){
					e.printStackTrace();
				}
			}
			if (pStmt != null) {
				try {
					pStmt.close();
				} catch(SQLException e){
				   e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	
	
	
//	public int getManageArticlesTotalPages(int memberno,int forumno,String datetime,String datetimeEnd) throws SQLException {
//		// 計算總共有幾頁
//		if (totalPages == -1) {
//			// 注意下一列的double型態轉換
//			totalPages = (int) (Math.ceil(getManageArticlesCounts(memberno,forumno,datetime,datetimeEnd)
//					/ (double) recordsPerPage));
//		}
//		return totalPages;
//	}
//	/*取的會員發表文章的總筆數*/
//	public int getManageArticlesCounts(int memberno,int forumno,String datetimeStart,String datetimeEnd) throws SQLException {
//		String sql = null ;
//		PreparedStatement pStmt = null;
//		Connection connection = null;
//		ResultSet rs = null;
//		int result = 0;
//		connection = ds.getConnection();
//		
//		try {
//		if(forumno==-1&&!datetimeStart.equalsIgnoreCase("-1")&&!datetimeEnd.equalsIgnoreCase("-1")){		
//			sql="SELECT count(*) FROM articles where memberno=? and datetime>=? and datetime<=? order by datetime desc";
//			pStmt = connection.prepareStatement(sql);
//			pStmt.setInt(1,memberno);
//			pStmt.setString(2,datetimeStart);
//			pStmt.setString(3,datetimeEnd);
//		}
//		if(forumno!=-1&&!datetimeStart.equalsIgnoreCase("-1")&&!datetimeEnd.equalsIgnoreCase("-1")){		
//			sql="SELECT count(*) FROM articles where memberno=? and forumno=? and datetime>=? and datetime<=? order by datetime desc";
//			pStmt = connection.prepareStatement(sql);
//			pStmt.setInt(1,memberno);
//			pStmt.setInt(2,forumno);
//			pStmt.setString(3,datetimeStart);
//			pStmt.setString(4,datetimeEnd);
//		}
//		if(forumno==-1&&datetimeStart.equalsIgnoreCase("-1")&&datetimeEnd.equalsIgnoreCase("-1")){		
//			sql="SELECT count(*) FROM articles where memberno=? and datetime<=? order by datetime desc";
//			pStmt = connection.prepareStatement(sql);
//		}
//		if(forumno!=-1&&datetimeStart.equalsIgnoreCase("-1")&&datetimeEnd.equalsIgnoreCase("-1")){		
//			sql="SELECT count(*) FROM articles where memberno=? and forumno=? and datetime<=? order by datetime desc";
//			pStmt = connection.prepareStatement(sql);
//		}
//			
//			
//			
//			rs = pStmt.executeQuery();
//
//			if (rs.next()) {
//				result = rs.getInt(1);
//			}
//		} finally {
//			if (rs != null) {
//				try {
//				   rs.close();
//				} catch(SQLException e){
//					e.printStackTrace();
//				}
//			}
//			if (pStmt != null) {
//				try {
//					pStmt.close();
//				} catch(SQLException e){
//				   e.printStackTrace();
//				}
//			}
//			if (connection != null) {
//				try {
//					connection.close();
//				} catch(SQLException e){
//					e.printStackTrace();
//				}
//			}
//		}
//		return result;
//	}
	
	

}

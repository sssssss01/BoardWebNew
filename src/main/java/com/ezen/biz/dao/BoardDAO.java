package com.ezen.biz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ezen.biz.common.JDBCUtil;
import com.ezen.biz.dto.BoardVO;

@Repository("boardDAO")  //스프링 프레임워크에서 사용할거니까 미리 객체를 만들어달라
public class BoardDAO {
	Connection conn;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//sql 명령어 상수
	private static final  String Board_insert =
			"insert into board(seq, title, writer, content) values(board_seq.NEXTVAL, ?, ?, ?)";
	
	private static final String Board_Update = 
			"update board set title=? content=? where seq=?";
	
	private static final String Board_Delete = 
			"delete board where seq=?";
	
	private static final String Board_get =
			"select * from board where seq=?";
	
	private static final String Board_list = 
			"select * from board order by seq desc";
	
	
	//게시글 등록
	public void insertBoard(BoardVO board) {
		System.out.println("== jdbc로 insertBoard() 기능 처리");
	
		try {
			conn = JDBCUtil.getConnection();
			pstmt  = conn.prepareStatement(Board_insert);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt);
			
		}
	
	}
	public void updateBoard(BoardVO board) {
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(Board_Update);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getSeq());
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(conn, pstmt);
			
		}
	}
		
	
	
	public void deleteBoard(BoardVO board) {
		try {
			
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(Board_get);
			pstmt.setInt(1, board.getSeq());
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	
	public BoardVO getBoard(BoardVO board) {
		
		try{
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(Board_Delete);
			pstmt.setInt(1, board.getSeq());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));	
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return board;
		
	}
	
	public List<BoardVO> getBoardList(){
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(Board_list);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO bvo = new BoardVO();
				
				bvo.setSeq(rs.getInt("seq"));
				bvo.setTitle(rs.getString("title"));
				bvo.setWriter(rs.getString("writer"));
				bvo.setContent(rs.getString("content"));
				bvo.setRegdate(rs.getDate("regdate"));
				boardList.add(bvo);
			}
			
		}catch(Exception e) {
			
		}finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return boardList;
	}
}


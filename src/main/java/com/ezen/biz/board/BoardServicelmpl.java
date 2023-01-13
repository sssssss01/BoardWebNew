package com.ezen.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;


@Service("boardService")  //객체를 미리 만들어서 제공해줘라
public class BoardServicelmpl implements BoardService {
	
	//의존성 주입이 필요
	//BoardServicelmpl이 필요한데 BoardServicelmpl에서 dao를 사용함

	@Autowired 
	private BoardDAO bdao;
	
	@Override
	public void insertBoard(BoardVO board) {
		bdao.insertBoard(board);  //dao를 호출한 후 게시글 저장

	}

	@Override
	public void updateBoard(BoardVO board) {
		bdao.updateBoard(board);

	}

	@Override
	public void deleteBoard(BoardVO board) {
		bdao.deleteBoard(board);

	}

	@Override
	public BoardVO getBoard(BoardVO board) {
		return bdao.getBoard(board);
	}

	@Override
	public List<BoardVO> getBoardList() {
		return bdao.getBoardList();
		//별다른 처리가 없으면 리턴한다
	}

}

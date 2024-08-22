package com.grepp.model.servicies;

import com.grepp.model.dtos.BoardDTO;
import com.grepp.model.respositories.BoardRepository;
import com.grepp.model.respositories.BoardRepositoryMysql;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;


//SQL실행은 repo가 담당하고 나는 뭘 검사하고 판단하고 조작하는 비즈니스 로직에 대한 책임만 구현함.
public class BoardService {

    private BoardRepository repo = BoardRepositoryMysql.getInstance();
    //private UserRepository userRepository = UserRepositoryImpl.getInstance();

    private BoardService() {
    }//singleton

    private static BoardService instance = new BoardService();

    public static BoardService getInstance() {
        return instance;
    }

    ////////////////////////////////////////////////////////////////////////////////////
//글 읽기 수행할 때 작성자와 읽는 사용자가 일치하는지 검사해서 조회수 증가 update여부 판단하거나
    //이미 이 글을 읽은 사용자는 조회수 중복해서 증가하지 않도록 검사하거나 하는 로직을 수행하는 메서드. 지금은 처리 안함

    public List<BoardDTO> readAll() throws SQLException{
        return repo.selectAll();
    }

    public BoardDTO read(HttpSession session,int bno) throws SQLException {
        String loginId=(String) session.getAttribute("loginId");
        if(loginId==null){
            throw new IllegalArgumentException("not logined");
        }
        return repo.selectOne(bno);
    }

    public int writePost(HttpSession session, String title, String content, String writer) throws SQLException {
        // 세션에서 로그인 ID 가져오기
        String loginId = (String) session.getAttribute("loginId");//세션 로그인아이디 가져오기
        if (loginId == null) {
            throw new IllegalArgumentException("not logined");
        }
        BoardDTO boardDTO = new BoardDTO(title, content, writer);
        return repo.insert(boardDTO);

    }

    public int updatePost(HttpSession session,String title, String writer, String content, int No)throws SQLException{
        String loginId = (String) session.getAttribute("loginId");//세션 로그인아이디 가져오기
        if (loginId == null) {
            System.out.println("로그인 안됨.");
            throw new IllegalArgumentException("not logined");
        }
        BoardDTO boardDTO = new BoardDTO(title,content,writer);
        boardDTO.setNo(No);//글 번호
        System.out.println("Title: " + title);
        System.out.println("Content: " + content);
        System.out.println("Writer: " + writer);
        System.out.println("No: " + No);

        return repo.update(boardDTO);
    }


}

package com.grepp.controller;

import com.grepp.controller.util.MyPageInfo;
import com.grepp.model.dtos.BoardDTO;
import com.grepp.model.respositories.BoardRepository;
import com.grepp.model.respositories.BoardRepositoryMysql;
import com.grepp.model.servicies.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.sql.SQLException;
import java.util.List;

//board.do는 여기로 실행되겠네.
public class BoardController implements MyController{

    private BoardService boardService=BoardService.getInstance();
    private BoardRepository boardRepository= BoardRepositoryMysql.getInstance();

    @Override
    public Object handleRequest(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        String url=req.getServletPath();//url과 파라미터는 구분된다.
        HttpSession session= req.getSession();
        if ("/board/list.do".equals(url)) {
            List<BoardDTO> boardList=boardRepository.selectAll();
            req.setAttribute("bList",boardList);
            return new MyPageInfo(true,"/list");
        } else if ("/board/read.do".equals(url)) {
            int no= Integer.parseInt(req.getParameter("no"));
            req.setAttribute("bbb",boardRepository.selectOne(no));
            return new MyPageInfo(true,"/view");

        }else if("/board/writeForm.do".equals(url)){//글 작성하게 form보여줘!
            return new MyPageInfo(true,"/write_form");
        }
        else if ("/board/write.do".equals(url)) {
            String title=req.getParameter("title");
            String content= req.getParameter("content");
            String writer=(String) req.getSession().getAttribute("loginId");
            boardService.writePost(session, title,content,writer);
            return new MyPageInfo(false,"/main.do");

        }
        return null;
    }
}

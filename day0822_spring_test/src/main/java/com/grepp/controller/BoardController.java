package com.grepp.controller;

import com.grepp.model.dtos.BoardDTO;
import com.grepp.model.servicies.BoardService;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/list")
public class BoardController {
    BoardService boardService = BoardService.getInstance();

    @GetMapping()
    public ModelAndView getList() throws SQLException {
        ModelAndView list= new ModelAndView();
        list.setViewName("list");
        List<BoardDTO> boardList= boardService.readAll();
        list.addObject("boards",boardList);
        return list;

    }

    @GetMapping("/write")
    public String write(HttpSession session, RedirectAttributes redirectAttributes){
        if(session.getAttribute("loginId")!=null){
            return "write";
        }
        else {
            redirectAttributes.addFlashAttribute("message", "로그인이 필요한 페이지입니다!!!!");
            return "redirect:/login";
        }
    }

    @PostMapping("/write")
    public String write(HttpSession session, @RequestParam("title") String title,@RequestParam("content") String content)throws SQLException{
        int result=boardService.writePost(session,title,content, (String) session.getAttribute("loginId"));
        System.out.println(session.getAttribute("loginId"));//로그인 아이디 잘 들어오노!
        if(result>0){
            return "redirect:/list";
        }
        return "redirect/list/write";

    }

    @GetMapping("/{listId}")
    public ModelAndView getOneList(@PathVariable("listId") int listId,HttpSession session)throws  SQLException{
        BoardDTO boardDTO=boardService.read(session,listId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view");
        modelAndView.addObject("board",boardDTO);
        return modelAndView;

    }
    @GetMapping("/update/{listId}")
    public String updateBoard(@PathVariable("listId") int listId){
        return "update";
    }
}

package com.grepp.controller;

import com.grepp.model.servicies.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLException;

@Controller

public class MemberController {
    MemberService memberService = MemberService.getInstance();

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("userid") String userId, @RequestParam("userpw") String userPw, Model model,HttpSession session) throws SQLException {
        String id= memberService.login(userId,userPw);
        if(id!=null){
            session.setAttribute("loginId",id);
            return "redirect:/main";//로그인 성공시 메인페이지로 이동
        }
        else {
            return "redirect:/login";// 로그인실패하면 다시 로그인페이지로 이동
        }
//        @PostMapping 메소드의 반환값은 보통 요청이 처리된 후 사용자에게 보여줄 페이지를 결정합니다. 여기서는 사용자가 로그인 폼을 제출한 후,
//        성공적으로 로그인이 되었다면 대시보드나 메인 페이지로 리다이렉트하거나,
//        로그인에 실패했을 경우 다시 로그인 페이지로 리다이렉트하거나 에러 메시지를 포함하여 같은 페이지를 다시 보여줄 수 있습니다.
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes redirectAttributes) {
        session.invalidate();
        redirectAttributes.addFlashAttribute("message", "로그아웃 되었습니다.");
        return "redirect:/main";
    }

}

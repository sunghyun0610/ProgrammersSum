package com.grepp.controller;

import com.grepp.controller.util.MyPageInfo;
import com.grepp.model.servicies.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.sql.SQLException;

//member/~~~.do형태의 요청이 들어오겠다
public class MemberController implements MyController{
    private MemberService service= MemberService.getInstance();

    @Override
    public Object handleRequest(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        String url= req.getServletPath();

        Object result = null;
        if("/member/loginForm.do".equals(url)){
            result= new MyPageInfo(true,"/login_form");
        } else if ("/member/login.do".equals(url)) {
            String userid=req.getParameter("userid");
            String userpw=req.getParameter("userpw");
            String loginId= service.login(userid,userpw);
            if(loginId!=null){
                HttpSession session=req.getSession();
                session.setAttribute("loginId",loginId);
                req.setAttribute("msg","login success!");
                req.setAttribute("path",req.getContextPath()+"/main.do");
                result=new MyPageInfo(true,"/alert");
            }else {//login fail
                req.setAttribute("msg","login fail!");
                req.setAttribute("path", req.getContextPath() + "/member/login_form.do");
                result=new MyPageInfo(true,"/alert");
            }
        } else if ("/member/logout.do".equals(url)) {
            req.getSession().invalidate();//현재 요청보낸 사용자 세션객체 제거

            req.setAttribute("msg","logout success!");
            req.setAttribute("path", req.getContextPath() + "/main.do");
            result=new MyPageInfo(true,"/alert");

        }
        return result;
    }
}

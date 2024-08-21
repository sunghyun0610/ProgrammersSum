package com.grepp.controller;

import com.grepp.controller.util.MyControllerMapping;
import com.grepp.controller.util.MyPageInfo;
import com.mysql.cj.Session;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

//.do에대한 요청이 모두 여기로온다. 이 MainSevlet에서 이제 컨트롤러로 요청을 분배해주는 개념
// board.do, member.do, login.do, ... etc 모두 다 여기로 실행되게
// 그런고로 혹시 다른 서블릿이 있다면 걔들보다 이 서블릿이 더 먼저 생성되게 loadOnStartup=1
// Spring 백엔드 프레임워크 만든 사람들의 생각. 서블릿 단 하나로 다 처리되게 하자. DispatcherServlet!!!!!!!!!!!!!!!!!!!!1
@WebServlet(urlPatterns = "*.do",loadOnStartup = 1)
public class MainServlet extends HttpServlet {
    private MyControllerMapping controllerMapping=new MyControllerMapping();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }
    protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getServletPath();
        System.out.println("request here : " + url);
        //컨트롤러 특정해서 무언가 핵심작업 처리하기 전. 공통작업.
        HttpSession session = req.getSession();
        String loginId=(String) session.getAttribute("loginId");
        if(url.startsWith("/board") && url.endsWith("/list.do")&& loginId==null){
            req.setAttribute("msg", "로그인 정보가 필요합니다.");
            req.setAttribute("path", req.getContextPath()+"/member/loginForm.do");
            req.getRequestDispatcher("/WEB-INF/views/alert.jsp").forward(req,resp);
        }
        try {
            MyController controller = controllerMapping.getController(url);//얘한테 물어보면 컨트롤러 객체중에 하나 줄거임~ BoardController, MemberController, MainController...
            Object controllerResult = null;
            if (controller != null) {//해당 요청을 처리할 컨트롤러 객체가 있음!
                controllerResult = controller.handleRequest(req, resp);
            } else {//해당 요청을 처리할 컨트롤러 못찾았음!
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
            if (controllerResult instanceof MyPageInfo) {//forward or redirect둘중 하나일 때는 여기 ->html화면이 필요한 경우

                MyPageInfo pageInfo = (MyPageInfo) controllerResult;
                if (pageInfo.isForward()) {//html만들라고 jsp한테 forward합시다
                    req.getRequestDispatcher("/WEB-INF/views" + pageInfo.getPath()+".jsp").forward(req, resp);
                } else {//새로운 요청 유도하기
                    resp.sendRedirect(req.getContextPath() + pageInfo.getPath());
                }

            } else {//REST 요청에 대한 data응답. (백에드가 html화면이아니라 날것의 data만 응답하는 경우가 여기) ->이러한 백엔드는 아직 안배움.

            }
        }catch (Exception e){
//            throw new RuntimeException(e);//이러면 톰캣한테 예외 던짐 -> 에러화면이 안예쁨
            e.printStackTrace();//console용
            req.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req,resp);
            return;
        }
    }



}
//스프링하면 MainServlet, Mycontroller interface는 만들어져있다. 그러므로 개발자는 그냥 controller만 만들면 된다.
//모든 요청이 여기로 몰리고 mapping한테 물어본다. -> 야 이거 누가처리해야대? -> Mapping : 아 이건 요놈 주면 됩니다.
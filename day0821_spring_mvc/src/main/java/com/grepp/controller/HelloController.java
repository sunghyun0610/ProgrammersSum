package com.grepp.controller;

import com.grepp.model.ParamDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller//implements MyController랑 같은 의미이다.
//DispatcherServlet 관리 대상 객체가 됨.
public class HelloController {
    @RequestMapping(value = "/hello")//HandlerMapping 기능을 함.
    public String hello(){
//        System.out.println("is here?");
        //여기서 컨트롤러가 하고자 하는 작업을 실행할 거임.
        return "hi";//기본 설정이 forward, 즉 ,야 hi 니가 html만들어 시킴
    }

//    @RequestMapping(value = "/bye", method = RequestMethod.GET)
//    public ModelAndView bye(HttpServletRequest request){
//        System.out.println("param1 : "+ request.getParameter("param1") );
//        System.out.println("param2 : "+ request.getParameter("param2") +100);
//        System.out.println("param2 num : " + (Integer.parseInt(request.getParameter("param2"))+100));
//        return null;
//    }

    //위에 메서드 구분할 필요없이 어노테이션 이름으로 구분
    @GetMapping("/bye")
    public ModelAndView bye(@RequestParam("param1") String p1, @RequestParam("param2") int p2){//HttpServletRequest 객체에서 가져오지않고 param어노테이션으로 인자만 받아오기 가능
        //메서드 내역에서 선언된 지역변수는 자동 초기화가 안된다.
        //but iv, cv는 자동초기화가 된다. (참조형 -> null, int =0, boolean = false)
        System.out.println("param1 : " +p1);
        System.out.println("param2 : "+(p2+100));
        return null;
    }

    //파라미터가 여러개인데 한꺼번에 받아서 처리하고 싶을 때
    //객체의 멤버변수 이름과 클라이언트 파라미터 이름을 일치 시켜야 함.
//    @GetMapping("/bye")
//    public ModelAndView bye(ParamDTO param){//HttpServletRequest 객체에서 가져오지않고 param어노테이션으로 인자만 받아오기 가능
//        System.out.println(param);
//        return null;
//    }
}

package com.grepp.controller;

import com.grepp.model.ParamDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@Controller
@RequestMapping("/forward")//localhost:8080/mvc/forward/~~~이렇게 생긴 애들 일단 다 이클래스로 모여라!!
public class ForwardController {

    @RequestMapping("/mav")
    public ModelAndView mav(){
        ModelAndView mav= new ModelAndView();
        mav.setViewName("view1");//viewResolver를 거쳐서 /WEB-INF/views/mav.jsp라고 뷰 경로가 완성됨.
        mav.addObject("msg","Forward컨트롤러가 뷰에게 전달하는 데이터");
        mav.addObject("now",new Date());
        return mav;
    }


    //return 되는 String을 뷰 이름으로 하고, 전달받은 파라미터 DTO 객체와 추가로 데이터를 더 담은 model의 gugudan들도 모두 뷰에게 전달할 수 있음.
    @RequestMapping("/str")
    public String str(@ModelAttribute("param2") ParamDTO param, Model model){
        model.addAttribute("gugudan",6);
        return "view2";
    }

    @RequestMapping("/redirect")
    public String redirect(@RequestParam("age") int age, RedirectAttributes attr){
        attr.addAttribute("age", age);//이러면 redirect hahaha한테 재요청 보낼 때 이요청도 보낼 수 있음.
        return "redirect:hahaha";//redirect키워드를 넣어놓면 /forward/hahaha 라는 요청을 다시 보내게 됨.
    }

    @RequestMapping("/hahaha")
    public String hahaha(@RequestParam(value = "age",defaultValue = "1") int age){

        System.out.println("hahaha receive age ??: "+age);
        return "view3";
    }




}

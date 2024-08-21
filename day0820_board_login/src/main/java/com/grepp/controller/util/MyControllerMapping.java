package com.grepp.controller.util;

import com.grepp.controller.BoardController;
import com.grepp.controller.MainController;
import com.grepp.controller.MemberController;
import com.grepp.controller.MyController;

public class MyControllerMapping {
    private BoardController boardController = new BoardController();
    private MemberController memberController=new MemberController();
    private MainController mainController= new MainController();

    public MyController getController(String command){
        if(command.startsWith("/member"))
            return memberController;
        else if (command.startsWith("/board")) {
            return boardController;
        }
        else if (command.startsWith("/main"))return mainController;
        else  return null;
    }
}
//Mycontroller라는 표준을 모든 컨트롤러들이 따른다.(인터페이스== 표준 , 규약, 제약)
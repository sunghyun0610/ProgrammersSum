package com.grepp.model.servicies;

import com.grepp.model.respositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class MemberService {
    @Autowired
    private MemberRepository repo;
//    private MemberService(){}
//
//    private static MemberService instance= new MemberService();
//
//    public static MemberService getInstance(){
//        return instance;
//    }

    public String login(String userid, String userpw) throws SQLException {
        return repo.selectOne(userid,userpw);
    }
}

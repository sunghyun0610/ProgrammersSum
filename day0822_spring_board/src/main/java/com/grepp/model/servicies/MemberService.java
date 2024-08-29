package com.grepp.model.servicies;

import com.grepp.model.respositories.MemberRepository;
import com.grepp.model.respositories.MemberRepositoryMysql;

import java.sql.SQLException;

public class MemberService {
    private MemberRepository repo = MemberRepositoryMysql.getInstance();
    private MemberService(){}

    private static MemberService instance= new MemberService();

    public static MemberService getInstance(){
        return instance;
    }

    public String login(String userid, String userpw) throws SQLException {
        return repo.selectOne(userid,userpw);
    }
}

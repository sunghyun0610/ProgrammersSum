package com.grepp.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.SQLException;

public interface MyController {
    public Object handleRequest(HttpServletRequest req, HttpServletResponse resp) throws SQLException;
}

package com.grepp.day0904.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class SHFilter extends OncePerRequestFilter {
    @Autowired//스프링이 관리하는 객체이므로 너도 스프링이 관리하는 객체가 되야대 -> @Component어노테이션 붙이면 해결.
    private MyJwtTokenProvider tokenProvider;
    @Autowired
    private MyJwtTokenProvider myJwtTokenProvider;

    @Override//그래서 이 필터가 무슨 역할을 하는지 여기에 정의
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {
            String token = parseBearerToken(request);
            System.out.println("start sh filter : "+token);
            if(token!=null){
                System.out.println("after login " + token);
                String username= myJwtTokenProvider.validateUserToken(token);
                //token이 유효하면 인증이 완료된거임.
                AbstractAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        username,
                        null,
                        AuthorityUtils.NO_AUTHORITIES // 로그인이 된 상태에서도 관리자, 일반사용자 등의 권한이 달라질 수 있음. 여기서 설정
                );

                //token에다 기본적인 인증정보 외에 더 부가적으로 담아놓고 싶은 내용이 있으면 아래 Detail에서 더 담는 작업 수행 가능.
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContext securityContext= SecurityContextHolder.createEmptyContext();//비어있는 컨텍스트 생성
                securityContext.setAuthentication(authToken);//컨텍스트에 토큰 달고
                SecurityContextHolder.setContext(securityContext);//홀더에 컨텍스트 고정
            }
            filterChain.doFilter(request,response);//때에 따라서는 아래 예외 발생 시에도 나머지 필터를 더 진행해야 할 수 있음.
        }catch (Exception ex){
            //토큰이 유효하지 않아서 인증 불가임! DispatcherServlet으로 안가야 하고 그러므로 ResponseEntity를 리턴하는 작업을 부탁할 수 없음.
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);//response는 기본 설정이 html응답으로 되어 있을거라..

            Map<String,Object> body= new HashMap<>();// front한테 인가야 하고 그러므로 ResponseEntity를 리턴하는 작업을 부탁할 수 없음.
            body.put("status", HttpServletResponse.SC_UNAUTHORIZED);
            body.put("error", "Unauthorized !!!!");
            body.put("message", ex.getMessage());
            body.put("path", request.getServletPath());

            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(response.getOutputStream(), body); // 응답에 에러내용 json으로 만들어 보내기
        }
        filterChain.doFilter(request,response); // 때에 따라서는 아래 예외 발생시에도 나머지 필터를 더 진행해야 할 수 있음.
    }
    //JWT 토큰 화용하는 과정에서 Authorization : header에 + Bearer을 붙여서 사용
    private String parseBearerToken(HttpServletRequest req){
        String bearerToken=req.getHeader("Authorization");
        System.out.println("토큰 발급 됐자나"+bearerToken);

        if(bearerToken != null && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7);
        }
        return null;
    }
}

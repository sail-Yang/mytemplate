package org.example.admin.common.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import jakarta.servlet.*;

import java.io.IOException;

/**
 * @author yangfan
 * @version 1.0
 * @description: 将Filter中抛出的异常传到controller
 * @date 2024/6/23 11:28
 */
@Component
@Slf4j
public class ExceptionFilter implements Filter{

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
            // 异常捕获，发送到error controller
            servletRequest.setAttribute("filter.error", e);
            //将异常分发到/error/exthrow控制器
            servletRequest.getRequestDispatcher("/error/exthrow").forward(servletRequest, servletResponse);
        }
    }
}

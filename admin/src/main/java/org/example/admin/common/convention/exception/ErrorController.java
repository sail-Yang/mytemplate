package org.example.admin.common.convention.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangfan
 * @version 1.0
 * @description: 异常控制器，收集异常并抛出
 * @date 2024/6/23 11:26
 */
@Slf4j
@RestController
public class ErrorController {
    /**
     * 重新抛出异常
     */
    @RequestMapping("/error/exthrow")
    public void rethrow(HttpServletRequest request) throws Exception {
        throw ((Exception) request.getAttribute("filter.error"));
    }
}

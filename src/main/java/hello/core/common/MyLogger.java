package hello.core.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * packageName    : hello.core.common
 * fileName       : MyLogger
 * author         : h.h.w
 * date           : 2024-04-16
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-16        h.h.w       최초 생성
 */
@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {
    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("[" + uuid + "]" + "[" + requestURL + "] : " + message);
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString(); // 절대로 겹치지 않는 uuid
        System.out.println("[" + uuid + "] : request scope bean create, " + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("[" + uuid + "] : request scope bean close, " + this);
    }

}
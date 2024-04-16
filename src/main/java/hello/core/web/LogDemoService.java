package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * packageName    : hello.core.web
 * fileName       : LogDemoService
 * author         : h.h.w
 * date           : 2024-04-16
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-16        h.h.w       최초 생성
 */
@Service
@RequiredArgsConstructor
public class LogDemoService {
    private final MyLogger myLogger;
    public void logic(String id) {
        myLogger.log("service id = " + id);
    }
}

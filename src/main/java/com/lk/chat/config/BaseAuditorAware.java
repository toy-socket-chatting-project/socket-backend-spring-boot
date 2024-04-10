package com.lk.chat.config;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

/**
 *
 *
 * <h3>HelloBaseEntity Auditor 설정</h3>
 *
 * JPA Auditing 에서 아래 어노테이션이 붙은 컬럼에 삽입될 값을 정의한다.
 *
 * <pre>
 * 1. @CreatedBy - session user Id
 * 2. @LastModifiedBy - session user Id
 * </pre>
 */
@RequiredArgsConstructor
@Component
public class BaseAuditorAware implements AuditorAware<String> {

    /**
     * TODO: 로그인 구현 후 아래 세션 객체 사용필요. HttpSession: 인터셉터를 통해 세션 검증 후 들어오기 때문에 리퀘스트부터 검증할 필요는 없음.
     *
     * <p>HttpServletRequest: invalid 세션인 경우 HttpSession 바로 사용 시 예외가 발생하기 때문에 검증이 필요할 수도 있음.
     *
     * <p>위 케이스를 대비하여 두 가지 객체를 주석으로 추가함.
     */
    //    private HttpSession httpSession;
    //    private HttpServletRequest httpServletRequest;

    @Override
    public Optional<String> getCurrentAuditor() {
        final var MOCK_SESSION_USER_ID = "MK_AUDITOR";
        return Optional.of(MOCK_SESSION_USER_ID);
    }
}

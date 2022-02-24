/*package com.perficient.bcproj.user.msg.listener;

import com.perficient.bcproj.user.msg.config.JmsConfig;
import com.perficient.bcproj.user.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class UserListener {
    private final UserService userService;
    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = JmsConfig.VALIDATE_USER_QUEUE)
    public void listen(){}
}
*/
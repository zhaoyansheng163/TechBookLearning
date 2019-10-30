package com.cxytiandi.eureka_client.actuator;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator extends AbstractHealthIndicator {

	@Override
	protected void doHealthCheck(Builder builder) throws Exception {
		builder.up().withDetail("status", true);   //设置服务状态为可用
		//builder.down().withDetail("status", false);  //设置服务状态为不可用
	}

}

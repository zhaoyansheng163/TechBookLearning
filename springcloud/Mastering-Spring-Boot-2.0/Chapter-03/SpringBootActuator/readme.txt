http://127.0.0.1:8080/actuator/info


http://127.0.0.1:8080/actuator/health
如下，可以通过检查某个链接能不能访问，来显示状态是否正常

@Component
public class DineshonjavaHealth implements HealthIndicator{

	@Override
	public Health health() {
		try {
//			RestTemplate rest = new RestTemplate();
//			rest.getForObject("https://www.dineshonjavaa.com", String.class);
			return Health.up().build();
		} catch (Exception e) {
			return Health.down().withDetail("reason", e.getMessage()).build();
		}
	}

}


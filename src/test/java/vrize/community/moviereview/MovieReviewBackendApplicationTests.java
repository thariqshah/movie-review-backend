package vrize.community.moviereview;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Testcontainers
@SpringBootTest
class MovieReviewBackendApplicationTests {

	@Container
	@ServiceConnection
	static PostgreSQLContainer<?> postgresContainer =
			new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"));

	@Test
	void contextLoads() {
	}

	@Test
	void createApplicationModuleModel() {
		ApplicationModules modules = ApplicationModules.of(MovieReviewBackendApplication.class);
		modules.verify();
		modules.forEach(System.out::println);
	}
}

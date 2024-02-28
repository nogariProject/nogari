package nogari.global.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.stereotype.Component;
import springfox.documentation.oas.web.OpenApiTransformationContext;
import springfox.documentation.oas.web.WebMvcOpenApiTransformationFilter;
import springfox.documentation.spi.DocumentationType;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Swagger API에서 Server 셀렉트 박스를 선택해서 검증계 로컬계 운영계를 선택해서 해당 서베에 있는 API를 실행할수 있음.
 *
 */
@Component
public class SwaggerWorkaround implements WebMvcOpenApiTransformationFilter {

    @Override
    public OpenAPI transform(OpenApiTransformationContext<HttpServletRequest> context) {
        OpenAPI openApi = context.getSpecification();
        Server localServer = new Server();
        localServer.setDescription("local");
        localServer.setUrl("http://localhost:8081"); //로컬계 셋팅

        Server testServer = new Server();
        testServer.setDescription("test");
        testServer.setUrl("https://serveraddress"); //검증계 셋팅

        Server realServer = new Server();
        realServer.setDescription("real");
        realServer.setUrl("https://realaddress"); //운영계 셋팅
        openApi.setServers(Arrays.asList(localServer, testServer,realServer));
        return openApi;
    }

    @Override
    public boolean supports(DocumentationType documentationType) {
        return documentationType.equals(DocumentationType.OAS_30);
    }

}//end class

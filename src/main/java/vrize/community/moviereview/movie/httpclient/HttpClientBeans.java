package vrize.community.moviereview.movie.httpclient;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Component
public class HttpClientBeans {

    @Bean
    public MovieDBHttpClient movieDbClient(){
        RestClient restClient = RestClient.builder().baseUrl("https://api.themoviedb.org").build();
        RestClientAdapter adapter = RestClientAdapter.create(restClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
        return factory.createClient(MovieDBHttpClient.class);
    }
}

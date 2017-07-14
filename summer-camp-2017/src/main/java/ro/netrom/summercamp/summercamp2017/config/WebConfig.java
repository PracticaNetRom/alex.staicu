package ro.netrom.summercamp.summercamp2017.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;

import ro.netrom.summercamp.summercamp2017.errorHandler.ErrorManager;
import ro.netrom.summercamp.summercamp2017.service.AnnouncementService;
import ro.netrom.summercamp.summercamp2017.service.CommentService;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "ro.netrom.summercamp.summercamp2017.controller" })
public class WebConfig extends WebMvcConfigurerAdapter {
	@Bean
	public RestTemplate getRestTemplate()
	{
		RestTemplate template = new RestTemplate();
		template.setErrorHandler(new ErrorManager());
		return template;
	}
	@Bean
	public ObjectMapper getObjectMapper()
	{
		return new ObjectMapper();
	}
	
	@Bean
	public HttpHeaders getHttpHeaders()
	{
		return new HttpHeaders();
	}
	@Bean
	public AnnouncementService getAnnouncementService()
	{
		return new AnnouncementService();
	}
	@Bean
	public CommentService getCommentService()
	{
		return new CommentService();
	}

	
	@Override
	public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
		configurer.setDefaultTimeout(60 * 1000);
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/pages/", ".jsp");
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new MappingJackson2HttpMessageConverter());
		converters.add(new MarshallingHttpMessageConverter());
		converters.add(new ResourceHttpMessageConverter());
	}
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
}

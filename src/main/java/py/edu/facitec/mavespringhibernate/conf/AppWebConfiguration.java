package py.edu.facitec.mavespringhibernate.conf;



import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import py.edu.facitec.mavespringhibernate.controller.HomeController;
import py.edu.facitec.mavespringhibernate.dao.ClienteDAO;

import py.edu.facitec.mavespringhibernate.resolver.CustomXMLViewResolver;
import py.edu.facitec.mavespringhibernate.resolver.JsonViewResolver;

@EnableWebMvc

@ComponentScan(basePackageClasses={HomeController.class,ClienteDAO.class})
public class AppWebConfiguration extends WebMvcConfigurerAdapter {
	
	
	  @Bean
	  public InternalResourceViewResolver internalResourceViewResolver(){
	
		InternalResourceViewResolver resolver= new InternalResourceViewResolver();
		
		//resolver.setPrefix("/WEB-INF/views/");
		resolver.setPrefix("/static/");
		resolver.setSuffix(".html");
		
return resolver;	
	}
	  @Bean
	  public FormattingConversionService mvcConversionService() {
	  DefaultFormattingConversionService conversionService =
	  new DefaultFormattingConversionService(true);
	  DateFormatterRegistrar registrar =
	  new DateFormatterRegistrar();
	  registrar.setFormatter(new DateFormatter("yyyy-MM-dd"));
	  registrar.registerFormatters(conversionService);
	  return conversionService;
	  }
	  @Override
	  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	  configurer.enable();
	  }
	  
	  //se usaba con el metodo antiguo
	  @Bean
	  public ViewResolver contentNegotiatingViewResolver(
	  ContentNegotiationManager manager) {
	  List<ViewResolver> resolvers = new ArrayList<ViewResolver>();
	  resolvers.add(internalResourceViewResolver());
	  resolvers.add(new JsonViewResolver());
	  resolvers.add(getMarshallingXmlViewResolver());
	  ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
	  resolver.setViewResolvers(resolvers);
	  resolver.setContentNegotiationManager(manager);
	  return resolver;
	  }
	  @Bean
	  public CustomXMLViewResolver getMarshallingXmlViewResolver() {
	  Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
	 //marshaller.setClassesToBeBound(Producto.class);
	  return new CustomXMLViewResolver(marshaller);
	  }

}

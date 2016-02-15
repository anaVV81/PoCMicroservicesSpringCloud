package es.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import es.examples.filters.pre.SimplePreFilter;
import org.springframework.context.annotation.Bean;
//import com.netflix.zuul.FilterLoader;
//import com.netflix.zuul.FilterFileManager;
//import com.netflix.zuul.groovy.GroovyCompiler;
//import com.netflix.zuul.groovy.GroovyFileFilter;
//import com.netflix.zuul.filters.FilterRegistry;
//import java.io.File;

@EnableZuulProxy
@SpringBootApplication
public class GatewayApplication {

  /*  private void initGroovyFilterManager() {
        FilterLoader.getInstance().setCompiler(new GroovyCompiler());

        //String scriptRoot = System.getProperty("zuul.filter.root", "");
        String scriptRoot = "/apps/simpleWebappFilters/groovy/filters";
        if (scriptRoot.length() > 0) scriptRoot = scriptRoot + File.separator;
        try {
            FilterFileManager.setFilenameFilter(new GroovyFileFilter());
            FilterFileManager.init(5, scriptRoot + "pre", scriptRoot + "route", scriptRoot + "post");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }*/

  public static void main(String[] args) {
    SpringApplication.run(GatewayApplication.class, args);
  }
  @Bean
  public SimplePreFilter simplePreFilter() {
    //initGroovyFilterManager();
    return new SimplePreFilter();
  }

}

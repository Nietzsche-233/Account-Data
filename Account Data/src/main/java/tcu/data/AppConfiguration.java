package tcu.data;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.relational.core.mapping.event.BeforeSaveEvent;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import tcu.data.Main.Account;

import java.util.UUID;

@Configuration
public class AppConfiguration implements WebMvcConfigurer {
   @Bean
    public ApplicationListener<BeforeSaveEvent<?>> idGenerator(){
       return event ->{
           Object entity = event.getEntity();
           if(entity instanceof Account){
               if(((Account)entity).getId() == null){
               ((Account)entity).setId(UUID.randomUUID().toString());
               ((Account)entity).setEditable(false);
               }
           }
       };
   }
}

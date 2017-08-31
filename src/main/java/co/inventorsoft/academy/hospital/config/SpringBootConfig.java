package co.inventorsoft.academy.hospital.config;

import co.inventorsoft.academy.hospital.doa.DataBaseManager;
import co.inventorsoft.academy.hospital.doa.DataManager;
import co.inventorsoft.academy.hospital.doa.FileManager;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
public class SpringBootConfig {
    @Bean
    public DataManager dataManager(){
        return new DataBaseManager();//FileManager();
    }
}

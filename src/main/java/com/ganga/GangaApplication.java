package com.ganga;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ganga.configs.AppConstants;
import com.ganga.entities.Role;
import com.ganga.entities.User;
import com.ganga.repositories.RoleRepository;
import com.ganga.repositories.UserRepository;



@SpringBootApplication
public class GangaApplication implements CommandLineRunner {
	
	@Autowired
	public PasswordEncoder passwordEncoder;
	
	@Autowired
	public RoleRepository roleRepository;
	
	@Autowired
	public UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(GangaApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelmapper() {
		ModelMapper modelMapper=new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(this.passwordEncoder.encode("hello"));
		
		Role normal=new Role();
		Role admin=new Role();
		
		normal.setRoleId(AppConstants.NORMAL_ROLE_ID);
		normal.setRoleName("ROLE_USER");
		
		admin.setRoleId(AppConstants.ADMIN_ROLE_ID);
		admin.setRoleName("ROLE_ADMIN");
		
		List<Role> roles = List.of(normal,admin);
		
		List<Role> result = this.roleRepository.saveAll(roles);
		
		//creating an admin 
		
		User user=new User();
		
		user.setUserId(1);
		user.setUserFullName("Admin");
		user.setUserEmail("admin@mindsprint.org");
		user.setUserPassword(this.passwordEncoder.encode("admin@123"));
		user.getUserRoles().add(admin);
		
		this.userRepository.save(user);
		
		System.out.println("The different roles are: ");
		
		result.forEach(role->System.out.println(role.getRoleName()));
	}
	
	
	@Bean
    public WebMvcConfigurer corsConfigurer()
    {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:3000").allowedHeaders("*").allowCredentials(true);
            }
        };
    }
	
	

}

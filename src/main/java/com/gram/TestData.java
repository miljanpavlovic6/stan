package com.gram;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gram.model.Soba;
import com.gram.model.Stavka;
import com.gram.model.User;
import com.gram.service.SobaService;
import com.gram.service.StavkaService;
import com.gram.service.UserService;

@Component
public class TestData {

	@Autowired
	private UserService userService;
	@Autowired
	private StavkaService stavkaService;
	@Autowired
	private SobaService sobaService;
	
	
	
	@PostConstruct
	public void init() {
		
	User u1 = new User();
	u1.setUserName("admin");
	u1.setPassword("admin");
	u1.setActive(true);
	u1.setRoles("ROLE_ADMIN");
	u1.setNameFirst("Miljan");
	u1.setNameLast("Pavlovic");
	u1.setPhone("006006006");
	u1.setPicture("https://media-exp1.licdn.com/dms/image/C4D03AQHmHxSd_0Wsrg/profile-displayphoto-shrink_200_200/0?e=1588809600&v=beta&t=VyNp-DjI_RoP58nPEsiRWeORXwYp9XihTNO5U6YY8CM");
	userService.save(u1);
	
	User u2 = new User();
	u2.setUserName("user");
	u2.setPassword("user");
	u2.setActive(true);
	u2.setRoles("ROLE_ADMIN");
	u2.setNameFirst("Jelena");
	u2.setNameLast("Popovic");
	u2.setPhone("111222");
	u2.setPicture("https://media-exp1.licdn.com/dms/image/C4D03AQFAirmEJu-kiQ/profile-displayphoto-shrink_200_200/0?e=1588809600&v=beta&t=a7F_Kj-V1B7uATrmbMikZZz9XpKvhFr6IKaXIh0uksQ");
	userService.save(u2);
	
	User u3 = new User();
	u3.setUserName("user1");
	u3.setPassword("user1");
	u3.setActive(true);
	u3.setRoles("ROLE_ADMIN");
	u3.setNameFirst("Marko");
	u3.setNameLast("Pavlovic");
	u3.setPhone("0000000");
	u3.setPicture("http://www.clker.com/cliparts/d/L/P/X/z/i/no-image-icon-md.png");
	userService.save(u3);
	

	
	Soba soba1 = new Soba();
	soba1.setName("Dnevna soba");
	sobaService.save(soba1);
	
	Soba soba2 = new Soba();
	soba2.setName("Kuhinja");
	sobaService.save(soba2);
	
	Soba soba3 = new Soba();
	soba3.setName("Terasa");
	sobaService.save(soba3);
	
	
	Stavka s1 = new Stavka();
	s1.setName("Televizor");
	s1.setOpis("49 inca");
	s1.setPicture("https://www.gigatron.rs/img/products/medium/image5b0fb40f00871.png");
	s1.setCena("50000");
	s1.setSoba(soba1);
	stavkaService.save(s1);
	
	Stavka s2 = new Stavka();
	s2.setName("Lampa");
	s2.setOpis("Alien lampa");
	s2.setPicture("https://makelelektro.rs/slike/stona-lampa-hn-2041-mt-1-crna-brilight.jpg");
	s2.setCena("2354");
	s2.setSoba(soba1);
	stavkaService.save(s2);
	
	Stavka s3 = new Stavka();
	s3.setName("Aspirator Bosch");
	s3.setOpis("Tunelni aspiratora");
	s3.setPicture("https://static.tehnomanija.rs/UserFiles/products/131474.jpg");
	s3.setCena("32520");
	s3.setSoba(soba2);
	stavkaService.save(s3);
	
	Stavka s4 = new Stavka();
	s4.setName("Sto");
	s4.setOpis("Drveni sto za terasu");
	s4.setPicture("https://media.mojtrg.rs/Image/fbb2ec18cf334f3e8784a0cc0b7b334a/20140414/false/false/640/480/Etno-bastenski-komplet-od-bagrema.jpeg");
	s4.setCena("1050");
	s4.setSoba(soba3);
	stavkaService.save(s4);
	
	Stavka s5 = new Stavka();
	s5.setName("Luster");
	s5.setOpis("Beli luster");
	s5.setPicture("https://www.homeart.rs/uploads/store/products/images/beli_luster__475x525_820.jpg");
	s5.setCena("3000");
	s5.setSoba(soba1);
	stavkaService.save(s5);
	
	Stavka s6 = new Stavka();
	s6.setName("Ugaona garnitura");
	s6.setOpis("Simpo kauc");
	s6.setPicture("https://casagrande.rs/wp-content/uploads/2018/07/Ugaona-garnitura-Romana.jpg");
	s6.setCena("49900");
	s6.setSoba(soba1);
	stavkaService.save(s6);
	
	Stavka s7 = new Stavka();
	s7.setName("Frizider side by side");
	s7.setOpis("Bosch fizider");
	s7.setPicture("https://cdn.emmezeta.rs/media/catalog/product/cache/f8d50d031afca71e390f3523d0693009/6/0/605247-lg-gsl760pzxv-side-by-side-hladnjak_1.jpg");
	s7.setCena("150000");
	s7.setSoba(soba2);
	stavkaService.save(s7);
	
	Stavka s8 = new Stavka();
	s8.setName("Klupa");
	s8.setOpis("Klupa sa sedenje");
	s8.setPicture("https://media.xxxlutz.com/i/xxxlutz/PI2sec91mWANlbHIBbvGJFQw/?fmt=webp&w=768&h=0&qlt=85&upscale=false");
	s8.setCena("27499");
	s8.setSoba(soba3);
	stavkaService.save(s8);
	
	
	
	
	
	
	}
	
}

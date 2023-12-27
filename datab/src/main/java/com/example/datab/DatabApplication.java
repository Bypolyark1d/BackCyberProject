package com.example.datab;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.datab.repository.CategoryRepository;
import com.example.datab.repository.UserRepository;

@SpringBootApplication
public class DatabApplication implements CommandLineRunner
{
	@Autowired
	UserRepository userRepository;
	@Autowired
	CategoryRepository categoryRepository;
	public static void main(String[] args) {
		SpringApplication.run(DatabApplication.class, args);
	}
	
	
	@Override
	public void run(String...args)
	{
		
		//User userOne = new User("Qwerty","123");
		//userRepository.save(userOne);
		//Category category = new Category();
		//category.setName("MousePad");
		//List<Product> listproduct = new ArrayList();
		//listproduct.add(new Product("Virtus.pro Control Edition (XL)",1499,100,"Коврик Virtus.pro Control Edition (XL) – стильный игровой аксессуар с ярким оранжевым логотипом на черном фоне. Резиновая подложка не дает покрытию скользить даже при резких движениях. Благодаря прошитым краям вы будете уверены, что коврик прослужит не один год.",category,"D:\\images\\VP_control_edition_xl.jpg"));
		//listproduct.add(new Product("ARDOR GAMING GM-XL Katana Red (XL)",1199,101,"Коврик ARDOR GAMING GM-XL Katana Red – качественный аксессуар для компьютерной мыши, обеспечивающий точное позиционирование ее курсора на экране и легкое перемещение. Модель имеет тканевое покрытие, текстура которого отлично подходит как для лазерных, так и для оптических манипуляторов. Прорезиненное основание коврика ARDOR GAMING GM-XL Katana Red способствует его неподвижности на компьютерном столе, в результате чего он не будет перемещаться вслед за движениями мыши.",category,"D:\\images\\ARDOR_Gaming_Gm_XL.jpg"));
		//listproduct.add(new Product("MSI AGILITY GD70 DRAGON TIAMAT",2499,50,"Коврик MSI AGILITY GD70 DRAGON TIAMAT с ярким дизайном отлично подходит для дома и офиса. Огромные размеры 90x40 см позволяют свободно двигать контроллер при работе с текстами, таблицами и графическими приложениями. Резиновая основа не скользит даже на стеклянной столешнице.",category,"D:\\images\\MSI_Agility_Gd70.jpg"));
		//category.setListProduct(listproduct);
		//categoryRepository.save(category);
		//Category category  = categoryRepository.findById(52).get();
		//Product a = new Product("Dark Project KD87A Gateron Teal Cap",7999,203,"Клавиатура проводная Dark Project KD87A Gateron Teal Cap [DP-KD-87A-004100-GTC] сочетает в себе мощную «начинку» и невероятно стильное исполнение, включающее подсветку клавиш. Переключатели Gateron Cap Teal гарантируют не только непревзойденную точность ввода и мгновенный отклик на касания пользователя, но и поражают длительным периодом эксплуатации, рассчитанным на несколько миллионов нажатий.",category,"D:\\images\\darkProject_GateronTeal.jpg");
		//category.getListProduct().add(a);
		//categoryRepository.save(category);
	}
}

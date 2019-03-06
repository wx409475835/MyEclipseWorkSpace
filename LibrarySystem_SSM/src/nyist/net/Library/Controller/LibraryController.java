package nyist.net.Library.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LibraryController {

	@RequestMapping("AlterBookInformation")
	public String ToAlterBookInformation(){
		return "AlterBookInformation";
	}
	@RequestMapping("Alterpassword")
	public String ToAlterpassword(){
		return "Alterpassword";
	}
	
	@RequestMapping("downbook")
	public String Todownbook(){
		return "downbook";
	}
	
	@RequestMapping("Login")
	public String ToLogin(){
		return "Login";
	}
	
	@RequestMapping("Main_u")
	public String ToMain_u(){
		return "Main_u";
	}
	
	@RequestMapping("Main")
	public String ToMain(){
		return "Main";
	}
	
	@RequestMapping("Mine_Alter")
	public String ToMine_Alter(){
		return "Mine_Alter";
	}
	
	@RequestMapping("Mine")
	public String ToMine(){
		return "Mine";
	}
	
	@RequestMapping("MyBrrowInformation")
	public String ToMyBrrowInformation(){
		return "MyBrrowInformation";
	}
	
	@RequestMapping("QY")
	public String ToQY(){
		return "QY";
	}
	
	@RequestMapping("Register_Personlogin")
	public String ToRegister_Personlogin(){
		return "Register_Personlogin";
	}
	
	@RequestMapping("Register")
	public String ToRegister(){
		return "Register";
	}
	
	@RequestMapping("ReturnBooks")
	public String ToReturnBooks(){
		return "ReturnBooks";
	}
	
	@RequestMapping("SelectBooks")
	public String ToSelectBooks(){
		return "SelectBooks";
	}
	
	@RequestMapping("SelectBooksAsType")
	public String ToSelectBooksAdType(){
		return "SelectBooksAsType";
	}
	
	@RequestMapping("updatebooks")
	public String Toupdatebooks(){
		return "updatebooks";
	}
	
	@RequestMapping("SelectAllBrrowInformations")
	public String ToSelectAllBrrowInformations(){
		return "SelectAllBrrowInformations";
	}
	@RequestMapping("SelectAllUser")
	public String ToSelectAllUser(){
		return "SelectAllUser";
	}
	@RequestMapping("SelectUserById")
	public String ToSelectUserById(){
		return "SelectUserById";
	}
	@RequestMapping("updateUser")
	public String ToupdateUser(){
		return "updateUser";
	}
}

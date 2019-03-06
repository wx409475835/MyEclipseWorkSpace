package com.nyist.Hospital.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.nyist.Hospital.Model.hospital_doctor;
import com.nyist.Hospital.Model.hospital_doctor_authority;
import com.nyist.Hospital.Model.hospital_inform;
import com.nyist.Hospital.Model.hospital_login;
import com.nyist.Hospital.Model.hospital_treatemoney;
import com.nyist.Hospital.Pagination.PageBean;
import com.nyist.Hospital.Pagination.QueryInfo;
import com.nyist.Hospital.Service.AdministratorService;
import com.nyist.Hospital.Service.DoctorService;
import com.nyist.Hospital.Utils.WebUtil;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	private AdministratorService administratorService;
	@Autowired
	private DoctorService doctorService;

	@RequestMapping("DoctorMineInformations")
	public String DoctorMineInformations(){
		return "Doctor/DoctorMineInformations";
	}
	
	@RequestMapping("DoctorMainIndex")
	public String DoctorMainIndex(){
		return "Doctor/DoctorMainIndex";
	}
	
	@RequestMapping("DoctorMainTop")
	public String DoctorMainTop(){
		return "Doctor/DoctorMainTop";
	}
	
	@RequestMapping("DoctorMain")
	public String DoctorMain(){
		return "Doctor/DoctorMain";
	}
	
	@RequestMapping("SelectAllInforms")
	public String SelectAllInforms(){
		return "Doctor/SelectAllInforms";
	}
	
	@RequestMapping("DoctorLogin")
	public String DoctorLogin(){
		return "Doctor/DoctorLogin";
	}
	
	@RequestMapping("UpdateDoctorAccountPassword")
	public String UpdateDoctorAccountPassword(){
		return "Doctor/UpdateDoctorAccountPassword";
	}
	
	@RequestMapping("Main")
	public String Main(){
		return "Doctor/Main";
	}
	
	@RequestMapping("RegisterDoctorAccount")
	public String RegisterDoctorAccount(){
		return "Doctor/RegisterDoctorAccount";
	}
	
	@RequestMapping("ShowAllTreateMoney")
	public String ShowAllTreateMoney(){
		return "Doctor/ShowAllTreateMoney";
	}
	/*==================================================================================================================*/
	//判断医生用户名是否存在
	@RequestMapping("JudgeDoctorNameAction")
	public void JudgeDoctorName(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//拿到医生姓名
		String hd_name = request.getParameter("hd_name");
		String hd_id = doctorService.JudgeDoctorName(hd_name);
		System.out.println("hd_id:"+hd_id);
		System.out.println(hd_id==null);
		if(hd_id!=null){
			out.print("姓名已经存在");
		}else{
			out.print("姓名合法");
		}
	}
	
	//判断病人姓名是否合法
	@RequestMapping("JudgePatientNameAction")
	public void JudgePatientName(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//拿到医生姓名
		String hp_name = request.getParameter("hp_name");
		String hp_id = doctorService.JudgePatientName(hp_name);
		System.out.println("hp_id:"+hp_id);
		System.out.println(hp_id==null);
		if(hp_id!=null){
			out.print("姓名已经存在");
		}else{
			out.print("姓名合法");
		}
	}
	
	//判断账户是否存在
	@RequestMapping("AdministratorLoginJudgeByAccountAction")
	public void AdministratorLoginJudgeByAccount(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		/**
		 * 1.首先获得帐户名
		 */
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//构建输入流
		PrintWriter out = response.getWriter();
		String account = request.getParameter("account");
		System.out.println("ha_username:"+account);
		//2.调用Dao--->service 进行业务逻辑处理
		List<String> ac = doctorService.SelectAccount(account);	//通过姓名获得hospital_administrator 表中的ha_id 即管理员id
		System.out.println("ha_id:"+ac);
		//如果查询数据库  返回的是null  说明没有查询到该用户名的存在
		if(ac == null ||ac.isEmpty()){
			out.print("帐户名已存在");
		}else{
			out.print("账户名合法");
		}
		//关闭输出流
		out.flush();
		//return "Administrator/AdministratorLogin";
	}
	
	//医生用户登陆
	@RequestMapping("DoctorLoginAction")
	public void DoctorLogin(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException, ServletException{
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//拿到前台传来的数据
		String hl_username = request.getParameter("username");					//获得用户名
		String hl_password = request.getParameter("password");					//获得密码
		String hl_doctorid = doctorService.DoctorLogin(hl_username,hl_password);
		System.out.println("hl_doctorid:"+hl_doctorid);
		/*if(hl_doctorid ==0 ||hl_doctorid <0){
			out.print("<script type='text/javascript'>");
			out.print("alert('用户名或密码错误，请核对后冲洗输入!');");
			out.print("window.location.href='/AdministratorLogin.do'");
			out.print("</script>");
			out.print("用户名错误或密码错误，请核对后重新输入！");
		}*/
		if(hl_doctorid!=null){
			session.setAttribute("Login",hl_doctorid);					//如果登陆成功,将登陆成功的标志存到session作用域中
			session.setAttribute("LoginName",hl_username);
			session.setAttribute("Account",null);
			request.getRequestDispatcher("/doctor/DoctorMain.do").forward(request, response);
		}else{
			session.setAttribute("Login",null);		//如果登陆失败,将null 空值存到session作用域中  打回登陆页面
			String path = request.getContextPath();
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
			out.print("<script type='text/javascript'>");
			out.print("alert('用户名或密码错误,请核对后重新输入!');");
			out.print("window.location.href='"+basePath+"AdministratorLogin.do'");
			out.print("</script>");
			//response.sendRedirect("/AdministratorLogin.do");
		}
	}
	
	//更新操作查询医生用户信息
	@RequestMapping("DoctorMineInformationsAction")
	public void DoctorMineInformations(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ServletException, IOException{
		//首先要获得医生ID  hd_id
		String id =(String)session.getAttribute("Login");
		int hd_id =Integer.parseInt(id);
		List<hospital_doctor> hdoDoctor = administratorService.SelectDoctorAccounts(hd_id);
		session.setAttribute("UpdateDcotorAccountSelectDoctorById_hDoctor",hdoDoctor);
		System.out.println("HDoctor:"+hdoDoctor);
		request.getRequestDispatcher("/doctor/DoctorMineInformations.do").forward(request, response);
	}

	@RequestMapping("SelectHl_usernameByHl_doctoridAction")
	public void SelectHl_usernameByHl_doctorid(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ServletException, IOException{
		//拿到医生ID  
		String id = (String)session.getAttribute("Login");
		int hl_doctorid = Integer.parseInt(id);
		String hl_username = doctorService.SelectHl_usernameByHl_doctorid(hl_doctorid);
		session.setAttribute("hl_username",hl_username);
		request.getRequestDispatcher("/doctor/UpdateDoctorAccountPassword.do").forward(request, response);
	}
	
	@RequestMapping("UpdateDoctorAccountPasswordAction")
	public void UpdateDoctorAccountPassword(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ServletException, IOException{
		//首先获得医生用户 ID  然后拿到Id 在 查询数据库  获得 用户名
		String hl_username = request.getParameter("username");
		String hl_password = request.getParameter("password");
		String id = (String)session.getAttribute("Login");
		int hl_doctorid = Integer.parseInt(id);
		hospital_login hLogin = new hospital_login();
		hLogin.setHl_doctorid(hl_doctorid);
		hLogin.setHl_username(hl_username);
		hLogin.setHl_password(hl_password);
		doctorService.UpdateDoctorAccountPassword(hLogin);
		
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		System.out.println("basePath:"+basePath);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<script type='text/javascript'>");
		out.print("alert('修改登陆信息成功!');");
		out.print("top.location.href='"+basePath+"doctor/DoctorMain.do'");
		out.print("</script>");
	}
	
	//通过病人ID  查询 结算记录信息
	@RequestMapping("SelectTreateMoneyByHtm_patientidAction")
	public void SelectTreateMoneyByHtm_patientid(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//拿到前台穿过来的病人ID 
		String id = request.getParameter("patientid");
		int htm_patientid = Integer.parseInt(id);
		//查询数据库  看数据库中是否有该病人的结算信息
		hospital_treatemoney hTreatemoney = doctorService.SelectTreateMoneyByHtm_patientid(htm_patientid);
		System.out.println("hTreatemoney:"+hTreatemoney);
		boolean bol ;
		if(hTreatemoney==null||hTreatemoney.equals("[]")){
			bol = true;
		}else {
			bol = false;
		}
		Gson gon = new Gson();
		String jsonString = gon.toJson(bol);
		out.print(jsonString);
	}
	
	//注册医生用户
	@RequestMapping("AddDoctorAccountAction")
	public void AddDoctorAccount(HttpSession session,HttpServletRequest request,HttpServletResponse response,ModelAndView modelAndView) throws ServletException, IOException{
		//1.获得前端页面传来的数据
		System.out.println("================================");
		String hd_name = request.getParameter("hd_name");					//医生姓名
		String age = request.getParameter("hd_age");						//医生年龄
		int hd_age = Integer.parseInt(age);
		String hd_sex = request.getParameter("hd_sex");						//医生性别
		String hd_speciality = request.getParameter("hd_speciality");		//医生特长
		String hd_pt = request.getParameter("hd_pt");						//医生职称
		String hd_ri = request.getParameter("hd_ri");						//医生预约信息
		String hd_haotoid = request.getParameter("hd_haotoid");			    //医生科室
		String hd_mobile = request.getParameter("hd_mobile");				    //医生电话
		System.out.println("hd_name:"+hd_name);
		System.out.println("hd_age:"+hd_age);
		System.out.println("hd_sex:"+hd_sex);
		System.out.println("hd_speciality:"+hd_speciality);
		System.out.println("hd_pt:"+hd_pt);
		System.out.println("hd_ri:"+hd_ri);
		System.out.println("hd_haotoid:"+hd_haotoid);
		System.out.println("hd_mobile:"+hd_mobile);
		hospital_doctor hospital_doctor = new hospital_doctor();
		hospital_doctor.setHd_name(hd_name);
		hospital_doctor.setHd_age(hd_age);
		hospital_doctor.setHd_sex(hd_sex);
		hospital_doctor.setHd_speciality(hd_speciality);
		hospital_doctor.setHd_pt(hd_pt);
		hospital_doctor.setHd_ri(hd_ri);
		hospital_doctor.setHd_haotoid(hd_haotoid);
		hospital_doctor.setHd_mobile(hd_mobile);
		//Service-->Dao 进行操作数据库
		int i=administratorService.AddDoctorAccount(hospital_doctor);		//将前台传过来的数据进行封装   将数据插入到Hospital_doctority
		hospital_doctor_authority hospital_doctor_authority = new hospital_doctor_authority();
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		int hda_id = administratorService.SelectDoctorIdByDoctorNameInHDoctor(hd_name);
		System.out.println("had_id:"+hda_id);
		hospital_doctor_authority.setHda_id(hda_id);
		String hda_aid =(String)session.getAttribute("Login");				//从session作用域中将 id取出来
		if(hda_aid == null){
			hda_aid="1";
		}
		System.out.println("hda_aid:"+hda_aid);
		int aid = Integer.parseInt(hda_aid);								//将String 的 管理员id 转换成 int 类型的id
		hospital_doctor_authority.setHda_aid(aid);
		String hau_id = administratorService.SelectIdByNameInHAuthority(hd_pt);		//将  前台传过来得医生权限数据 通过特定得函数对数据库进行操作
		System.out.println("hau_id:"+hau_id);
		int hauthorityid ;
		if(hau_id != null){
			//拿到权限表中得 Id  转换成int 类型
			hauthorityid = Integer.parseInt(hau_id);
			hospital_doctor_authority.setHda_authorityid(hauthorityid);
		}
		//插图到医生与权限对应表
		administratorService.InsetToHDoctorAuthority(hospital_doctor_authority);
		System.out.println("AddDoctorAccount-i:"+i);	
		
		//将医生用户 注册  登陆用户信息  保存到 hospital_login 表
		hospital_login hLogin =new hospital_login();			//首先生成登陆用户对象
		hLogin.setHl_username(hd_name);							//将医生姓名作为用户名
		hLogin.setHl_password("123456");						//初始化密码都为 123456
		hLogin.setHl_doctorid(hda_id);							// 在这里不在插入权限编号   直接插入医生ID
		doctorService.InsertDoctorLoginInfo(hLogin);			//将医生用户信息 注册 登陆账号
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		System.out.println("basePath:"+basePath);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<script type='text/javascript'>");
		out.print("alert('注册用户成功!用户名为您的姓名,统一初始密码123456!登陆后请先修改您的密码,妥善保管好您的用户信息!');");
		out.print("window.location.href='"+basePath+"AdministratorLogin.do'");
		out.print("</script>");
		/*out.print("alert('注册用户成功!\n用户名为您的姓名,统一初始密码123456!\n登陆后请先修改您的密码,妥善保管好您的用户信息!')");
		out.print("</script>");
		request.getRequestDispatcher(basePath+"Administrator.do").forward(request, response);*/
	}
	
	//查询所有的通知信息
	@RequestMapping("SelectAllInformsAction")
	public void SelectAllInforms(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ServletException, IOException{
		//List<hospital_inform> hInforms = doctorService.SelectAllInforms();
		QueryInfo queryInfo = WebUtil.request2Bean(request, QueryInfo.class);								//将request请求封装到QueryInfo对象中去
		PageBean pageBean = doctorService.pageQueryHospital_doctor_inform(queryInfo);
		System.out.println("处理分页请求-PageBean:"+pageBean.toString());
		session.setAttribute("SelectAllInforms_hInforms",pageBean);
		/*request.getRequestDispatcher("/doctor/SelectAllInforms.do").forward(request, response);*/
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		System.out.println("basePath:"+basePath);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<script type='text/javascript'>");
		out.print("self.location='"+basePath+"doctor/SelectAllInforms.do'");
		out.print("</script>");
	}
		
	
	//清空所有通知
	@RequestMapping("DeleteAllInformsAction")
	public void DeleteAllInforms(HttpSession session,HttpServletRequest request,HttpServletResponse response,ModelAndView modelAndView) throws IOException{
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		System.out.println("basePath:"+basePath);
		doctorService.DeleteAllInforms();
		out.print("<script type='text/javascript'>");
		out.print("alert('清空所有通知信息成功!');");
		out.print("self.location='"+basePath+"doctor/SelectAllInformsAction.do'");
		out.print("</script>");
	}
	
	//医生用户退出登陆
	@RequestMapping("DoctorLoginOut")
	public void DoctorLoginOut(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		session.removeAttribute("Login");
		session.removeAttribute("LoginName");
		session.removeAttribute("SelectAllDoctorAccountAction_hDoctor");
		session.removeAttribute("UpdateDcotorAccountSelectDoctorById_hDoctor");
		session.removeAttribute("SelectAllHaoto_hAoto");
		session.removeAttribute("SelectHaotoById_hAoto");
		session.removeAttribute("AddPatient_hp_id");
		session.removeAttribute("AddPatient_hp_name");
		session.removeAttribute("AddPatient_hp_doctorid");
		session.removeAttribute("AddPatient_hp_tsd");
		session.removeAttribute("AddPatient_hp_tath");
		session.removeAttribute("SelectAllPatients_hPatients");
		session.removeAttribute("SelectPatientById_hPatient");
		session.removeAttribute("DeletePatientByIdAction_hp_id");
		session.removeAttribute("SelectAllHPatientsEmr_hEmrs");
		session.removeAttribute("SelectHPatientEmrByHemr_Ids_hemr_id");
		session.removeAttribute("SelectHPatientEmrByHemr_Ids_hEmr");
		session.removeAttribute("SelectAllInforms_hInforms");
		session.removeAttribute("SelectInformByHi_ids_hInform");
		session.removeAttribute("SelectAllDrugs_hDrugs");
		session.removeAttribute("SelectHDrugByHdrug_ids_hDrug");
		session.removeAttribute("SelectAllTreateRecords_SelectAllTreateRecords");
		session.removeAttribute("SelectTreateRecordByHtr_id_hTreaterecord");
		session.removeAttribute("TreatMoneyEnd_hpt_patientid");
		session.removeAttribute("TreatMoneyEnd_sum");
		session.removeAttribute("SelectTreateMoney_treatemoneys");
		session.removeAttribute("hl_username");
		session.removeAttribute("SelectAllInforms_hInforms");
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		System.out.println("base:"+basePath);
		out.print("<script>");
		out.print("window.parent.location.href='"+basePath+"AdministratorLogin.do'");
		out.print("</script>");
	}
}

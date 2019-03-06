package com.nyist.Hospital.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.interfaces.DSAKey;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.nyist.Hospital.Model.hospital_administrator;
import com.nyist.Hospital.Model.hospital_aoto;
import com.nyist.Hospital.Model.hospital_doctor;
import com.nyist.Hospital.Model.hospital_doctor_authority;
import com.nyist.Hospital.Model.hospital_drug;
import com.nyist.Hospital.Model.hospital_emr;
import com.nyist.Hospital.Model.hospital_inform;
import com.nyist.Hospital.Model.hospital_login;
import com.nyist.Hospital.Model.hospital_patient;
import com.nyist.Hospital.Model.hospital_patientusedrug;
import com.nyist.Hospital.Model.hospital_treatemoney;
import com.nyist.Hospital.Model.hospital_treaterecord;
import com.nyist.Hospital.Pagination.PageBean;
import com.nyist.Hospital.Pagination.QueryInfo;
import com.nyist.Hospital.Service.AdministratorService;
import com.nyist.Hospital.Service.DoctorService;
import com.nyist.Hospital.Utils.WebUtil;

@Controller
public class AdministratorController {
	
	@Autowired
	private AdministratorService administratorService;
	@Autowired
	private DoctorService doctorService;
	
	@RequestMapping("/AdministratorLogin")
	public String AdministratorLogin(){		
		return "Administrator/AdministratorLogin";
	}
	
	@RequestMapping("AdministratorMain")
	public String AdministratorMain(){
		return "Administrator/AdministratorMain";
	}
	
	@RequestMapping("AdministratorMainTop")
	public String AdministratorMainTop(){
		return "Administrator/AdministratorMainTop";
	}
	
	@RequestMapping("AdministratorMainIndex")
	public String AdministratorIndex(){
		return "Administrator/AdministratorMainIndex";
	}
	
	@RequestMapping("AddDoctorAccount")
	public String AddDoctorAccount(){
		return "Administrator/AddDoctorAccount";
	}
	
	@RequestMapping("AlterDoctorAccountAuthority")
	public String AlterDoctorAccountAuthority(){
		return "Administrator/AlterDoctorAccountAuthority";
	}
	
	@RequestMapping("AdministratorShowAllDoctorAccount")
	public String AdministratorShowAllDoctorAccount(){
		return "Administrator/AdministratorShowAllDoctorAccount";
	}
	
	@RequestMapping("UpdateDoctorAccount")
	public String UpdateDoctorAccount(){
		return "Administrator/UpdateDoctorAccount";
	}
	
	@RequestMapping("AddHaoto")
	public String AddHaoto(){
		return "Administrator/AddHaoto";
	}
	
	@RequestMapping("SelectAllHaoto")
	public String SelectAllHaoto(){
		return "Administrator/SelectAllHaoto";
	}
	
	@RequestMapping("AlterHaoto")
	public String AlterHaoto(){
		return "Administrator/AlterHaoto";
	}
	
	@RequestMapping("DataManagement")
	public String DataManagement(){
		return "Administrator/DataManagement";
	}
	
	@RequestMapping("AddPatient")
	public String AddPatient(){
		return "Administrator/AddPatient";
	}
	
	@RequestMapping("AddPatientEmr")
	public String AddPatientEmr(){
		return "Administrator/AddPatientEmr";
	}
	
	@RequestMapping("ShowAllPatients")
	public String ShowAllPatients(){
		return "Administrator/ShowAllPatients";
	}
	
	@RequestMapping("UpdatePatients")
	public String UpdatePatients(){
		return "Administrator/UpdatePatients";
	}
	
	@RequestMapping("ShowAllHPatientsEmr")
	public String ShowAllHPatientsEmr(){
		return "Administrator/ShowAllHPatientsEmr";
	}
	
	@RequestMapping("UpdateHPatientEmr")
	public String UpdateHPatientEmr(){
		return "Administrator/UpdateHPatientEmr";
	}
	
	@RequestMapping("AddInform")
	public String AddInform(){
		return "Administrator/AddInform";
	}
	
	@RequestMapping("ShowAllInforms")
	public String ShowAllInforms(){
		return "Administrator/ShowAllInforms";
	}
	
	@RequestMapping("UpdateInforms")
	public String UpdateInforms(){
		return "Administrator/UpdateInforms";
	}
	
	@RequestMapping("AddDrugs")
	public String AddDrugs(){
		return "Administrator/AddDrugs";
	}
	
	@RequestMapping("ShowDrugs")
	public String ShowDrugs(){
		return "Administrator/ShowDrugs";
	}
	
	@RequestMapping("UpdateDrug")
	public String UpdateDrug(){
		return "Administrator/UpdateDrug";
	}
	
	@RequestMapping("AddTreateRecord")
	public String AddTreateRecord(){
		return "Administrator/AddTreateRecord";
	}
	
	@RequestMapping("ShowAllTreateRecords")
	public String ShowAllTreateRecords(){
		return "Administrator/ShowAllTreateRecords";
	}
	
	@RequestMapping("UpdateTreateRecord")
	public String UpdateTreateRecord(){
		return "Administrator/UpdateTreateRecord";
	}
	
	@RequestMapping("AddTreateMoney")
	public String AddTreateMoney(){
		return "Administrator/AddTreateMoney";
	}
	
	@RequestMapping("PatientUssDrug")
	public String PatientUssDrug(){
		return "Administrator/PatientUssDrug";
	}
	
	@RequestMapping("ShowPatientUseDrug")
	public String ShowPatientUseDrug(){
		return "Administrator/ShowPatientUseDrug";
	}
	
	@RequestMapping("ShowTreateMoneys")
	public String ShowTreateMoneys(){
		return "Administrator/ShowTreateMoneys";
	}
	
	@RequestMapping("Main")
	public String Main(){
		return "Administrator/Main";
	}
	
	@RequestMapping("MainCenterBottom")
	public String MainCenterBottom(){
		return "Administrator/MainCenterBottom";
	}
	
//=========================================================================================================================================================================
	
	//管理员登陆
	@RequestMapping("AdministratorLoginAction")
	public void AdministratorLogin(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		//设置编码格式
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//获取表单传递过来的数据
		String username=request.getParameter("username");
		String account=request.getParameter("account");
		String password=request.getParameter("password");
		System.out.println("username:"+username+" account:"+account+" password:"+password);
		String ha_id = administratorService.AdministratorLogin(username, account, password);
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		System.out.println(ha_id);
		if(ha_id!=null){
			session.setAttribute("Login",ha_id);					//如果登陆成功,将登陆成功的标志存到session作用域中
			session.setAttribute("LoginName",username);
			session.setAttribute("Account",account);
			request.getRequestDispatcher("/AdministratorMain.do").forward(request, response);
		}else{
			session.setAttribute("Login",null);						//如果登陆失败,将null 空值存到session作用域中  打回登陆页面
			out.print("<script type='text/javascript'>");
			out.print("alert('用户名或账户名或密码错误,请核对后重新输入!');");
			out.print("window.location.href='"+basePath+"AdministratorLogin.do'");
			out.print("</script>");
		}
	}
	
	//判断用户名是否存在
	@RequestMapping("AdministratorLoginJudgeByNameAction")
	public void AdministratorLoginJudgeByName(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		/**
		 * 1.首先获得用户名
		 */
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//构建输入流
		PrintWriter out = response.getWriter();
		String ha_username = request.getParameter("username");
		System.out.println("ha_username:"+ha_username);
		//2.调用Dao--->service 进行业务逻辑处理
		String ha_id = administratorService.AdministratorLoginJudgeByName(ha_username);		//通过姓名获得hospital_administrator 表中的ha_id 即管理员id
		System.out.println("ha_id:"+ha_id);
		//如果查询数据库  返回的是null  说明没有查询到该用户名的存在
		if(ha_id == null){
			out.print("用户名合法");
		}else{
			out.print("用户名已存在");
		}
		//关闭输出流
		out.flush();
		//return "Administrator/AdministratorLogin";
	}
	
	//添加医生用户  用户管理
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
		out.print("alert('添加用户成功!');");
		out.print("self.location='"+basePath+"SelectAllDoctorAccountAction.do'");
		out.print("</script>");
	}
	
	//删除医生账户    用户管理
	@RequestMapping("DeleteDoctorAccountAction")
	public void DeleteDoctorAccountAction(HttpServletRequest request,HttpServletResponse response) throws IOException{
		//删除hospital_doctor 表中的 记录
		//1.获得hd_id
		String id = request.getParameter("hd_id");
		int hd_id = Integer.parseInt(id);
		administratorService.DeleteDoctorAccount(hd_id);
		//删除医生与权限对应表中的
		administratorService.DeleteHDAuthorityRecord(hd_id);
		//删除  医生  登陆账号
		administratorService.DeleteHDoctorLogin(hd_id);
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		System.out.println("basePath:"+basePath);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<script type='text/javascript'>");
		out.print("alert('删除用户成功!');");
		out.print("self.location='SelectAllDoctorAccountAction.do'");
		out.print("</script>");
		
	}
	
	//通过ID   查询医生用户
	@RequestMapping("SelectDoctorAccountAction")
	public void SelectDoctorAccount(HttpServletRequest request,HttpServletResponse response,HttpSession session,Model moel) throws IOException{
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		//首先要拿到 医生ID  hd_id
		String id = request.getParameter("hd_id");
		int hd_id =Integer.parseInt(id);
		PrintWriter outPrintWriter = response.getWriter();
		hospital_doctor hdoDoctor = administratorService.SelectDoctorAccount(hd_id);
		moel.addAttribute("hospital_doctor",hdoDoctor);							//将查询到得 医生信息数据存放到   Model 模型中
		Gson gson = new Gson();
		String jsontoString = gson.toJson(hdoDoctor);
		outPrintWriter.print(jsontoString);
		System.out.println("HDoctor:"+hdoDoctor);
	}
	
	/**
	 * 分页技术
	 * @param request
	 * @param response
	 * @param session
	 * @throws ServletException
	 * @throws IOException
	 */
	//查询所有医生用户
	@RequestMapping("SelectAllDoctorAccountAction")
	public void SelectAllDoctorAccount(HttpServletResponse response,HttpServletRequest request,HttpSession session) throws IOException, ServletException{
		//List<hospital_doctor> hDoctor = administratorService.SelectAllDoctorAccount();
		QueryInfo queryInfo = WebUtil.request2Bean(request, QueryInfo.class);								//将request请求封装到QueryInfo对象中去
		PageBean pageBean = administratorService.pageQueryHospital_Doctor(queryInfo);
		System.out.println("处理分页请求-PageBean:"+pageBean.toString());
		session.setAttribute("SelectAllDoctorAccountAction_hDoctor",pageBean);								//将查询到的结果存放到Session作用域中
		System.out.println("PageBean-NextPage:"+pageBean.getNextpage());
		System.out.println("PageBean-Previouspage:"+pageBean.getPreviouspage());
		System.out.println("PageBean-Totalpage:"+pageBean.getTotalpage());
		System.out.println("PageBean-Totalrecord:"+pageBean.getTotalrecord());
		System.out.println("PageBean-Currentpage:"+pageBean.getCurrentpage());
		System.out.println("PageBean-List:"+pageBean.getList());
		System.out.println("PageBean-PageSize:"+pageBean.getPagesize());
		System.out.println("PageBean-Pagebar:"+pageBean.getPagebar());
		request.getRequestDispatcher("/AdministratorShowAllDoctorAccount.do").forward(request, response);	//跳转到展示页面
	}
	
	//查询所有医生ID
	@RequestMapping("SelectAllHd_idsAction")
	public void SelectAllHd_ids(HttpServletResponse response) throws IOException{
		List<Integer> hd_ids = administratorService.SelectAllHd_ids();
		Gson gson = new Gson();
		String jsontoString = gson.toJson(hd_ids);
		//获得输出流
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(jsontoString);
	}
	
	//查询医生用户 通过 医生姓名查询
	@RequestMapping("SelectDoctorByHd_name")
	public void SelectDoctorByHd_name(HttpServletResponse response,HttpServletRequest request,HttpSession session) throws IOException{
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		//首先要拿到 医生ID  hd_id
		String hd_name = request.getParameter("hd_name");
		PrintWriter outPrintWriter = response.getWriter();
		List<hospital_doctor> hdoDoctor = administratorService.SelectDoctorByHd_name(hd_name);
		Gson gson = new Gson();
		String jsontoString = gson.toJson(hdoDoctor);
		outPrintWriter.print(jsontoString);
		System.out.println("HDoctor:"+hdoDoctor);
	}
	
	//更新操作查询医生用户信息
	@RequestMapping("UpdateDcotorAccountSelectDoctorByIdAction")
	public void UpdateDcotorAccountSelectDoctorById(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ServletException, IOException{
		//首先要拿到 医生ID  hd_id
		String id = request.getParameter("hd_id");
		int hd_id =Integer.parseInt(id);
		List<hospital_doctor> hdoDoctor = administratorService.SelectDoctorAccounts(hd_id);
		session.setAttribute("UpdateDcotorAccountSelectDoctorById_hDoctor",hdoDoctor);
		System.out.println("HDoctor:"+hdoDoctor);
		request.getRequestDispatcher("/UpdateDoctorAccount.do").forward(request, response);
	}
	
	//通过  科室ID  查询医生信息
	@RequestMapping("SelectHDoctorByHd_HaotoidAction")
	public void SelectHDoctorByHd_Haotoid(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("hd_haotoid");
		int hd_haotoid = Integer.parseInt(id);
		List<hospital_doctor> hDoctors = administratorService.SelectHDoctorByHd_Haotoid(hd_haotoid);
		if(hDoctors==null||hDoctors.isEmpty()){
			out.print("1");
		}else{
			out.print("0");
		}
	}
	
	//更新医生用户信息
	@RequestMapping("UpdateDoctorAccountAction")
	public void UpdateDoctorAccount(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		//1.首先通过传来的Id-->hd_id  拿到这条医生信息记录
		String id = request.getParameter("hd_id");						    //医生ID
		int hd_id = Integer.parseInt(id);
		System.out.println("hd_id:"+hd_id);
		String hd_name = request.getParameter("hd_name");					//医生姓名
		System.out.println("hd_name:"+hd_name);
		String age = request.getParameter("hd_age");						//医生年龄
		int hd_age = Integer.parseInt(age);
		System.out.println("hd_age:"+hd_age);
		String hd_sex = request.getParameter("hd_sex");						//医生性别
		System.out.println("hd_sex:"+hd_sex);
		String hd_speciality = request.getParameter("hd_speciality");		//医生特长
		System.out.println("hd_speciality:"+hd_speciality);
		String hd_pt = request.getParameter("hd_pt");						//医生职称
		System.out.println("hd_pt:"+hd_pt);
		String hd_ri = request.getParameter("hd_ri");						//医生预约信息
		System.out.println("hd_ri:"+hd_ri);
		String hd_haotoid = request.getParameter("hd_haotoid");			    //医生科室
		System.out.println("hd_haotoid:"+hd_haotoid);
		String hd_mobile = request.getParameter("hd_mobile");				//医生电话
		System.out.println("hd_mobile:"+hd_mobile);
		
		hospital_doctor hdDoctor = new hospital_doctor();
		hdDoctor.setHd_id(hd_id);
		hdDoctor.setHd_name(hd_name);
		hdDoctor.setHd_age(hd_age);
		hdDoctor.setHd_sex(hd_sex);
		hdDoctor.setHd_speciality(hd_speciality);
		hdDoctor.setHd_pt(hd_pt);
		hdDoctor.setHd_ri(hd_ri);
		hdDoctor.setHd_haotoid(hd_haotoid);
		hdDoctor.setHd_mobile(hd_mobile);
		//拿到医生记录以后 调用响应的函数 对医生信息进行更新
		administratorService.UpdateDoctorAccount(hdDoctor);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String account = (String)session.getAttribute("Account");
		System.out.println("Account:"+account);
		if(account==""||account==null){
			out.print("<script type='text/javascript'>");
			out.print("alert('修改用户信息成功!');");
			out.print("self.location='doctor/DoctorMineInformationsAction.do'");
			out.print("</script>");
		}else {
			out.print("<script type='text/javascript'>");
			out.print("alert('修改用户信息成功!');");
			out.print("self.location='SelectAllDoctorAccountAction.do'");
			out.print("</script>");
		}
	}
	
	//查询科室表中的所有科室ID(hospital_aoto)
	@RequestMapping("SelectAllHaotoidFromHAotoAction")
	public void SelectAllHaotoidFromHAoto(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("UTF-8");
		//查询所有科室ID
		//1.获得输出流
		PrintWriter out = response.getWriter();
		List<Integer> haoto_id = administratorService.SelectAllHaotoidFromHAoto();					//查询数据库获得所有的科室ID
		//2.将 java 对象 转化为 json 字符串
		Gson gson = new Gson();
		String jsontoString = gson.toJson(haoto_id);
		System.out.println(jsontoString);															//将java 对象转化为 json 字符串
		out.print(jsontoString);
	}
	
	//科室部门管理   添加科室
	@RequestMapping("AddHaotoAction")
	public void AddHaoto(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		//1.收集前台传过来的数据
		String haoto_name = request.getParameter("haoto_name");					//科室姓名
		String haoto_person = request.getParameter("haoto_person");				//科室负责人
		String haoto_decribe = request.getParameter("haoto_decribe");			//科室描述
		System.out.println("AddHaotoAction:");
		System.out.println("haoto_name:"+haoto_name);
		System.out.println("haoto_person:"+haoto_person);
		System.out.println("haoto_decribe:"+haoto_decribe);
		hospital_aoto hAoto = new hospital_aoto();
		hAoto.setHaoto_name(haoto_name);
		hAoto.setHaoto_person(haoto_person);
		hAoto.setHaoto_describe(haoto_decribe);
		administratorService.AddHaoto(hAoto);
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		System.out.println("basePath:"+basePath);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<script type='text/javascript'>");
		out.print("alert('添加科室信息成功!');");
		out.print("self.location='SelectAllHaotoAction.do'");
		out.print("</script>");
	}
	
	//查询所有科室信息
	@RequestMapping("SelectAllHaotoAction")
	public void SelectAllHaoto(HttpServletResponse response,HttpServletRequest request,HttpSession session) throws ServletException, IOException{
		//Service---->Dao 进行业务处理
		/*List<hospital_aoto> hAoto = administratorService.SelectAllHaoto();*/
		QueryInfo queryInfo = WebUtil.request2Bean(request, QueryInfo.class);								//将request请求封装到QueryInfo对象中去
		PageBean pageBean = administratorService.pageQueryHospital_aoto(queryInfo);
		System.out.println("处理分页请求-PageBean:"+pageBean.toString());
		session.setAttribute("SelectAllHaoto_hAoto",pageBean);
		request.getRequestDispatcher("/SelectAllHaoto.do").forward(request, response);
	}
	
	//通过科室ID 查询科室信息
	@RequestMapping("SelectHaotoByIdAction")
	public void SelectHaotoById(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//接收前台传输过来的数据 ID
		String id = request.getParameter("haoto_id");					//获得科室ID
		int haoto_id = Integer.parseInt(id);
		hospital_aoto hAoto = administratorService.SelectHaotoById(haoto_id);
		Gson gson = new Gson();
		String jsontoString = gson.toJson(hAoto);
		out.print(jsontoString);
	}
	
	/*//查询所有科室ID信息
	@RequestMapping("SelectAllHaoto_idsAction")
	public void SelectAllHaoto_ids(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		//查询所有科室Id信息
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		List<Integer> haoto_ids = administratorService.SelectAllHaoto_ids();
		Gson gson = new Gson();
		String jsongtoString = gson.toJson(haoto_ids);
		out.print(jsongtoString);
	}*/
	
	//通过ID 查询科室信息(返回List<hospital_aoto>)
	@RequestMapping("SelectHaotoByIdsAction")
	public void SelectHaotoByIds(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException, ServletException{
			System.out.println("-=-=-=-=-=-=-=-=");
			//接收前台传输过来的数据 ID
			String id = request.getParameter("haoto_id");					//获得科室ID
			System.out.println("SelectHaotoByIdsAction:"+id);
			int haoto_id = Integer.parseInt(id);
			List<hospital_aoto> hAoto = administratorService.SelectHaotoByIds(haoto_id);
			session.setAttribute("SelectHaotoById_hAoto",hAoto);
			request.getRequestDispatcher("/AlterHaoto.do").forward(request, response);
		}
	
	@RequestMapping("SelectHaotoByNameAction")
	public void SelectHaotoByName(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//接收前台传输过来的数据 ID
		String haoto_name = request.getParameter("haoto_name");					//获得科室ID
		List<hospital_aoto> hAoto = administratorService.SelectHaotoByName(haoto_name);
		Gson gson = new Gson();
		String jsontoString = gson.toJson(hAoto);
		out.print(jsontoString);
	}
	
	//更新科室信息
	@RequestMapping("AlterHaotoAction")
	public void AlterHaoto(HttpServletResponse response,HttpServletRequest request,HttpSession session) throws IOException{
		//收集前台传来的数据
		String id = request.getParameter("haoto_id");				//获取科室ID
		int haoto_id = Integer.parseInt(id);
		String haoto_name = request.getParameter("haoto_name");			//获取科室名称
		String haoto_person = request.getParameter("haoto_person");		//获取科室负责人
		String haoto_decribe = request.getParameter("haoto_decribe");	//获取科室描述
		hospital_aoto hAoto = new hospital_aoto();
		hAoto.setHaoto_id(haoto_id);
		hAoto.setHaoto_name(haoto_name);
		hAoto.setHaoto_person(haoto_person);
		hAoto.setHaoto_describe(haoto_decribe);
		administratorService.AlterHaoto(hAoto);
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		System.out.println("basePath:"+basePath);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<script type='text/javascript'>");
		out.print("alert('修改科室信息成功!');");
		out.print("self.location='SelectAllHaotoAction.do'");
		out.print("</script>");
	}
	
	//通过科室ID删除科室信息
	@RequestMapping("DeleteHaotoAction")
	public void DeleteHaoto(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		//拿到科室ID
		String id = request.getParameter("haoto_id");					//获得科室ID
		int haoto_id = Integer.parseInt(id);
		administratorService.DeleteHaoto(haoto_id);						//通过科室ID删除这条科室记录
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		System.out.println("basePath:"+basePath);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<script type='text/javascript'>");
		out.print("alert('删除科室信息成功!');");
		out.print("self.location='SelectAllHaotoAction.do'");
		out.print("</script>");
	}
	
	//数据字典管理   添加病人信息
	@RequestMapping("AddPatientAction")
	public void AddPatient(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ParseException, ServletException, IOException{
		System.out.println("11");
		//收集前台数据
		String doctorid = request.getParameter("hp_doctorid");							//主治医生ID
		int hp_doctorid = Integer.parseInt(doctorid);
		System.out.println("hp_doctorid:"+hp_doctorid);
		String hp_name = request.getParameter("hp_name");								//病人姓名
		String hp_sex = request.getParameter("hp_sex");									//病人性别
		String hp_birthday = request.getParameter("hp_birthday");						//病人生日
		System.out.println("String-birthday:"+hp_birthday);								//将字符串转换成日期存储到数据库 
		String hp_tath = request.getParameter("hp_tath");								//入院时间
		System.out.println("hp_tath:"+hp_tath);
		String hp_tsd = request.getParameter("hp_tsd");									//症状描述
		String hp_stat = request.getParameter("hp_stat");								//状态
		String hp_marry = request.getParameter("hp_marry");								//婚否
		hospital_patient hPatient = new hospital_patient();								//创建病人对象
		hPatient.setHp_doctorid(hp_doctorid);
		hPatient.setHp_name(hp_name);
		hPatient.setHp_sex(hp_sex);
		hPatient.setHp_birthday(hp_birthday);
		hPatient.setHp_tath(hp_tath);
		hPatient.setHp_tsd(hp_tsd);
		hPatient.setHp_stat(hp_stat);
		hPatient.setHp_marry(hp_marry);
		administratorService.AddPatient(hPatient);
		
		//通过病人姓名获得病人ID
		int hp_id = administratorService.SelectHPatientIDByName(hp_name);
		session.setAttribute("AddPatient_hp_id",hp_id);
		session.setAttribute("AddPatient_hp_name",hp_name);
		session.setAttribute("AddPatient_hp_doctorid",hp_doctorid);
		session.setAttribute("AddPatient_hp_tsd",hp_tsd);
		session.setAttribute("AddPatient_hp_tath",hp_tath);
		request.getRequestDispatcher("/AddPatientEmr.do").forward(request, response);
	}
	
	//查询所有病人信息
	@RequestMapping("SelectAllPatientsActions")
	public void SelectAllPatients(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ServletException, IOException, ParseException{
		/*List<hospital_patient> hPatients = administratorService.SelectAllPatients();*/
		QueryInfo queryInfo = WebUtil.request2Bean(request, QueryInfo.class);								//将request请求封装到QueryInfo对象中去
		PageBean pageBean = administratorService.pageQueryHospital_patient(queryInfo);
		System.out.println("处理分页请求-PageBean:"+pageBean.toString());
		session.setAttribute("SelectAllPatients_hPatients",pageBean);
		request.getRequestDispatcher("/ShowAllPatients.do").forward(request, response);
	}
	
	//通过ID 查询病人信息
	@RequestMapping("SelectPatientByIdAction")
	public void SelectPatientById(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException, ParseException{
		response.setCharacterEncoding("UTF-8");
		//获得输出流
		PrintWriter out = response.getWriter();
		//拿到前台传过来的ID
		String id = request.getParameter("hp_id");
		int hp_id = Integer.parseInt(id);
		hospital_patient hPatient= administratorService.SelectPatientById(hp_id);
		Gson gson = new Gson();
		String jsontoString = gson.toJson(hPatient);
		out.print(jsontoString);
	}
	
	//通过ID查询病人消息
	@RequestMapping("SelectPatient1ByIdAction")
	public void SelectPatient1ById(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ServletException, IOException{
		//拿到前台传过来的数据
		String id = request.getParameter("hp_id");
		int hp_id = Integer.parseInt(id);
		hospital_patient hPatient= administratorService.SelectPatientById(hp_id);
		session.setAttribute("SelectPatientById_hPatient",hPatient);
		request.getRequestDispatcher("/UpdatePatients.do").forward(request, response);
	}
	
	//查询病人的所有ID信息
	@RequestMapping("SelectAllHp_idsAction")
	public void SelectAllHp_ids(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter(); 
		List<Integer> hp_ids = administratorService.SelectAllHp_ids();
		Gson gson = new Gson();
		String jsontoString = gson.toJson(hp_ids);
		out.print(jsontoString);
	}
	
	//通过 医生id(hp_doctorid) 查询  病人记录
	@RequestMapping("SelectHPatientByHp_doctoridAction")
	public void SelectHPatientByHp_doctorid(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("hp_doctorid");
		int hp_doctorid = Integer.parseInt(id);
		List<hospital_patient> hPatient = administratorService.SelectHPatientByHp_doctorid(hp_doctorid);
		System.out.println(hPatient.isEmpty());
		System.out.println("hPatient:"+hPatient);
		//System.out.println("boolean:"+hPatient.get(0));
		if(hPatient==null||hPatient.isEmpty()){
			out.print("1");
		}else{
			out.print("0");
		}
	}
	
	//更新病人信息
	@RequestMapping("UpdateHPatientAction")
	public void UpdateHPatient(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ParseException, IOException{
		//收集前台数据
		String id = request.getParameter("hp_id");										//病人ID
		int hp_id = Integer.parseInt(id);
		System.out.println("hp_id:"+hp_id);
		String doctorid = request.getParameter("hp_doctorid");							//主治医生ID
		int hp_doctorid = Integer.parseInt(doctorid);
		System.out.println("hp_doctorid:"+hp_doctorid);
		String hp_name = request.getParameter("hp_name");								//病人姓名
		System.out.println("hp_name:"+hp_name);
		String hp_sex = request.getParameter("hp_sex");									//病人性别
		System.out.println("hp_sex:"+hp_sex);
		String hp_birthday = request.getParameter("hp_birthday");						//病人生日
		System.out.println("hp_birthday:"+hp_birthday);
		String hp_tath = request.getParameter("hp_tath");								//入院时间
		System.out.println("hp_tath:"+hp_tath);
		String hp_tsd = request.getParameter("hp_tsd");									//症状描述
		System.out.println("hp_tsd:"+hp_tsd);
		String mrid = request.getParameter("hp_mrid");									//病历编号
		int hp_mrid = Integer.parseInt(mrid);											//病历编号
		System.out.println("hp_mrid:"+hp_mrid);
		String hp_stat = request.getParameter("hp_stat");								//状态
		System.out.println("hp_stat:"+hp_stat);
		String hp_marry = request.getParameter("hp_marry");								//婚否
		System.out.println("hp_marry:"+hp_marry);
		hospital_patient hPatient = new hospital_patient();								//创建病人对象
		hPatient.setHp_id(hp_id);
		hPatient.setHp_doctorid(hp_doctorid);
		hPatient.setHp_name(hp_name);
		hPatient.setHp_sex(hp_sex);
		hPatient.setHp_birthday(hp_birthday);
		hPatient.setHp_tath(hp_tath);
		hPatient.setHp_tsd(hp_tsd);
		hPatient.setHp_mrid(hp_mrid);
		hPatient.setHp_marry(hp_marry);
		hPatient.setHp_stat(hp_stat);
		administratorService.UpdateHPatient(hPatient);
		//更行病历信息
		administratorService.UpdateHPatientEmrByIdNameTT(hp_id, hp_doctorid, hp_tsd, hp_tath);
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		System.out.println("basePath:"+basePath);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String account = (String)session.getAttribute("Account");
		System.out.println("Account:"+account);
		if(account==""||account==null){
			out.print("<script type='text/javascript'>");
			out.print("alert('修改病人信息成功!');");
			out.print("self.location='SelectAllPatientsActions.do'");
			out.print("</script>");
		}else {
			out.print("<script type='text/javascript'>");
			out.print("alert('修改病人信息成功!');");
			out.print("self.location='SelectAllPatientsActions.do'");
			out.print("</script>");
		}
	}
	
	@RequestMapping("SelectHPatientsByHp_nameAction")
	public void SelectHPatientsByHp_name(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		response.setCharacterEncoding("UTF-8");
		//获得输出流
		PrintWriter out = response.getWriter();
		//拿到前台传过来的ID
		String hp_name = request.getParameter("hp_name");
		List<hospital_patient> hPatient= administratorService.SelectHPatientsByHp_name(hp_name);
		Gson gson = new Gson();
		String jsontoString = gson.toJson(hPatient);
		out.print(jsontoString);
	}
	
	//删除 病人信息
	@RequestMapping("DeletePatientByIdAction")
	public void DeletePatientById(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException, ServletException{
		//拿到 病人 ID
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String id =  request.getParameter("hp_id");
		int hp_id = Integer.parseInt(id);
		session.setAttribute("DeletePatientByIdAction_hp_id",hp_id);
		
		//查询一下  结算记录  如果该病人已经结算  则不能删除此病人信息
		List<hospital_treatemoney> hTreatemoney = administratorService.SelectHTreatemoneyByHt_patientid(hp_id);
		System.out.println("hTreatemoney:"+hTreatemoney);
		System.out.println(hTreatemoney.isEmpty()==false);
		if(hTreatemoney.isEmpty()==false){
			out.print("2");
			request.getRequestDispatcher("/AdministratorMainIndex.do").forward(request, response);
		}
		administratorService.DeleteTreateRecordByHtr_patientid(hp_id);			//删除诊断记录  通过 病人ID
		administratorService.DeletePatientUseDrugByHpt_patientid(hp_id);		//删除病人用药信息
		administratorService.DeletePatientById(hp_id);							//删除病人信息
		
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		System.out.println("basePath:"+basePath);
		response.setCharacterEncoding("UTF-8");
		String account = (String)session.getAttribute("Account");
		System.out.println("Account:"+account);
		if(account==""||account==null){
			out.print("<script type='text/javascript'>");
			out.print("alert('删除病人信息成功!');");
			out.print("self.location='SelectAllPatientsActions.do'");
			out.print("</script>");
		}else {
			out.print("<script type='text/javascript'>");
			out.print("alert('删除病人信息成功!');");
			out.print("self.location='SelectAllPatientsActions.do'");
			out.print("</script>");
		}
	}
	
	//添加 病人电子病历
	@RequestMapping("AddPatientElectronicMedicalRecordAction")
	public void AddPatientElectronicMedicalRecord(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ParseException, IOException{
		//收集前台数据
		System.out.println("==-=-=-=-=-=-=-=-=-=-=-=----------------------------------------");
		String id = request.getParameter("hemr_patientid");					//病人ID
		int hemr_patientid = Integer.parseInt(id);
		System.out.println("hemr_patientid:"+hemr_patientid);
		String doctorid = request.getParameter("hemr_doctorid");			//主治医生ID
		int hemr_doctorid = Integer.parseInt(doctorid);
		System.out.println("hemr_doctorid:"+hemr_doctorid);
		String hemr_diagnosis = request.getParameter("hemr_diagnosis");		//诊断
		System.out.println("hemr_diagnosis:"+hemr_diagnosis);
		String hemr_symptom = request.getParameter("hemr_symptom");			//症状
		System.out.println("hemr_symptom:"+hemr_symptom);
		String hemr_method = request.getParameter("hemr_method");			//处方
		System.out.println("hemr_method:"+hemr_method);
		String hemr_starttime = request.getParameter("hemr_starttime");		//治疗开始时间
		System.out.println("hemr_starttime:"+hemr_starttime);
		String hemr_treatisend = request.getParameter("hemr_treatisend");	//治疗是否结束
		System.out.println("hemr_treatisend:"+hemr_treatisend);
		hospital_emr hEmr = new hospital_emr();								//创建 电子病历 对象
		System.out.println("equals:"+hemr_treatisend.equals("是"));
		if(hemr_treatisend.equals("是")){
			String hemr_endtime = request.getParameter("hemr_endtime");			//治疗结束时间
			System.out.println("hemr_endtime:"+hemr_endtime);
			hEmr.setHemr_endtime(hemr_endtime);
		}
		hEmr.setHemr_patientid(hemr_patientid);
		hEmr.setHemr_doctorid(hemr_doctorid);
		hEmr.setHemr_diagnosis(hemr_diagnosis);
		hEmr.setHemr_symptom(hemr_symptom);
		hEmr.setHemr_method(hemr_method);
		hEmr.setHemr_starttime(hemr_starttime);
		hEmr.setHemr_treatisend(hemr_treatisend);
		
		administratorService.AddPatientElectronicMedicalRecord(hEmr);		//到这里所有的信息插入数据库完毕  
		//通过病人ID 获得病历信息 ID(hospital_emr)  将ID插入到  病人表中(hospital_patient)
		//更新 hospital_patient表  完成病人表和病历表的联立关系
		int hemr_id = administratorService.SelectHemr_idByHemr_patientid(hemr_patientid);
		administratorService.UpdateHemr_idByHp_patientid(hemr_id, hemr_patientid);
		
		//完成  采集病人信息后,创建病历,生成诊断记录
		//1.查询  医生信息
		hospital_doctor hDoctor = administratorService.SelectDoctorAccount(hemr_doctorid);		//拿到查询的医生记录
		hospital_patient hPatient = administratorService.SelectPatientById(hemr_patientid);		//拿到病人记录
		hospital_treaterecord hTreaterecord = new hospital_treaterecord();						//生成诊断记录对象
		hTreaterecord.setHtr_patientid(hemr_patientid);
		hTreaterecord.setHtr_doctorid(hDoctor.getHd_id());
		hTreaterecord.setHtr_aotoid(Integer.parseInt(hDoctor.getHd_haotoid()));
		hTreaterecord.setHtr_treatecase(hPatient.getHp_tath());
		hTreaterecord.setHtr_treatecase(hemr_diagnosis);
		hTreaterecord.setHtr_treatetime(hemr_starttime);
		hTreaterecord.setHtr_treatetimes(1);
		//查询  数据库中是否已经有了诊断记录  如果是则记录加1  如果不是 插入记录
		/*hospital_treaterecord htr = administratorService.SelectTreateRecordByHtr_id(hemr_patientid); 
		if(htr == null || htr.equals("[]")){
			hTreaterecord.setTreatetimes(1);
			administratorService.InsertRecord(hTreaterecord);
		}else {
			
		}*/
		administratorService.InsertRecord(hTreaterecord);										//插入诊断记录到数据库
		
		
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		System.out.println("basePath:"+basePath);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String account = (String)session.getAttribute("Account");
		System.out.println("Account:"+account);
		if(account==""||account==null){
			out.print("<script type='text/javascript'>");
			out.print("alert('添加病人信息成功!');");
			out.print("self.location='SelectAllPatientsActions.do'");
			out.print("</script>");
		}else {
			out.print("<script type='text/javascript'>");
			out.print("alert('添加病人信息成功!');");
			out.print("self.location='SelectAllPatientsActions.do'");
			out.print("</script>");
		}
		
	}
	
	//删除病历 信息
	@RequestMapping("DeleteHPatientEmrByPatientidAction")
	public void DeleteHPatientEmrByPatientid(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ServletException, IOException{
		//拿到病人id hp_id
		String id = request.getParameter("hp_id");
		int hp_id = Integer.parseInt(id);
		administratorService.DeleteHPatientEmrByPatientid(hp_id);			//删除病人病历信息
		request.getRequestDispatcher("/DeletePatientByIdAction.do").forward(request, response);
	}
	
	//查询病历信息
	@RequestMapping("SelectAllHPatientsEmrAction")
	public void SelectAllHPatientsEmr(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ServletException, IOException{
		//List<hospital_emr> hEmrs = administratorService.SelectAllHPatientsEmr();
		QueryInfo queryInfo = WebUtil.request2Bean(request, QueryInfo.class);								//将request请求封装到QueryInfo对象中去
		PageBean pageBean = administratorService.pageQueryHospital_emr(queryInfo);
		System.out.println("处理分页请求-PageBean:"+pageBean.toString());
		session.setAttribute("SelectAllHPatientsEmr_hEmrs",pageBean);
		request.getRequestDispatcher("/ShowAllHPatientsEmr.do").forward(request, response);
	}
	
	//通过 病历ID 查找病历信息(Ajax)
	@RequestMapping("SelectHPatientEmrByHemr_IdAction")
	public void SelectHPatientEmrByHemr_Id(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		//拿到病历ID hemr_id
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("hemr_id");
		int hemr_id = Integer.parseInt(id);
		hospital_emr hEmr = administratorService.SelectHPatientEmrByHemr_Id(hemr_id);
		Gson gson = new Gson();
		String jsontoString = gson.toJson(hEmr);
		out.print(jsontoString);
	}
	
	//通过 病历ID 查找病历信息(jsp)
		@RequestMapping("SelectHPatientEmrByHemr_IdsAction")
		public void SelectHPatientEmrByHemr_Ids(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException, ServletException{
			//拿到病历ID hemr_id
			String id = request.getParameter("hemr_id");
			int hemr_id = Integer.parseInt(id);
			session.setAttribute("SelectHPatientEmrByHemr_Ids_hemr_id",hemr_id);
			hospital_emr hEmr = administratorService.SelectHPatientEmrByHemr_Id(hemr_id);
			session.setAttribute("SelectHPatientEmrByHemr_Ids_hEmr",hEmr);
			request.getRequestDispatcher("/UpdateHPatientEmr.do").forward(request, response);
		}
	
	//通过病人ID 查询病历信息
	@RequestMapping("SelectHemrByHemr_patientidAction")
	public void SelectHemrByHemr_patientid(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//拿到病人ID
		String id = request.getParameter("hemr_patientid");
		int hemr_patientid = Integer.parseInt(id);								//病历ID
		hospital_emr hEmr = administratorService.SelectHemrByHemr_patientid(hemr_patientid);
		Gson gson = new Gson();
		String jsontoString = gson.toJson(hEmr);
		out.print(jsontoString);
	}
		
	//更新病人病历信息
	@RequestMapping("UpdateHPatientEmrAction")
	public void UpdateHPatientEmr(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		//收集前台数据
		System.out.println("进入UpdateHPatientEmrAction");
		String h_id = request.getParameter("hemr_id");						//获得病历ID
		int hemr_id = Integer.parseInt(h_id);
		String id = request.getParameter("hemr_patientid");					//病人ID
		int hemr_patientid = Integer.parseInt(id);
		System.out.println("hemr_patientid:"+hemr_patientid);
		String doctorid = request.getParameter("hemr_doctorid");			//主治医生ID
		int hemr_doctorid = Integer.parseInt(doctorid);
		System.out.println("hemr_doctorid:"+hemr_doctorid);
		String hemr_diagnosis = request.getParameter("hemr_diagnosis");		//诊断
		System.out.println("hemr_diagnosis:"+hemr_diagnosis);
		String hemr_symptom = request.getParameter("hemr_symptom");			//症状
		System.out.println("hemr_symptom:"+hemr_symptom);
		String hemr_method = request.getParameter("hemr_method");			//处方
		System.out.println("hemr_method:"+hemr_method);
		String hemr_starttime = request.getParameter("hemr_starttime");		//治疗开始时间
		System.out.println("hemr_starttime:"+hemr_starttime);
		String hemr_treatisend = request.getParameter("hemr_treatisend");	//治疗是否结束
		System.out.println("hemr_treatisend:"+hemr_treatisend);
		hospital_emr hEmr = new hospital_emr();								//创建 电子病历 对象
		System.out.println("equals:"+hemr_treatisend.equals("是"));
		if(hemr_treatisend.equals("是")){
			String hemr_endtime = request.getParameter("hemr_endtime");		//治疗结束时间
			System.out.println("hemr_endtime:"+hemr_endtime);
			hEmr.setHemr_endtime(hemr_endtime);
		}
		hEmr.setHemr_id(hemr_id);
		hEmr.setHemr_patientid(hemr_patientid);
		hEmr.setHemr_doctorid(hemr_doctorid);
		hEmr.setHemr_diagnosis(hemr_diagnosis);
		hEmr.setHemr_symptom(hemr_symptom);
		hEmr.setHemr_method(hemr_method);
		hEmr.setHemr_starttime(hemr_starttime);
		hEmr.setHemr_treatisend(hemr_treatisend);
		administratorService.UpdateHPatientEmr(hEmr);
		administratorService.UpdateHPatientByHemr_diagnosisAndHemr_starttime(hemr_patientid, hemr_diagnosis, hemr_starttime);
		//更新诊断记录  ？？？
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String account = (String)session.getAttribute("Account");
		System.out.println("Account:"+account);
		if(account==""||account==null){
			out.print("<script type='text/javascript'>");
			out.print("alert('修改病人病历信息成功!');");
			out.print("self.location='SelectAllHPatientsEmrAction.do'");
			out.print("</script>");
		}else {
			out.print("<script type='text/javascript'>");
			out.print("alert('修改病人病历信息成功!');");
			out.print("self.location='SelectAllHPatientsEmrAction.do'");
			out.print("</script>");
		}
	}
	
	//通知管理   管理员添加通知
	@RequestMapping("AddInformsAction")
	public void AddInforms(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		//收集前台数据
		String id = request.getParameter("hi_personid");
		int hi_personid = Integer.parseInt(id);						//通知人ID
		String hi_tet = request.getParameter("hi_tet");				//录入时间
		String hi_content = request.getParameter("hi_content");		//内容
		hospital_inform hInform = new hospital_inform();
		hInform.setHi_personid(hi_personid);
		hInform.setHi_tet(hi_tet);	
		hInform.setHi_content(hi_content);
		administratorService.AddInforms(hInform);
		doctorService.AddInforms(hInform);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<script type='text/javascript'>");
		out.print("alert('添加通知信息成功!');");
		out.print("self.location='SelectAllInformsAction.do'");
		out.print("</script>");
	}
	
	//设置 通知人和通知时间为即先设定的 
	@RequestMapping("SelectAllByHa_idAction")
	public void SelectAllByHa_id(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//获得管理员id 
		String id =(String)session.getAttribute("Login");
		int ha_id = Integer.parseInt(id);
		hospital_administrator hAdministrator = administratorService.SelectAllByHa_id(ha_id);
		Gson gson = new Gson();
		String jsontoString = gson.toJson(hAdministrator);
		out.print(jsontoString);
	}
	
	//查询所有的通知信息
	@RequestMapping("SelectAllInformsAction")
	public void SelectAllInforms(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ServletException, IOException{
		//List<hospital_inform> hInforms = administratorService.SelectAllInforms();
		QueryInfo queryInfo = WebUtil.request2Bean(request, QueryInfo.class);								//将request请求封装到QueryInfo对象中去
		PageBean pageBean = administratorService.pageQueryHospital_inform(queryInfo);
		System.out.println("处理分页请求-PageBean:"+pageBean.toString());
		session.setAttribute("SelectAllInforms_hInforms",pageBean);
		request.getRequestDispatcher("/ShowAllInforms.do").forward(request, response);
	}
	
	//通过通知ID 查询通知信息
	@RequestMapping("SelectInformByHi_idAction")
	public void SelectInformByHi_id(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//收集前台数据
		String id = request.getParameter("hi_id");
		int hi_id = Integer.parseInt(id);
		hospital_inform hInform = administratorService.SelectInformByHi_id(hi_id);
		Gson gson = new Gson();
		String jsontoString = gson.toJson(hInform);
		out.print(jsontoString);
	}
	
	//通过通知ID 查询通知信息
	@RequestMapping("SelectInformByHi_idsAction")
	public void SelectInformByHi_ids(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException, ServletException{
		//收集前台数据
		String id = request.getParameter("hi_id");
		int hi_id = Integer.parseInt(id);
		hospital_inform hInform = administratorService.SelectInformByHi_id(hi_id);
		session.setAttribute("SelectInformByHi_ids_hInform",hInform);
		request.getRequestDispatcher("/UpdateInforms.do").forward(request, response);
	}
	
	//查询  通知人姓名
	@RequestMapping("SelectHi_personNameByHi_idAction")
	public void SelectHi_personNameByHi_id(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("hi_id");
		int ha_id = Integer.parseInt(id);
		String hi_personname = administratorService.SelectHi_personNameByHi_id(ha_id);
		out.print(hi_personname);
	}
	
	//更新通知信息
	@RequestMapping("UpdateInformByIdAction")
	public void UpdateInformById(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		System.out.println("进入UpdateInformByIdAction");
		//收集前台数据
		String id = request.getParameter("hi_id");						//通知Id 
		int hi_id = Integer.parseInt(id);							
		System.out.println("hi_id"+hi_id);
		String personid = request.getParameter("hi_personid");			//通知人ID
		int hi_personid = Integer.parseInt(personid);	
		System.err.println("hi_personid:"+hi_personid);
		String hi_tet = request.getParameter("hi_tet");					//通知时间
		System.out.println("hi_tet:"+hi_tet);
		String hi_content = request.getParameter("hi_content");			//通知内容
		System.out.println("hi_content:"+hi_content);
		hospital_inform hInform = new hospital_inform();
		hInform.setHi_id(hi_id);
		hInform.setHi_personid(hi_personid);
		hInform.setHi_tet(hi_tet);
		hInform.setHi_content(hi_content);
		administratorService.UpdateInformById(hInform);
		System.out.println("1001011:"+hInform);
		doctorService.UpdateInformById(hInform);
		System.out.println("=======通知更新完毕======");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<script type='text/javascript'>");
		out.print("alert('修改通知信息成功!');");
		out.print("self.location='SelectAllInformsAction.do'");
		out.print("</script>");
	}
	
	//删除通知
	@RequestMapping("DeleteInformAction")
	public void DeleteInform(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		//收集前台数据
		String id = request.getParameter("hi_id");
		int hi_id = Integer.parseInt(id);
		administratorService.DeleteInform(hi_id);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<script type='text/javascript'>");
		out.print("alert('删除通知信息成功!');");
		out.print("self.location='SelectAllInformsAction.do'");
		out.print("</script>");
	}
	
	//药品管理
	//添加药品信息
	@RequestMapping("AddDrugsAction")
	public void AddDrugs(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		//收集前台数据
		String hdrug_name =request.getParameter("hdrug_name");					//药品名称
		String price = request.getParameter("hdrug_price");						
		Double hdrug_price = Double.parseDouble(price);								//药品价格
		System.out.println("price:"+hdrug_price);
		String hdrug_birthday = request.getParameter("hdrug_birthday");			//药品生产日期			
		String hdrug_type = request.getParameter("hdrug_type");					//药品类型
		String hdrug_introduce = request.getParameter("hdrug_introduce");		//药品介绍
		hospital_drug hDrug = new hospital_drug();								//药品对象
		hDrug.setHdrug_name(hdrug_name);
		hDrug.setHdrug_price(hdrug_price);
		hDrug.setHdrug_birthday(hdrug_birthday);
		hDrug.setHdrug_type(hdrug_type);
		hDrug.setHdrug_introduce(hdrug_introduce);
		administratorService.AddDrugs(hDrug);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<script type='text/javascript'>");
		out.print("alert('添加药品信息成功!');");
		out.print("self.location='SelectAllDrugsAction.do'");
		out.print("</script>");
	}
	
	//查询所有药品信息
	@RequestMapping("SelectAllDrugsAction")
	public void SelectAllDrugs(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ServletException, IOException{
		//List<hospital_drug> hDrugs = administratorService.SelectAllDrugs();
		QueryInfo queryInfo = WebUtil.request2Bean(request, QueryInfo.class);								//将request请求封装到QueryInfo对象中去
		PageBean pageBean = administratorService.pageQueryHospital_drug(queryInfo);
		System.out.println("处理分页请求-PageBean:"+pageBean.toString());
		session.setAttribute("SelectAllDrugs_hDrugs",pageBean);
		request.getRequestDispatcher("/ShowDrugs.do").forward(request, response);
	}
	
	//通过ID 查询药品信息(Ajax)
	@RequestMapping("SelectHDrugByHdrug_idAction")
	public void SelectHDrugByHdrug_id(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//收集前台数据
		String id = request.getParameter("hdrug_id");
		int hdrug_id = Integer.parseInt(id);
		hospital_drug hDrug = administratorService.SelectHDrugByHdrug_id(hdrug_id);
		Gson gson = new Gson();
		String jsontoString = gson.toJson(hDrug);
		out.print(jsontoString);
	}
	
	//通过ID 查询药品信息(jsp)
	@RequestMapping("SelectHDrugByHdrug_idActions")
	public void SelectHDrugByHdrug_ids(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException, ServletException{
		//收集前台数据
		String id = request.getParameter("hdrug_id");
		int hdrug_id = Integer.parseInt(id);
		hospital_drug hDrug = administratorService.SelectHDrugByHdrug_id(hdrug_id);
		session.setAttribute("SelectHDrugByHdrug_ids_hDrug",hDrug);
		request.getRequestDispatcher("/UpdateDrug.do").forward(request, response);
	}
	
	@RequestMapping("JudgeDrugNameAction")
	public void JudgeDrugName(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//拿到药品名称
		String hdrug_name = request.getParameter("hdrug_name");
		String hdrug_id = administratorService.JudgeDrugName(hdrug_name);
		if(hdrug_id!=null){
			out.print("药品名称已存在");
		}else{
			out.print("药品名称合法");
		}
	}
	
	//通过  药品名称  查询药品信息
	@RequestMapping("SelectHDrugByNameAction")
	public void SelectHDrugByName(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//拿到药品名称 
		String hdrug_name = request.getParameter("hdrug_name");
		List<hospital_drug> hDrug = administratorService.SelectHDrugByName(hdrug_name);
		Gson gson = new Gson();
		String jsontoString = gson.toJson(hDrug);
		out.print(jsontoString);
	}
	
	//通过 药品名称  查询 药品信息
	@RequestMapping("SelectDrugByHdrug_nameAction")
	public void SelectDrugByHdrug_name(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//收集前台数据
		String hdrug_name = request.getParameter("hdrug_name");
		List<hospital_drug> hDrug = administratorService.SelectDrugByHdrug_name(hdrug_name);
		Gson gson = new Gson();
		String jsontoString = gson.toJson(hDrug);
		out.print(jsontoString);
	}
	
	//更新药品信息
	@RequestMapping("UpdateDrugAction")
	public void UpdateDrug(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		//收集前台数据 进行业务逻辑处理
		String id = request.getParameter("hdrug_id");					//药品ID
		int hdrug_id = Integer.parseInt(id);
		String hdrug_name = request.getParameter("hdrug_name");			//药品名称
		String price = request.getParameter("hdrug_price");				//药品价格
		Double hdrug_price = Double.parseDouble(price);			
		String hdrug_birthday = request.getParameter("hdrug_birthday");	//药品生产日期
		String hdrug_type = request.getParameter("hdrug_type");			//药品类型
		String hdrug_introduce = request.getParameter("hdrug_introduce");//药品介绍
		hospital_drug hDrug = new hospital_drug();
		hDrug.setHdrug_id(hdrug_id);
		hDrug.setHdrug_name(hdrug_name);
		hDrug.setHdrug_price(hdrug_price);
		hDrug.setHdrug_birthday(hdrug_birthday);
		hDrug.setHdrug_type(hdrug_type);
		hDrug.setHdrug_introduce(hdrug_introduce);
		administratorService.UpdateDrug(hDrug);
		PrintWriter out = response.getWriter();
		out.print("<script type='text/javascript'>");
		out.print("alert('修改药品信息成功!');");
		out.print("self.location='SelectAllDrugsAction.do'");
		out.print("</script>");
	}
	
	//通过ID删除药品信息
	@RequestMapping("DeleteDrugAction")
	public void DeleteDrug(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		//收集前台数据
		String id = request.getParameter("hdrug_id");
		int hdrug_id = Integer.parseInt(id);
		administratorService.DeleteDrug(hdrug_id);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<script type='text/javascript'>");
		out.print("alert('删除药品信息成功!');");
		out.print("self.location='SelectAllDrugsAction.do'");
		out.print("</script>");
	}
	
	//诊断记录管理   添加诊断记录
	@RequestMapping("InsertRecordAction")
	public void InsertRecord(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		//添加诊断记录
		String patientid = request.getParameter("htr_patientid");				//病人ID
		int htr_patientid = Integer.parseInt(patientid);						
		String doctorid = request.getParameter("htr_doctorid");					//医生ID
		int htr_doctorid = Integer.parseInt(doctorid);				
		String aotoid = request.getParameter("htr_aotoid");						//科室ID
		int htr_aotoid = Integer.parseInt(aotoid);					
		String htr_treatetime = request.getParameter("htr_treatetime");			//治疗时间
		String treatetimes = request.getParameter("htr_treatetimes");			//诊断次数
		int htr_treatetimes = Integer.parseInt(treatetimes);					
		String htr_treatecase = request.getParameter("htr_treatecase");			//诊断详情
		hospital_treaterecord hTreaterecord = new hospital_treaterecord();
		hTreaterecord.setHtr_patientid(htr_patientid);
		hTreaterecord.setHtr_doctorid(htr_doctorid);
		hTreaterecord.setHtr_aotoid(htr_aotoid);
		hTreaterecord.setHtr_treatetime(htr_treatetime);
		hTreaterecord.setHtr_treatetimes(htr_treatetimes);
		hTreaterecord.setHtr_treatecase(htr_treatecase);
		administratorService.InsertRecord(hTreaterecord);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<script type='text/javascript'>");
		out.print("alert('添加诊断记录成功!');");
		out.print("self.location='SelectAllTreateRecordsAction.do'");
		out.print("</script>");
	}
	
	//查询所有得 诊断记录信息
	@RequestMapping("SelectAllTreateRecordsAction")
	public void SelectAllTreateRecords(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ServletException, IOException{
		//List<hospital_treaterecord> SelectAllTreateRecords = administratorService.SelectAllTreateRecords();
		QueryInfo queryInfo = WebUtil.request2Bean(request, QueryInfo.class);								//将request请求封装到QueryInfo对象中去
		PageBean pageBean = administratorService.pageQueryHospital_treaterecord(queryInfo);
		System.out.println("处理分页请求-PageBean:"+pageBean.toString());
		session.setAttribute("SelectAllTreateRecords_SelectAllTreateRecords", pageBean);
		request.getRequestDispatcher("/ShowAllTreateRecords.do").forward(request, response);
	}
	
	//通过 病人ID  查询诊断记录List<hospital_treaterecord>
	@RequestMapping("SelectTreateRecordByHtr_patientidAction")
	public void SelectTreateRecordByHtr_patientid(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//通过病人ID  查询诊断记录信息
		String patientid = request.getParameter("htr_patientid");
		int htr_patientid = Integer.parseInt(patientid);
		List<hospital_treaterecord> hTreaterecords = administratorService.SelectTreateRecordByHtr_patientid(htr_patientid);
		Gson gson = new Gson();
		String jsontoString = gson.toJson(hTreaterecords);
		out.print(jsontoString);
	}
	
	//通过 记录ID  查询诊断记录信息
	@RequestMapping("SelectTreateRecordByHtr_idAction")
	public void SelectTreateRecordByHtr_id(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ServletException, IOException{
		String id = request.getParameter("htr_id");
		int htr_id = Integer.parseInt(id);
		hospital_treaterecord hTreaterecord = administratorService.SelectTreateRecordByHtr_id(htr_id);
		session.setAttribute("SelectTreateRecordByHtr_id_hTreaterecord", hTreaterecord);
		request.getRequestDispatcher("/UpdateTreateRecord.do").forward(request, response);
	}
	
	//通过 病人ID 查询 诊断次数
	@RequestMapping("SelectTreateRecordsCountByHtr_patientidAction")
	public void SelectTreateRecordsCountByHtr_patientid(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("htr_patientid");
		int htr_patientid = Integer.parseInt(id);
		int count = administratorService.SelectTreateRecordsCountByHtr_patientid(htr_patientid);
		Gson gson = new Gson();
		String jsontoString = gson.toJson(count);
		out.print(jsontoString);
	}
	
	//更新记录信息
	@RequestMapping("UpdateTreateRecordAction")
	public void UpdateTreateRecord(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		//收集前台数据
		String id = request.getParameter("htr_id");									//记录ID
		int htr_id = Integer.parseInt(id);						
		System.out.println("htr_id:"+htr_id);
		String patientid = request.getParameter("htr_patientid");					//病人ID
		int htr_patientid = Integer.parseInt(patientid);		
		System.out.println("htr_patientid:"+htr_patientid);
		String doctorid = request.getParameter("htr_doctorid");						//医生ID
		int htr_doctorid = Integer.parseInt(doctorid);
		System.out.println("htr_doctorid:"+htr_doctorid);
		String aotoid = request.getParameter("htr_aotoid");							//科室ID
		int htr_aotoid = Integer.parseInt(aotoid);
		System.out.println("htr_aotoid:"+htr_aotoid);
		String htr_treatetime = request.getParameter("htr_treatetime");				//诊断时间
		System.out.println("htr_treatetime:"+htr_treatetime);
		String htr_treatecase = request.getParameter("htr_treatecase");				//诊断详情
		System.out.println("htr_treatecase:"+htr_treatecase);
		hospital_treaterecord hTreaterecord = new hospital_treaterecord();
		hTreaterecord.setHtr_id(htr_id);
		hTreaterecord.setHtr_patientid(htr_patientid);
		hTreaterecord.setHtr_doctorid(htr_doctorid);
		hTreaterecord.setHtr_aotoid(htr_aotoid);
		hTreaterecord.setHtr_treatetime(htr_treatetime);
		hTreaterecord.setHtr_treatecase(htr_treatecase);
		administratorService.UpdateTreateRecord(hTreaterecord);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<script type='text/javascript'>");
		out.print("alert('修改诊断记录成功!');");
		out.print("self.location='SelectAllTreateRecordsAction.do'");
		out.print("</script>");
	}
	
	//删除诊断记录
	@RequestMapping("DeleteTreateRecordAction")
	public void DeleteTreateRecord(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		//拿到诊断ID --> htr_id
		String id = request.getParameter("htr_id");				//诊断记录ID
		int htr_id = Integer.parseInt(id);
		administratorService.DeleteTreateRecord(htr_id);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<script type='text/javascript'>");
		out.print("alert('删除诊断信息成功!');");
		out.print("self.location='SelectAllTreateRecordsAction.do'");
		out.print("</script>");
	}
	
	
	//治疗费用管理
	//添加治疗费用
	@RequestMapping("AddTreateMoneyAction")
	public void AddTreateMoney(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		//收集前台数据
		String id = request.getParameter("htm_patientid");							//治疗病人ID
		int htm_patientid = Integer.parseInt(id);	
		String htm_name = request.getParameter("htm_name");							//费用名称
		String htm_treatmoneytype = request.getParameter("htm_treatemoneytype");	//费用类型
		String htm_moneyconsum = request.getParameter("htm_moneyconsum");			//消费金额
		String htm_consumtime = request.getParameter("htm_consumtime");				//消费日期
		String htm_ispaymoney = request.getParameter("htm_ispaymoney");				//是否已支付
		hospital_treatemoney hTreatemoney = new hospital_treatemoney();
		hTreatemoney.setHtm_patientid(htm_patientid);
		hTreatemoney.setHtm_name(htm_name);
		hTreatemoney.setHtm_treatmoneytype(htm_treatmoneytype);
		hTreatemoney.setHtm_moneyconsum(htm_moneyconsum);
		hTreatemoney.setHtm_consumtime(htm_consumtime);
		hTreatemoney.setHtm_ispaymoney(htm_ispaymoney);
		administratorService.AddTreateMoney(hTreatemoney);
	}
	
	//病人用药信息管理
	//查询 病人用药信息管理  
	@RequestMapping(value="SelectPatientUseDrugAction")
	public void SelectPatientUseDrug(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//首先拿到 hpt_patientid  hpt_drugid
		String patinentid = request.getParameter("hemr_patientid");
		int hpt_patientid = Integer.parseInt(patinentid);
		System.out.println("Hpt_patientid:"+hpt_patientid);
		String drugid = request.getParameter("hdrug_id");
		int hpt_drugid = Integer.parseInt(drugid);
		System.out.println("hpt_drugid:"+hpt_drugid);
		hospital_patientusedrug hPatientusedrug = new hospital_patientusedrug();
		hPatientusedrug.setHpt_patientid(hpt_patientid);
		hPatientusedrug.setHpt_drugid(hpt_drugid);
		hPatientusedrug.setHpt_count(1);
		//添加病人用药信息   首先判断数据库中是否有该记录  如果有  count+1   如果没有则插入
		String id = administratorService.SelectPatientUseDrugByHpt_patientidAndHpt_drugid(hpt_patientid, hpt_drugid);
		System.out.println("121==:"+id);
		if(id==null ||id.equals("[]"))
		{
			administratorService.InsertPatientUseDrug(hPatientusedrug);
		}else{
			System.out.println("进入Else块");
			//进入if 语句 证明 数据库中有该记录  故记录加一
			int hpt_id = Integer.parseInt(id);
			administratorService.AlterPatientUseDrugCount(hpt_id);
		}
		System.out.println("ooooooooooooooooooo");
		Gson gson = new Gson();
		List<Integer> h_drugid;
		List<hospital_drug> list=new ArrayList<hospital_drug>();
		if(id == null ||id.equals("[]")){
			h_drugid = administratorService.SelectPatientUseDrug1(hpt_patientid);					//拿到药品ID
			for (Integer  pt_drugid : h_drugid) {
				System.out.println("pt_drugid:"+pt_drugid);
				hospital_drug hDrug = administratorService.SelectHDrugByHdrug_id(pt_drugid);	//拿到药品信息
				list.add(hDrug);
				System.out.println(hDrug);
			}
		}else{
			//查询病人用药信息
			h_drugid = administratorService.SelectPatientUseDrug1(hpt_patientid);				//拿到药品ID
			for (Integer  did : h_drugid) {
				hospital_drug hDrug = administratorService.SelectHDrugByHdrug_id(did);	//拿到药品信息
				list.add(hDrug);
				System.out.println(hDrug);
			}
		}
		String jsontoString = gson.toJson(list);
		out.print(jsontoString);
		System.out.println("jsontoString:"+jsontoString);
		System.out.println("1111111111111111");
	}
	
	//通过 病人 ID 查询所有病人用药信息ID
	@RequestMapping("SelectPatientUseDrugByHpt_patientidAction")
	public void SelectPatientUseDrugByHpt_patientid(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException, ServletException{
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//拿到前台传过来的 病人ID
		String id = request.getParameter("hemr_patientid");			//拿到前台传来的病人ID
		int patientid = Integer.parseInt(id);
		List<hospital_patientusedrug> hPatientusedrugs = administratorService.SelectHPUseDrugByHpt_patientid(patientid);
		List<hospital_drug> drugs = new ArrayList<hospital_drug>();
		System.out.println(hPatientusedrugs);
		for (hospital_patientusedrug  drug : hPatientusedrugs) {
			//首先拿到 药品ID  和  Count 次数
			int hdrug_id = drug.getHpt_drugid();		//拿到药品ID
			hospital_drug hDrug = administratorService.SelectHDrugByHdrug_id(hdrug_id);	//拿到药品信息
			drugs.add(hDrug);
		}
		Gson gon = new Gson();
		String jsontoString = gon.toJson(drugs);
		out.print(jsontoString);
		
	}
	
	//获得药品数量
	@RequestMapping("SelectDrugCountAction")
	public void SelectDrugCount(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		//拿到前天传来的病人ID
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//拿到前台传过来的 病人ID
		String id = request.getParameter("hemr_patientid");			//拿到前台传来的病人ID
		int patientid = Integer.parseInt(id);
		List<hospital_patientusedrug> hPatientusedrugs = administratorService.SelectHPUseDrugByHpt_patientid(patientid);
		System.out.println("hPatientusedrugs:"+hPatientusedrugs);
		Gson gon = new Gson();
		String jsontoString1 = gon.toJson(hPatientusedrugs);
		out.print(jsontoString1);
	}
	
	//删除用药信息
	@RequestMapping("DeletePatientUseDrugAction")
	public void DeletePatientUseDrug(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		//拿到前台  传来的  药品ID  后   在数据库中判断   如果数据库有这条记录且count > 1则count-1  否则count==1 
		String id = request.getParameter("hpt_id");
		int hpt_drugid = Integer.parseInt(id);
		String patientid = request.getParameter("hpt_patientid");
		int hpt_patientid = Integer.parseInt(patientid);
		
		//判断数据库中的药品数量  是不是 大于 1
		int hpt_count = administratorService.SelectDrugCountByHpt_patientidAndHpt_drugid(hpt_patientid, hpt_drugid);
		if(hpt_count > 1){
			administratorService.UpdateDrugCount(hpt_patientid, hpt_drugid);
		}else{
			String h_id = administratorService.SelectPatientUseDrugByHpt_patientidAndHpt_drugid(hpt_patientid, hpt_drugid);
			int hpt_id = Integer.parseInt(h_id);
			administratorService.DeletePatientUseDrug(hpt_id);			
		}
		

		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<script type='text/javascript'>");
		out.print("alert('删除用药信息成功!');");
		out.print("self.location='PatientUssDrug.do'");
		out.print("</script>");
	}
	
	//费用结算报表管理
	@RequestMapping("ShowPatientUseDrugAction")
	public void ShowPatientUseDrug(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ServletException, IOException{
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//拿到 hpt_patientid 查询  病人用药信息
		String id =request.getParameter("hpt_patientid");
		int hpt_patientid = Integer.parseInt(id);
		List<hospital_patientusedrug> hPatientusedrugs = administratorService.SelectHPUseDrugByHpt_patientid(hpt_patientid);	
		List<hospital_drug> drugs = new ArrayList<hospital_drug>();
		for (hospital_patientusedrug drug : hPatientusedrugs) {
			//拿到药品   数量 
			int hpt_drugid = drug.getHpt_drugid();
			hospital_drug hDrug = administratorService.SelectHDrugByHdrug_id(hpt_drugid);
			drugs.add(hDrug);
		}
		System.out.println("hDrugs:"+drugs);
		Gson gson = new Gson();
		/*String jsontoString = gson.toJson(hPatientusedrugs);*/
		String drug = gson.toJson(drugs);
		/*out.print(jsontoString);*/
		out.print(drug);
		System.out.println("oo:"+drug);
		
	}
	
	//结算
	@RequestMapping("TreatMoneyEndAction")
	public void TreatMoneyEnd(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ServletException, IOException{
		//拿到前台数据
		String id = request.getParameter("hpt_patientid");
		int hpt_patientid = Integer.parseInt(id);
		List<Integer> hpt_drugids = administratorService.SelectPatientUseDrug1(hpt_patientid);
		double sum=0.0;//得到的是总信息
		for (Integer hpt_drugid : hpt_drugids) {
			//查询   药品数量
			double count = administratorService.DrugCounts(hpt_patientid, hpt_drugid);
			System.out.println("hpt_drugid:"+hpt_drugid+" count:"+count);
			//查询 药品的 信息  拿到价格
			hospital_drug hDrug = administratorService.SelectHDrugByHdrug_id(hpt_drugid);
			sum=sum+(hDrug.getHdrug_price()*count);
		}
		System.out.println("sum:"+sum+"hpt_patientid:"+hpt_patientid);
		session.setAttribute("TreatMoneyEnd_hpt_patientid", hpt_patientid);
		session.setAttribute("TreatMoneyEnd_sum",sum);
		request.getRequestDispatcher("/AddTreateMoney.do").forward(request, response);
	}
	
	//添加   结算记录
	@RequestMapping("InsertTreatMoneyAction")
	public void InsertTreatMoney(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		//收集前台数据
		String id = request.getParameter("htm_patientid");					//结算病人ID
		int htm_patientid = Integer.parseInt(id);
		String htm_name = request.getParameter("htm_name");					//结算费用名称
		String htm_ispaymoney = request.getParameter("htm_ispaymoney");		//是否结算
		String htm_treatmoneytype = request.getParameter("htm_treatmoneytype");//费用类型
		String htm_moneyconsum = request.getParameter("htm_moneyconsum");	//消费金额
		String htm_consumtime = request.getParameter("htm_consumtime");		//消费日期
		hospital_treatemoney hTreatemoney = new hospital_treatemoney();
		hTreatemoney.setHtm_patientid(htm_patientid);
		hTreatemoney.setHtm_name(htm_name);
		hTreatemoney.setHtm_ispaymoney(htm_ispaymoney);
		hTreatemoney.setHtm_consumtime(htm_consumtime);
		hTreatemoney.setHtm_moneyconsum(htm_moneyconsum);
		hTreatemoney.setHtm_treatmoneytype(htm_treatmoneytype);
		administratorService.InsertTreatMoney(hTreatemoney);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String account = (String)session.getAttribute("Account");
		System.out.println("Account:"+account);
		if(account==""||account==null){
			out.print("<script type='text/javascript'>");
			out.print("alert('结算成功,请在结算记录管理中查看结算记录!');");
			out.print("self.location='ShowPatientUseDrug.do'");
			out.print("</script>");
		}else {
			out.print("<script type='text/javascript'>");
			out.print("alert('结算成功,请在结算记录管理中查看结算记录!');");
			out.print("self.location='ShowPatientUseDrug.do'");
			out.print("</script>");
		}
	}
	
	//查询结算记录
	@RequestMapping("SelectTreateMoneyAction")
	public void SelectTreateMoney(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ServletException, IOException{
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//查询结账记录
		//List<hospital_treatemoney> treatemoneys = administratorService.SelectTreateMoney();
		QueryInfo queryInfo = WebUtil.request2Bean(request, QueryInfo.class);								//将request请求封装到QueryInfo对象中去
		PageBean pageBean = administratorService.pageQueryHospital_treatemoney(queryInfo);
		System.out.println("处理分页请求-PageBean:"+pageBean.toString());
		session.setAttribute("SelectTreateMoney_treatemoneys", pageBean);
		String account = (String)session.getAttribute("Account");
		System.out.println("Account:"+account);
		if(account==""||account==null){
			out.print("<script type='text/javascript'>");
			out.print("self.location='doctor/ShowAllTreateMoney.do'");
			out.print("</script>");
		}else {
			out.print("<script type='text/javascript'>");
			out.print("self.location='ShowTreateMoneys.do'");
			out.print("</script>");
		}
		/*request.getRequestDispatcher("/ShowTreateMoneys.do").forward(request, response);*/
	}
	
	//通过病人  id  查询诊断记录
	@RequestMapping("SelectHTreateRecordByHtr_patientidAction")
	public void SelectHTreateRecordByHtr_patientid(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("htr_patientid");
		int htr_patientid = Integer.parseInt(id);
		List<hospital_treaterecord> hTreaterecords = administratorService.SelectTreateRecordByHtr_patientid(htr_patientid);			//通过病人ID 查询  治疗记录
		List<hospital_treatemoney> hTreatemoneys = administratorService.SelectHTreatemoneyByHt_patientid(htr_patientid);			//查询结算表通过病人ID
		if(hTreaterecords==null||hTreaterecords.isEmpty()){
			if(hTreatemoneys!=null){
				out.print("2");
			}else {
				out.print("1");
			}
		}else{
			out.print("0");
		}
	}
	
	@RequestMapping("SelectHTreateRecordByHtr_patientidAction1")
	public void SelectHTreateRecordByHtr_patientid1(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("htr_patientid");
		int htr_patientid = Integer.parseInt(id);
		List<hospital_treatemoney> hTreatemoneys = administratorService.SelectHTreatemoneyByHt_patientid(htr_patientid);			//查询结算表通过病人ID
		if(!hTreatemoneys.isEmpty()){
			out.print("2");
		}else {
			out.print("1");
		}
	}
	
	//删除结算记录
	@RequestMapping("DeleteTreateMoneyAction")
	public void DeleteTreateMoney(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		//收集前台 删除结算记录ID
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("htm_id");
		int htm_id = Integer.parseInt(id);
		administratorService.DeleteTreateMoney(htm_id);
		out.print("<script type='text/javascript'>");
		out.print("alert('删除结算记录信息成功!');");
		out.print("self.location='SelectTreateMoneyAction.do'");
		out.print("</script>");
	}
	
	
	//处理分页请求	前台传过来  QueryInfo封装的数据信息
	@RequestMapping("pageQueryAction")
	public void pageQuery(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		//拿到前台传过来的数据  进行判断是否为空
		QueryInfo queryInfo = new QueryInfo();
		String currentpage = request.getParameter("currentpage");
		System.out.println("pageQueryAction-currentpage:"+currentpage);
		//判断  传过来的 当前页码  是否为空
		if(currentpage != null){
			int cur = Integer.parseInt(currentpage);			//将当前页转换成int  类型
			queryInfo.setCurrentpage(cur);
		}
		String pagesize = request.getParameter("pagesize");		//当前页面大小
		System.out.println("pageQueryAction-pagesize:"+pagesize);
		if(pagesize != null){
			int page = Integer.parseInt(pagesize);				//将当前页面大小转换成int  类型
			queryInfo.setPagesize(page);
		}
		PageBean pageBean = new PageBean();						//pagebean对象
		pageBean.setCurrentpage(queryInfo.getCurrentpage());
		
	}
	
	
	//退出系统
	@RequestMapping("AdministratorLoginOut")
	public void AdministratorLoginOut(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ServletException, IOException{
		response.setCharacterEncoding("UTF-8");
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
		session.removeAttribute("SelectAllD  rugs_hDrugs");
		session.removeAttribute("SelectHDrugByHdrug_ids_hDrug");
		session.removeAttribute("SelectAllTreateRecords_SelectAllTreateRecords");
		session.removeAttribute("SelectTreateRecordByHtr_id_hTreaterecord");
		session.removeAttribute("TreatMoneyEnd_hpt_patientid");
		session.removeAttribute("TreatMoneyEnd_sum");
		session.removeAttribute("SelectTreateMoney_treatemoneys");
		session.removeAttribute("Account");
		PrintWriter out = response.getWriter();
		out.print("<script type='text/javascript'>");
		out.print("window.parent.location.href='AdministratorLogin.do'");
		out.print("</script>");
	}
}


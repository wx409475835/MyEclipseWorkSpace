package com.nyist.web.servlet;
import static org.hamcrest.CoreMatchers.nullValue;

import java.util.Date;
import java.util.ResourceBundle;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.nyist.domain.Cart;
import com.nyist.domain.CartItem;
import com.nyist.domain.Order;
import com.nyist.domain.OrderItem;
import com.nyist.domain.PageBean;
import com.nyist.domain.User;
import com.nyist.service.OrderService;
import com.nyist.service.impl.OrderServiceImpl;
import com.nyist.utils.BeanFactory;
import com.nyist.utils.PaymentUtil;
import com.nyist.utils.UUIDUtils;

/**
 * 订单模块
 */
@WebServlet("/order")
public class OrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	
	public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//判断是否登陆
		User user = (User) request.getSession(true).getAttribute("user");
		if(user!=null){
			//1.封装数据
			//不为空  封装数据
			Order order = new Order();
			//1.订单Id
			order.setOid(UUIDUtils.getId());
			//2.订单时间
			order.setOrdertime(new Date());
			//3.订单金额   获取Session中得Cart
			Cart cart = (Cart) request.getSession(true).getAttribute("cart");
			order.setTotal(cart.getTotal());
			//订单得所有订单项目
			for (CartItem item : cart.getItems()) {
				OrderItem oi = new OrderItem();
				//设置ID
				oi.setItemid(UUIDUtils.getId());
				//设置购买数量
				oi.setCount(item.getCount());
				//设置小计
				oi.setSubtotal(item.getSubtotal());
				//设置product 
				oi.setProduct(item.getProduct());
				//设置order
				oi.setOrder(order);
				//添加到List中去
				order.getItems().add(oi);
			}
			//4.设置用户
			order.setUser(user);
			//5.调用service 添加订单
			OrderService os = (OrderService) new OrderServiceImpl();
			os.add(order);
			//6.跳转
			request.getSession(true).setAttribute("bean",order);
		}else{
			request.getSession(true).setAttribute("msg","您还没有登陆,请先登陆吧!!");
			return "/jsp/msg.jsp";
		}
		//2.调用Service 
		//3.页面跳转，展示信息  
		return "/jsp/order_info.jsp";
	}

	public String findAllByPage(HttpServletRequest request,HttpServletResponse response) throws Exception{
		//1.获取当前页
		int currPage = Integer.parseInt(request.getParameter("currPage"));
		if(currPage==0){
			currPage=1;
		}
		//2.获取当前用户
		User user = (User)request.getSession(true).getAttribute("user");
		if(user==null){
			request.getSession(true).setAttribute("msg","您还没有登陆,请先登陆！！！");
			return "/jsp/msg.jsp";
		}
		//3.调用Service  分页查询:currPage,pagesize,user  返回PageBean
		OrderService orderService = new OrderServiceImpl();
		PageBean<Order> bean = orderService.findAllByPage(currPage,3,user);
		bean.getTotalPage();
		request.getSession(true).setAttribute("bean",bean);
		return "/jsp/order_list.jsp";
	}
	
	public String getById(HttpServletRequest request,HttpServletResponse response) throws Exception{
		//获得订单Id
		String oid = request.getParameter("oid");
		if(oid!=null){
			OrderService os = new OrderServiceImpl();
			Order order = os.getById(oid);
			request.getSession(true).setAttribute("bean",order);
		}else{
			request.getSession(true).setAttribute("msg","抱歉,没有此订单！！！");
			return "/jsp/msg.jsp";
		}
		return "/jsp/order_info.jsp";
	}
	
	
	//支付相关
	public String pay(HttpServletRequest request,HttpServletResponse respone) throws Exception{
		//接受参数
		String address=request.getParameter("address");
		String name=request.getParameter("name");
		String telephone=request.getParameter("telephone");
		String oid=request.getParameter("oid");
		
		//通过id获取order
		OrderService s=new OrderServiceImpl();
		Order order = s.getOrderByOid(oid);
		System.out.println("order:"+order);
		order.setAddress(address);
		order.setName(name);
		order.setTelephone(telephone);
		
		//更新order
		s.update(order);
		

		// 组织发送支付公司需要哪些数据
		String pd_FrpId = request.getParameter("pd_FrpId");							//银行通道
		String p0_Cmd = "Buy";														//业务类型
		String p1_MerId = ResourceBundle.getBundle("merchantInfo").getString("p1_MerId");
		String p2_Order = oid;														//订单编号
		String p3_Amt = "0.01";														//金额
		String p4_Cur = "CNY";														//货币 人民币
		String p5_Pid = "";															//商品ID
		String p6_Pcat = "";														
		String p7_Pdesc = "";
		// 支付成功回调地址 ---- 第三方支付公司会访问、用户访问
		// 第三方支付可以访问网址
		String p8_Url = ResourceBundle.getBundle("merchantInfo").getString("responseURL");//回调Url
		String p9_SAF = "";
		String pa_MP = "";
		String pr_NeedResponse = "1";												//应答机制
		// 加密hmac 需要密钥
		String keyValue = ResourceBundle.getBundle("merchantInfo").getString("keyValue");
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,				//创建密钥
				p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
				pd_FrpId, pr_NeedResponse, keyValue);
	
		
		//发送给第三方
		StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
		sb.append("p0_Cmd=").append(p0_Cmd).append("&");
		sb.append("p1_MerId=").append(p1_MerId).append("&");
		sb.append("p2_Order=").append(p2_Order).append("&");
		sb.append("p3_Amt=").append(p3_Amt).append("&");
		sb.append("p4_Cur=").append(p4_Cur).append("&");
		sb.append("p5_Pid=").append(p5_Pid).append("&");
		sb.append("p6_Pcat=").append(p6_Pcat).append("&");
		sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
		sb.append("p8_Url=").append(p8_Url).append("&");
		sb.append("p9_SAF=").append(p9_SAF).append("&");
		sb.append("pa_MP=").append(pa_MP).append("&");
		sb.append("pd_FrpId=").append(pd_FrpId).append("&");
		sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
		sb.append("hmac=").append(hmac);
		
		respone.sendRedirect(sb.toString());
		
		return null;
	}
	
	//支付成功之后的回调
	public String callback(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String p1_MerId = request.getParameter("p1_MerId");
		String r0_Cmd = request.getParameter("r0_Cmd");
		String r1_Code = request.getParameter("r1_Code");
		String r2_TrxId = request.getParameter("r2_TrxId");
		String r3_Amt = request.getParameter("r3_Amt");
		String r4_Cur = request.getParameter("r4_Cur");
		String r5_Pid = request.getParameter("r5_Pid");
		String r6_Order = request.getParameter("r6_Order");
		String r7_Uid = request.getParameter("r7_Uid");
		String r8_MP = request.getParameter("r8_MP");
		String r9_BType = request.getParameter("r9_BType");
		String rb_BankId = request.getParameter("rb_BankId");
		String ro_BankOrderId = request.getParameter("ro_BankOrderId");
		String rp_PayDate = request.getParameter("rp_PayDate");
		String rq_CardNo = request.getParameter("rq_CardNo");
		String ru_Trxtime = request.getParameter("ru_Trxtime");
		// 身份校验 --- 判断是不是支付公司通知你
		String hmac = request.getParameter("hmac");
		String keyValue = ResourceBundle.getBundle("merchantInfo").getString("keyValue");

		// 自己对上面数据进行加密 --- 比较支付公司发过来hamc
		boolean isValid = PaymentUtil.verifyCallback(hmac, p1_MerId, r0_Cmd,
				r1_Code, r2_TrxId, r3_Amt, r4_Cur, r5_Pid, r6_Order, r7_Uid,
				r8_MP, r9_BType, keyValue);
		if (isValid) {
			// 响应数据有效
			if (r9_BType.equals("1")) {
				// 浏览器重定向
				System.out.println("111");
				request.getSession(true).setAttribute("msg", "您的订单号为:"+r6_Order+",金额为:"+r3_Amt+"已经支付成功,等待发货~~");
				
			} else if (r9_BType.equals("2")) {
				// 服务器点对点 --- 支付公司通知你
				System.out.println("付款成功！222");
				// 修改订单状态 为已付款
				// 回复支付公司
				response.getWriter().print("success");
			}
			
			//修改订单状态  为已支付
			OrderService s=new OrderServiceImpl();
			Order order = s.getOrderByOid(r6_Order);
			order.setState(1);
			
			s.update(order);
			
		} else {
			// 数据无效
			System.out.println("数据被篡改！");
		}
		return "/jsp/msg.jsp";	
	}
}

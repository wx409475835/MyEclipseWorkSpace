package com.nyist.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nyist.domain.Cart;
import com.nyist.domain.CartItem;
import com.nyist.domain.Product;
import com.nyist.service.ProductService;
import com.nyist.service.impl.ProductServiceImpl;

/***
 * 购物车模块
 * @author LHG
 *
 */
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	public Cart getCart(HttpServletRequest request){
		Cart cart = (Cart)request.getSession(true).getAttribute("cart");
		//判断购物车是否为空
		if(cart==null){
			cart = new Cart();
			//添加到session中
			request.getSession(true).setAttribute("cart",cart);
		}
		return cart;
	}
	
    public String add(HttpServletRequest request,HttpServletResponse response) throws Exception{
    	//1.获取商品Id
    	String pid = request.getParameter("pid");
    	//获得购买 购买数量
    	String count = request.getParameter("count");
    	ProductService productService = new ProductServiceImpl();
    	//查询 该商品
    	Product product = productService.getProductById(pid);
    	//组成购物车项
    	CartItem cartItem = new CartItem(product, Integer.parseInt(count));
    	//加入购物车
    	Cart cart = getCart(request);
    	cart.add2Cart(cartItem);
    	response.sendRedirect(request.getContextPath()+"/jsp/cart.jsp");
    	return null;
    }
    public String remove(HttpServletRequest request,HttpServletResponse response) throws Exception{
    	//1.获取商品Id
    	String pid = request.getParameter("pid");
    	System.out.println("pid:"+pid);
    	//将 上购物车项  从购物车中删除
    	//获得当前购物车对象
    	Cart cart = getCart(request);
    	//将购物车 中得商品删除
    	cart.removeFormatCart(pid);
    	response.sendRedirect(request.getContextPath()+"/jsp/cart.jsp");
    	return null;
    }
    public String clear(HttpServletRequest request,HttpServletResponse response) throws Exception{
    	//将 上购物车项  从购物车中删除
    	//获得当前购物车对象
    	Cart cart = getCart(request);
    	//将购物车 中得商品删除
    	cart.clearCart();
    	//删除购物车
    	request.getSession(true).removeAttribute("bean");
    	response.sendRedirect(request.getContextPath()+"/jsp/cart.jsp");
    	return null;
    }
}

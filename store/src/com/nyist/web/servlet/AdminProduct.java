package com.nyist.web.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.nyist.domain.Category;
import com.nyist.domain.PageBean;
import com.nyist.domain.Product;
import com.nyist.domain.User;
import com.nyist.service.CategoryService;
import com.nyist.service.ProductService;
import com.nyist.service.impl.CategoryServiceImpl;
import com.nyist.service.impl.ProductServiceImpl;
import com.nyist.utils.UUIDUtils;
public class AdminProduct extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String findAll(HttpServletRequest request,HttpServletResponse response) throws Exception{
		int currPage = Integer.parseInt(request.getParameter("currPage"));
		if(currPage==0){
			currPage=1;
		}
		User user = (User) request.getSession(true).getAttribute("user");
		ProductService productService = new ProductServiceImpl();
		PageBean<Product> bean = productService.findByPageCategory(currPage,11);
		request.getSession(true).setAttribute("bean",bean);
		return "/admin/product/list.jsp";
	}
	
	//管理员添加商品
	public String addUI(HttpServletRequest request,HttpServletResponse response) throws Exception{
		//查询所属于分类
		CategoryService categoryService = new CategoryServiceImpl();
		List<Category> clist = categoryService.findAll();
		request.getSession(true).setAttribute("clist",clist);
		return "/admin/product/add.jsp";
	}
	
	//实现添加商品  上传的图图片 保存到/product/  文件上传
	public String add(HttpServletRequest request,HttpServletResponse response) throws Exception{
		//创建一个工厂  默认缓冲区大小为10k
		DiskFileItemFactory factory = new DiskFileItemFactory(); 
		//设置缓冲区大小为 1 M  如果上传文件大于1M,则上传的文件将不再保存在缓冲区,将会保存在临时文件中,读取数据的时候也会从临时文件中读取
		factory.setSizeThreshold(1024*1024);
		//设置临时文件保存目录   / 代表web工程    将/temp设置为临时保存文件目录
		factory.setRepository(new File(this.getServletContext().getRealPath("temp")));
		ServletFileUpload upload = new ServletFileUpload(factory); //创建解析器

		//在解析数据之前  做后台页面数据生成进度条
		upload.setProgressListener(new ProgressListener() {
			private long megaBytes = -1 ;
			@Override	//pBytesRead 总的字节数  pContentLength 内容长度  pItems 文件数量
			public void update(long pBytesRead, long pContentLength, int pItems) {
				long mBytes = pBytesRead / 1000000; 
				if(mBytes == -1){
					return ;
				}
				megaBytes = mBytes;
				System.out.println("已经读取文件个数:"+pItems);
				if(pContentLength == -1){
					System.out.println("已经读取"+pBytesRead+"字节");
				}else{
					System.out.println("正在读取了"+ pBytesRead +"字节");
				}
			}
		});

		//解决中文乱码问题
		upload.setHeaderEncoding("UTF-8");
		//限制单个文件上传大小   100 M
		upload.setFileSizeMax(1024*1024*100);
		//限制上传数据的类型
		List types = Arrays.asList(".png","gif","jpg");
		if(!upload.isMultipartContent(request)){ //若果不是上传表单数据
			//不是上传表单数据   则为 普通表单  打印出来
			String name = request.getParameter("username");
			System.out.println("name:"+name);
			return null;
		}
		//这里就是上传表单数据
		try {
			System.out.println("****************************上传文件开始**************************************");
			//调用解析器解析request,得到并保存所有上传数据的List
			List<FileItem> list = upload.parseRequest(request); 
			//创建需要封装数据的对象
			Product product = new Product();
			//调用Dao 插入到数据库中
			ProductService service = new ProductServiceImpl();
			//遍历FileItem 文件项
			String cid = null;
			String saveFileName=null ;
			for (FileItem item : list) {
				//判断是否为输入项
				if(item.isFormField()){ 
					if(item.getFieldName().equals("cid")){
						cid = item.getString();
					}else{
						//确认为输入项
						Map<String,Object> map = new HashedMap();
						String inputName = item.getFieldName(); // 获得文件的名称
						String inputvalue = item.getString(); // 获得文件的值
						String inputValue = new String(inputvalue.getBytes("iso8859-1"), "UTF-8"); // 解决get请求乱码
						System.out.println(inputName+"="+inputValue);
						map.put(inputName, inputValue);
						// 将数据封装到Product对象中
						BeanUtils.populate(product, map);
					}
				}else{
					//代表 输入项 中封装的是 文件
					String filename = item.getName(); 											//获取到文件名称
					String ext = filename.substring(filename.lastIndexOf(".")+1); 				//获得文件的扩展名
					if(filename==null || filename.trim().equals("")){
						continue;
					}
					/*if(!types.contains(ext)){
						request.setAttribute("message","本系统不支持上传"+ext+"文件类型");
						request.getRequestDispatcher("/message.jsp").forward(request, response);
						return null;
					}*/
					
					InputStream in = item.getInputStream(); 									//获得inputStream流
					//设置缓冲区
					int len = 0;
					byte buffer[] = new byte[1024]; 
					saveFileName = filename; 											//调用gerenate函数 生成唯一的文件名称
					String savepath = this.getServletContext().getRealPath("products");
					File file = new File(savepath);
					if(!file.exists()){
						file.mkdir();
					}
					//File.separator   常量分隔符   / 
					FileOutputStream out = new FileOutputStream(savepath + File.separator + saveFileName); //指定目录下
					while((len = in.read(buffer)) > 0){
						out.write(buffer,0,len);
					}
					in.close();
					out.close();
					item.delete(); 																//删除上传完毕后的临时文件
				}
			}
			//上传文件完毕  将文件的路径保存到对象中
			CategoryService categoryService = new CategoryServiceImpl();
			product.setCategory(categoryService.getById(cid));
			product.setPimage("products/"+saveFileName);
			System.out.println("pid:+"+product.getPid());
			if(product.getPid()==null){
				product.setPid(UUIDUtils.getId());
			}
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String date = simpleDateFormat.format(new Date());
			Date date2 = (Date) simpleDateFormat.parse(date);
			product.setPdate(date2);
			Product pd = service.getProductById(product.getPid());
			System.out.println("Pro:"+product+":"+pd);
			if(pd==null){
				service.addProduct(product);
			}else{
				service.update(product);
			}
		}catch (FileUploadBase.FileSizeLimitExceededException e) {
			request.setAttribute("msg","文件大小不能超过 100 M");
			response.sendRedirect(request.getContextPath()+"/jsp/msg.jsp");
			return null;
		}catch (FileUploadException e) {
			e.printStackTrace();
		}		
		response.sendRedirect(request.getContextPath()+"/adminProduct?method=findAll&currPage=1");
		return null;
	}
	
	//修改商品
	public String update(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String pid = request.getParameter("pid");
		Product product = new ProductServiceImpl().getProductById(pid);
		List<Category> clist = new CategoryServiceImpl().findAll();
		request.getSession(true).setAttribute("pd",product);
		request.getSession(true).setAttribute("clist",clist);
		request.getSession(true).setAttribute("cid", new ProductServiceImpl().getcIdBypId(pid));
		return "/admin/product/edit.jsp";
	}

	//删除商品
	public String delete(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String pid = request.getParameter("pid");
		ProductService pService = new ProductServiceImpl();
		pService.delete(pid);
		response.sendRedirect(request.getContextPath()+"/adminProduct?method=findAll&currPage=1");
		return null;
	}
}

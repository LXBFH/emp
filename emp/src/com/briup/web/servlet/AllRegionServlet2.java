package com.briup.web.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.briup.common.BeanFactory;
import com.briup.common.DBUtils;
import com.briup.model.PageInfo;
import com.briup.model.Region;
import com.briup.service.IRegionService;
import com.briup.service.impl.RegionServiceImpl;

@WebServlet("/region/allRegion.do")
public class AllRegionServlet2 extends HttpServlet{
	private static final long serialVersionUID = 1L;
	IRegionService service = (IRegionService)BeanFactory.getBean(
			BeanFactory.REGION_SERVICE);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageSizeStr = req.getParameter("pageSize");
		String pageNumStr = req.getParameter("pageNum");//当前页码
		int pageSize = 5;
		int pageNum = 1;
		if(pageSizeStr!=null&&!"".equals(pageSizeStr)) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		if(pageNumStr!=null&&!"".equals(pageNumStr)) {
			pageNum = Integer.parseInt(pageNumStr);
		}
		try{
			PageInfo<Region> pageInfo = 
					service.findByPage(pageSize, pageNum);
			req.setAttribute("pageInfo", pageInfo);
			//服务器内部跳转，共享同一个请求，
			//所以数据传输(servlet--jsp)时,可以将数据放在request范围。
			req.getRequestDispatcher("/region/region.jsp")
				.forward(req, resp);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

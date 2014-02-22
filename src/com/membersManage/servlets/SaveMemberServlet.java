package com.membersManage.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.membersManage.domain.Member;
import com.membersManage.service.IMemberService;

/**
 * Servlet implementation class SaveMemberServlet
 */
public class SaveMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private WebApplicationContext ctx;
    private IMemberService memberService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveMemberServlet() {
        super();
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
    	memberService =(IMemberService) ctx.getBean("memberService");
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet Menthod!");
		response.setStatus(200);
		RequestDispatcher rd = request.getRequestDispatcher("/responseSave4iPhone.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Save doPost Menthod!");
		InputStream is = null;
	 	InputStreamReader inputStreamReader  = null;
	 	BufferedReader br  = null;
		try {
			
			 is = request.getInputStream(); 
			 inputStreamReader =  new InputStreamReader(is,"UTF8"); 
			 br = new BufferedReader(inputStreamReader);
			 
		
			 String line;
			 String json = "";
			 while( ( line = br.readLine()) != null){
				 line = line.replace(" ", "");
				 json += line;
			 }
					 
			 JsonDeserializer<Date> deser = new JsonDeserializer<Date>() { 
				 public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
					      throws JsonParseException {
					 	
					    Date date = new Date();
					 	if(json.getAsString().equals("")){
					 		date.setTime(System.currentTimeMillis());
					 	}else{
					 		date = new Date(json.getAsLong());
					 	}
					    return json==null?null:date;
					  }
			};
			
			 Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, deser).create();
			 
			 Member member  = gson.fromJson(json, Member.class);
			 System.out.println(member);
			 memberService.save(member);
			 request.setAttribute("member", member);
			response.setStatus(200);
			RequestDispatcher rd = request.getRequestDispatcher("/responseSave4iPhone.jsp");
			rd.forward(request, response);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			IOUtils.closeQuietly(is);
		}
	}
	public IMemberService getMemberService() {
		return memberService;
	}
	public void setMemberService(IMemberService memberService) {
		this.memberService = memberService;
	}
}

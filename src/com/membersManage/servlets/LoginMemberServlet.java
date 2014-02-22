package com.membersManage.servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.Gson;
import com.membersManage.domain.Member;
import com.membersManage.service.IMemberService;

/**
 * Servlet implementation class LoginMemberServlet
 */
public class LoginMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private WebApplicationContext ctx; 
	private IMemberService memberService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
    	memberService =(IMemberService) ctx.getBean("memberService");
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Login doPost Menthod!");
		InputStream is = null;
	 	InputStreamReader inputStreamReader  = null;
	 	BufferedReader br  = null;
	 	OutputStreamWriter bos = null;
		BufferedWriter bw = null;
	 	try {
			
			 is = request.getInputStream(); 
			 inputStreamReader =  new InputStreamReader(is,"UTF8"); 
			 br = new BufferedReader(inputStreamReader);
			 bos = new OutputStreamWriter(response.getOutputStream());
			 bw = new BufferedWriter(bos);
			
			 String line;
			 Gson gson = new Gson();
			 if( (  line = br.readLine()) != null){
				 System.out.println(gson.fromJson(line, Member.class).getLoginAccEMail());
				 System.out.println(gson.fromJson(line, Member.class).getLoginPwd());
				 List<Member> members = memberService.find("select a from Member a where a.loginAccEMail = ? and a.loginPwd = ?", new Object[]{ gson.fromJson(line, Member.class).getLoginAccEMail(),  gson.fromJson(line, Member.class).getLoginPwd()});
				 if(!members.isEmpty()){
					Member member = members.get(0);	
					System.out.println(member);
					bw.write(gson.toJson(member));
				}else{
					bw.write("");
					 System.out.println("No Query Member");
				}
			 }
			 
				bw.flush();
	 	}catch (Exception e) {
			e.printStackTrace();
		}finally{
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(bos);
		
		}
	}


}

<%@page import="com.membersManage.domain.Member"%>
<% Member member = (Member)request.getAttribute("member"); %>
[註冊成功]<%=member.getMemberName().trim() %>歡迎您,請返回首頁登入．

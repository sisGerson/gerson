<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=iso-8859-1">
    <meta http-equiv="content-language" content="pt-br" />
    <meta name="description" content="GeRsON - Gerência de Recursos On-line" />
    <meta name="keywords" content="cadastro de cliente, controle de almoxarifado" />
    <link rel="stylesheet" type="text/css" href="css/screen.css">
    <!-- <link href="css/screen.css" type="text/css" rel="stylesheet" media="screen,projection" /> -->

    <title>GeRsON</title>
  </head>
  <body>

    <div id="layout">
      
      <div id="header">
        
        <h1 id="logo"><a href="#" title="#">GeRs<span>ON</span></a></h1>
        <hr class="noscreen" />   
          
              
        <div id="navigation">
        <ul>
          <li><a href="index.jsp?item=0">Início</a></li>
          <li><a href="index.jsp?item=1">Pessoa Física</a></li>
          <li><a href="index.jsp?item=2">Pessoa Jurídica</a></li>

        </ul>
        </div>
        <hr class="noscreen" />  
    
      </div>
      

<div id="main">

<!-- Organizando a navegação dos itens de menu -->
<% 
int item = Integer.parseInt(request.getParameter("item"));

switch(item)

{case 0://página principal
	%>
	<%@ include file="main.jsp" %>
	<%
break;
case 1://Opções Pessoa Física
	%>
	<%@ include file="item01.jsp" %>
	<%
break;
case 2: //Opções Pessoa Jurídica
	%>
	<%@ include file="item02.jsp" %>
	<%
break;
case 3: //Cadastrar Pessoa Pessoa Física
	%>
	<%@ include file="cadastro_pessoafisica.jsp" %>
	<%
break;
case 4: //Pesquisar/Alterar Pessoa Pessoa Física
	%>
	<%@ include file="pesquisa_pessoafisica.jsp" %>
	<%
break;
case 5: //Resultado Cadastro Pessoa Pessoa Física
	%>
	<%@ include file="resultado_pessoafisica.jsp" %>
	<%
break;
case 6: //Atualiza Pessoa Pessoa Física

break;
default:
%>
<%@ include file="main.jsp" %>
<%
};

%>
</div>
        
        <div id="footer">
        <div id="footer-inside">
        <p id="copyright">&copy; 2013 - <a href="index.jsp?item=0">GeRsON</a></p>
        
               <p >Equipe de Trabalho  | GPP/MDS</p>
        
        </div><div style="clear: both;"></div></div>
        </div>
  </body>
</html>
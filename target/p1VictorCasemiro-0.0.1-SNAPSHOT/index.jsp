<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prova 1 - Victor Casemiro</title>

<link
	href="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/css/bootstrap.min.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/jquery-3.6.0-dist/jquery-3.6.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>


</head>
<body>

	
	
	<div class="container">
		<div class="row">
			<div class="col">
				
<a href="${pageContext.request.contextPath}/CarroControle?acao=novo">Novo</a>
<br/>
<a href="${pageContext.request.contextPath}/CarroControle?acao=listar">Listar</a>

			</div>
		</div>
	</div>

</body>
</html>
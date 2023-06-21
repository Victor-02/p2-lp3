<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


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
				<h2>Novo Cachorro</h2>			
				
				<form
					action="${pageContext.request.contextPath}/CarroControle?acao=inserir"
					method="post">

					<div class="row mb-3">
						<label class="col-sm-1 col-form-label">Raça</label>
						<div class="col-sm-5">
							<input class="form-control" type="text" name="raca">
						</div>
					</div>

					<div class="row mb-3">
						<label class="col-sm-1 col-form-label">Tamanho</label>
						<div class="col-sm-3">
							<input class="form-control" type="text" name="tamanho">
						</div>
					</div>


					<div class="row mb-3">
						<label class="col-sm-1 col-form-label">Idade</label>
						<div class="col-sm-2">
							<input class="form-control" type="text" name="idade">
						</div>
					</div>

					<input class="btn btn-primary" type="submit" value="Gravar" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>
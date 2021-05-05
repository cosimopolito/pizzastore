<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="it">
	<head>
		<jsp:include page="/header.jsp" />
		<title>Pagina dei risultati</title>
		
		<!-- style per le pagine diverse dalla index -->
	    <link href="${pageContext.request.contextPath}/assets/css/global.css" rel="stylesheet">
	    
	</head>
	<body>
		<jsp:include page="/navbar.jsp" />
		
		<main role="main" class="container">
		
			<div class="alert alert-success alert-dismissible fade show ${successMessage==null?'d-none': ''}" role="alert">
			  ${successMessage}
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>
			<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none': ''}" role="alert">
			  ${errorMessage}
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>
			<div class="alert alert-danger alert-dismissible fade show d-none" role="alert">
			  Esempio di operazione fallita!
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>
			<div class="alert alert-info alert-dismissible fade show d-none" role="alert">
			  Aggiungere d-none nelle class per non far apparire
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>
			
			<div class='card'>
			    <div class='card-header'>
			        <h5>Lista dei risultati</h5> 
			    </div>
			    <div class='card-body'>
			    	<a class="btn btn-primary " href="PrepareInsertUtenteServlet">Add New</a>
			    	<a href="PrepareSearchUtenteServlet" class='btn btn-outline-secondary' >
			            <i class='fa fa-chevron-left'></i> Torna alla Ricerca
			        </a>
			    
			        <div class='table-responsive'>
			            <table class='table table-striped ' >
			                <thead>
			                    <tr>
			                        <th>Username</th>
			                        <th>Nome</th>
			                        <th>Cognome</th>
			                        <th>Data di Creazione</th>
			                     <!--    <th>Ruolo</th> -->
			                        <th>Azioni</th>
			                    </tr>
			                </thead>
			                <tbody>
			                	<c:forEach items="${utente_list_attribute }" var="utenteItem">
									<tr>
										<td>${utenteItem.username }</td>
										<td>${utenteItem.nome }</td>
										<td>${utenteItem.cognome }</td>
										<td>${utenteItem.dateCreated}</td>
										
										<%-- <c:forEach items="${utenteItem.ruoli}" var="ruoloItem">
										<td>${ruoloItem}</td>
										</c:forEach> --%>
										
										<td>${utenteItem.stato}</td>
										
										<td>
											<a class="btn  btn-sm btn-outline-secondary" href="ExecuteVisualizzaUtenteServlet?idUtente=${utenteItem.id }">Visualizza</a>
											<a class="btn  btn-sm btn-outline-primary ml-2 mr-2" href="PrepareUpdateUtenteServlet?idUtente=${utenteItem.id }">Edit</a>
											
											<c:if test = "${utenteItem.stato == 'DISABILITATO' || utenteItem.stato == 'CREATO'}">
                                                <a class="btn btn-outline-success btn-sm" href="ExecuteCambiaStatoUtenteServlet?idUtente=${utenteItem.id }">Attiva</a>
                                              </c:if>
                                              <c:if test = "${utenteItem.stato == 'ATTIVO'}">
                                                <a class="btn btn-outline-danger btn-sm" href="ExecuteCambiaStatoUtenteServlet?idUtente=${utenteItem.id }">Disabilita</a>
                                            </c:if>
									</tr>
								</c:forEach>
			                </tbody>
			            </table>
			        </div>
			   
				<!-- end card-body -->			   
			    </div>
			</div>	
		
		<!-- end container -->	
		</main>
		<jsp:include page="/footer.jsp" />

	</body>
</html>
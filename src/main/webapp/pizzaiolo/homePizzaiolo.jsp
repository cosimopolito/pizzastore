<%--
  Created by IntelliJ IDEA.
  User: Stefano
  Date: 04/05/2021
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="it">
<head>

    <jsp:include page="../header.jsp" />

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/assets/css/global.css" rel="stylesheet" type="text/css">
    <style type="text/css">
        body {
            padding-top: 3.5rem;
        }
    </style>

    <title>Gestione Pizza Store</title>
</head>
<body>

<jsp:include page="../navbar.jsp" />


<main role="main">

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron" >
        <div class="container">
            <h1 class="display-3">Benvenuto alla Gestione del Pizza Store</h1>
            <p>This is a template for a simple marketing or informational website. It includes a large callout called a jumbotron and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
        </div>
    </div>

    <div class="container">

        <div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none': ''}" role="alert">
            ${errorMessage}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>


        <!-- Example row of columns -->
        <div class="row">
            <div class="col-md-6">
                <h2>Gestione Ingredienti</h2>
                <p>Questa funzionalit� � realtiva alla Gestione degli igredienti</p>
                <p><a class="btn btn-primary" href="PrepareSearchUtenteServlet" role="button">Vai alla Funzionalit� &raquo;</a></p>
            </div>
            <div class="col-md-6">
                <h2>Gestione pizze</h2>
                <p>Questa funzionalit� � realtiva alla gestione delle pizze</p>
                <p><a class="btn btn-primary" href="PrepareSearchOrdineServlet" role="button">Vai alla Funzionalit� &raquo;</a></p>
            </div>
            <div class="col-md-6">
                <h2>Gestione Clienti</h2>
                <p>Questa funzionalit� � realtiva alla Gestione dei clienti</p>
                <p><a class="btn btn-primary" href="PrepareSearchUtenteServlet" role="button">Vai alla Funzionalit� &raquo;</a></p>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6">
                <h2>Nuovo Ordine</h2>
                <p>Questa funzionalit� � realtiva alla creazione degli ordini</p>
                <p><a class="btn btn-primary" href="PrepareSearchOrdineServlet" role="button">Vai alla Funzionalit� &raquo;</a></p>
            </div>
            <div class="col-md-6">
                <h2>Gestione Ordini</h2>
                <p>Questa funzionalit� � realtiva alla Gestione degli ordini</p>
                <p><a class="btn btn-primary" href="PrepareSearchUtenteServlet" role="button">Vai alla Funzionalit� &raquo;</a></p>
            </div>
        </div>

        <hr>

    </div> <!-- /container -->

</main>

<jsp:include page="../footer.jsp" />
</body>
</html>
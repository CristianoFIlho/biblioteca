<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"><html>
<head>
<link rel="stylesheet" href='<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>' />
<link rel="stylesheet" href='<c:url value="/resources/izitoast/css/iziToast.min.css"/>' />
<link rel="stylesheet"
	href='<c:url value="/resources/css/style.css"/>' />
<script
	src="<c:url value="/resources/javascript/jquery/jquery-3.3.1.min.js" />"></script>
<script src="<c:url value="/resources/javascript/popper.min.js" />"></script>
<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
<title>Home</title>
</head>
<body>

    <div id="wrapper" style="background-color:darkcyan;">

        <!-- Sidebar -->
        <div id="sidebar-wrapper" style="background-color:darkcyan;">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#" style="color: white;">
                        Biblioteca-UFAB
                    </a>
                </li>

                <li>
                    <div class="dropdown">
                        <button class="btn btn-dark dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
                            aria-expanded="false">
                            Item da Biblioteca
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <a class="dropdown-item" href="#">Listar</a>
                            <a class="dropdown-item" href="#">Cadastrar</a>

                        </div>
                    </div>
                    <li>
                        <div class="dropdown">
                            <button class="btn btn-dark dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
                                aria-expanded="false">
                                Aluno(a)
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                <a class="dropdown-item" href="#">Listar</a>
                                <a class="dropdown-item" href="#">Cadastrar</a>

                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="dropdown">
                            <button class="btn btn-dark dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
                                aria-expanded="false">
                                Funcion�rio(a)
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                <a class="dropdown-item" href="#">Listar</a>
                                <a class="dropdown-item" href="#">Cadastrar</a>
                                <a class="dropdown-item" href="#"></a>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="dropdown">
                            <button class="btn btn-dark dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
                                aria-expanded="false">
                                Empr�stimo
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                <a class="dropdown-item" href="#">Listar</a>
                                <a class="dropdown-item" href="#">Cadastrar</a>
                                <a class="dropdown-item" href="#"></a>
                            </div>
                        </div>
                        <div class="dropdown">
                            <button class="btn btn-dark dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
                                aria-expanded="false">
                                Reservar
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                <a class="dropdown-item" href="#">Listar</a>
                                <a class="dropdown-item" href="#">Cadastrar</a>
                                <a class="dropdown-item" href="#"></a>
                            </div>
                        </div>
                    </li>
                    <li>
                        <a href="#" style="color: white;">D�vida</a>
                    </li>
                    <li>
                        <a href="#" style="color: white;">Configura��o</a>
                    </li>

                     <li>
                        <a href="#" style="color: white;">Sobre</a>
                    </li>

            </ul>
        </div>


        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <nav class="navbar">
                    <a class="navbar-brand btn btn-dark" href="#menu-toggle" id="menu-toggle">
                        <span class="glyphicon glyphicon-print"></span>Menu</a>
                </nav>
            </div>
        </div>

        <div class="modal-content">
            <div>
                <form class="form-inline" style="margin-left:-97%; margin: 3%;">
                    <input class="form-control mr-sm-2" type="search" placeholder="Procurar" aria-label="Search" style="margin-left:70%;">
                    <button class="btn btn-dark my-2 my-sm-0" type="submit">Procurar</button>
                </form>
            </div>
     <h3 style="margin-left: 40%;">Lista de Empr�stimos</h3>
    <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">C�digo do Item</th>
                    <th scope="col">T�tulo do Item</th>
                    <th scope="col">Matr�cula do aluno</th>
                    <th scope="col">Data da Entrega</th>
                    <th scope="col">Data da Devolu��o</th>
                    <th scope="col">Qtd de dias para devolu��o</th>
                    <th scope="col">Devolu��o</th>


                    
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th scope="row">526</th>
                    <td>Capitu</td>
                    <td>142083526</td>
                    <td>15/05/2018</td>
                    <td>30/05/2018</td>
                    <td>15 dias</td>
                    <td>N�o</td>
                    
                </tr>
              
            </tbody>
        </table>
	
	<script type="text/javascript" src="<c:url value="/resources/izitoast/js/iziToast.min.js" />"></script>
	<script type="text/javascript" src="/resources/javascript/action.js"></script>
</body>
</html>

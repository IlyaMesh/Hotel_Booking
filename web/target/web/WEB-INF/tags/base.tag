<%@ tag description="Base tag" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <style >
        /* navbar */
        .navbar-default {
            background-color: #4C586F;
            border-color: #E7E7E7;
        }
        /* Title */
        .navbar-default .navbar-brand {
            color: #777;
        }
        .navbar-default .navbar-brand:hover,
        .navbar-default .navbar-brand:focus {
            color: #5E5E5E;
        }
        /* Link */
        .navbar-default .navbar-nav > li > a {
            color: red;
        }
        .navbar-default .navbar-nav > li > a:hover,
        .navbar-default .navbar-nav > li > a:focus {
            color: red;
        }
        .navbar-default .navbar-nav > .active > a,
        .navbar-default .navbar-nav > .active > a:hover,
        .navbar-default .navbar-nav > .active > a:focus {
            color: red;
            background-color: red;
        }
        .navbar-default .navbar-nav > .open > a,
        .navbar-default .navbar-nav > .open > a:hover,
        .navbar-default .navbar-nav > .open > a:focus {
            color: red;
            background-color: red;
        }
        /* Caret */
        .navbar-default .navbar-nav > .dropdown > a .caret {
            border-top-color: #777;
            border-bottom-color: #777;
        }
        .navbar-default .navbar-nav > .dropdown > a:hover .caret,
        .navbar-default .navbar-nav > .dropdown > a:focus .caret {
            border-top-color: #333;
            border-bottom-color: #333;
        }
        .navbar-default .navbar-nav > .open > a .caret,
        .navbar-default .navbar-nav > .open > a:hover .caret,
        .navbar-default .navbar-nav > .open > a:focus .caret {
            border-top-color: #555;
            border-bottom-color: #555;
        }
        /* Mobile version */
        .navbar-default .navbar-toggle {
            border-color: #DDD;
        }
        .navbar-default .navbar-toggle:hover,
        .navbar-default .navbar-toggle:focus {
            background-color: #DDD;
        }
        .navbar-default .navbar-toggle .icon-bar {
            background-color: #CCC;
        }
        @media (max-width: 767px) {
            .navbar-default .navbar-nav .open .dropdown-menu > li > a {
                color: #777;
            }
            .navbar-default .navbar-nav .open .dropdown-menu > li > a:hover,
            .navbar-default .navbar-nav .open .dropdown-menu > li > a:focus {
                color: #333;
            }
            .navbar-light .navbar-nav .nav-item .nav-link{
                color: red;
            }
        }
    </style>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Hotel Booking</title>
</head>
<body style="background-color : #cdc3c1">
    <!-- As a heading -->
    <nav class="navbar navbar-expand-lg navbar-default nav navbar-light" style="background-color: #4C5870;" >
        <a class="navbar-brand" href="${pageContext.request.contextPath}/chains"><img alt="Brand" width="120" height="75" src="${pageContext.request.contextPath}/images/logo.png"></a>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a style="background-color: #cdc3c1; margin: 10px;width: 120px; text-align: center" class="nav-item nav-link" href="${pageContext.request.contextPath}/chains">Brands</a>
                <a style="background-color: #cdc3c1; margin: 10px;width: 120px; text-align: center" class="nav-item nav-link" href="${pageContext.request.contextPath}/hotel">Hotels</a>
                <a style="background-color: #cdc3c1; margin: 10px;width: 120px; text-align: center"   class="nav-item nav-link" href="${pageContext.request.contextPath}/info">Info</a>
            </div>
        </div>
    </nav>
    <div class="container" style="background-color: #EBEDEC; margin-top: 35px; margin-bottom: 35px;">
    <jsp:doBody/>
    </div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
<footer class="footer" style="background-color: #3D3D3B; color: white; position: fixed;bottom: 0;right: 0;left: 0" >
    <div class="container text-center">
        <small>Copyright &copy; Website for hotel's booking.</small>
    </div>
</footer>
</html>
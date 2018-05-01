<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel='stylesheet' 
            href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css' 
            integrity=sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ
            crossorigin='anonymous'>
        <script src='https://code.jquery.com/jquery-3.1.1.slim.min.js ' 
            integrity='sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n' 
            crossorigin='anonymous'>
        </script>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js' 
            ntegrity='sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb' crossorigin='anonymous'>
        </script>
        <script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js' 
            integrity='sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn' crossorigin='anonymous'>
        </script>
    </head>
    <body>
        <nav class='navbar navbar-toggleable-md navbar-inverse bg-inverse navbar-default'>
            <button class='navbar-toggler navbar-toggler-right' 
                    type='button' data-toggle='collapse' data-target='#navbarsExampleDefault' 
                    aria-controls='navbarsExampleDefault' aria-expanded='false' aria-label='Toggle navigation'>
		        <span class='navbar-toggler-icon '>
                </span>
            </button>
            <a class='navbar-brand ' href='# '>Acme Corp</a>
    	    <div class='collapse navbar-collapse ' id='navbarsExampleDefault'>
                <ul class='navbar-nav mr-auto'>
            	    <li class='nav-item active'>
                	    <a class='nav-link ' href='# '>Home <span class='sr-only '>(current)</span></a>
                    </li>
                    <li class='nav-item '><a class='nav-link disabled ' href='# '>Settings</a></li>
                    <li class='nav-item '><a class='nav-link disabled ' href='# '>Admin</a></li>
                    <li class='nav-item '><a class='nav-link disabled ' href='# '>Reports</a></li>
                </ul>
            </div>
        </nav>
    
        <main class='col-sm-9'>
            <h1>Customers</h1>
            <p>Active customer list</p>
            <div class='table-responsive '>
                <table class='table table-striped '>
                    <thead><tr><th>First</th><th>Last</th><th>Email</th><th>Id</th></tr></thead>
                    ${customers}
                </table>
            </div>
            <span class='border'>      
                <form action='new'>
                    <div class="form-group">
                        <label for="firstName">First name</label>
                        <input type="text" class="form-control" name="firstName" id="firstName" placeholder="First...">
                    </div>
                    <div class="form-group">
                        <label for="lastName">Last name</label>
                        <input type="text" class="form-control" name="lastName" id="lastName" placeholder="Last...">
                    </div>
                    <!--
                    <div class="form-group">
                            <label for="email">Email</label>
                            <input type="email" class="form-control" name="email" id="email" placeholder="...@company.com">
                    </div>
                    -->
                    <input type='submit' class='btn btn-primary' value='Add'>
                </form>
            </span>
        </main>
    </body>
</html>

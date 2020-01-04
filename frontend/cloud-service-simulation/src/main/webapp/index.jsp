<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
    <link rel="stylesheet" href="css/mystyles.css">
    <title>Login page</title>
  </head>
  <body>
    <div class="row">
      <div class="input-field col s4 push-s4">
        <input type="text" id="username" placeholder=" " pattern="^[a-z0-9_-]{3,15}$" autocomplete="off"
        title="Username can be between 3 and 15 characters(letters, numbers, _ , - )">
        <label for="username">Username: </label>
        <div class="error"></div>
      </div>
    </div>
  
    <div class="row">
      <div class="input-field col s4 push-s4">
        <input type="password" id="password" class="validate" placeholder=" "
        pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$" 
        title="Password must contain uppercase and lowercase letters, number/special character and minimum 8 characters">
        <label for="password">Password: </label>
        <div class="error"></div>
      </div>
    </div>

    <div class="row">
      <button class="btn waves-effect waves-light col push-s5" type="submit" id="login">Login
        <i class="material-icons right">send</i>
      </button>
      <button class="btn waves-effect waves-light col push-s5" type="submit" id="register">Register
        <i class="material-icons right">send</i>
      </button>
    </div>
    ​
    <script type="text/javascript" src="js/materialize.min.js"></script>
    <script src="js/login.js"></script>
  </body>
</html>


* {
  margin: 0;
  padding: 0;
}

body {
  font-family: Arial, Tahoma
}

/* Start Header */
.main {
  background-color: #333;
  color : #DDD ;
  padding : 20px;
  text-align: center

}
nav {
  background-color: #DDD
}
nav ul {
  padding: 20px;
}
nav ul li {
  display: inline-block;
}

nav ul li:after {
  content: " |"
}

nav ul li:last-child:after{
  content: ""
}

/* Article */

article {
  padding : 20px;
  background-color: #F6F6F6;
  border: 1px solid #CCC;
  margin: 20px
}
